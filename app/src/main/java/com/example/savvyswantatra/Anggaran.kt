package com.example.savvyswantatra
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.savvyswantatra.component.AnggaranData
import com.example.savvyswantatra.component.Anggaran_card
import com.example.savvyswantatra.navigation.Screen
import com.example.savvyswantatra.ui.theme.PurpleSavvy1
import com.example.savvyswantatra.ui.theme.Typography
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.platform.LocalContext
import com.example.savvyswantatra.database.AppDatabase
import com.example.savvyswantatra.viewModel.AddAnggaranViewModel
import com.example.savvyswantatra.viewModel.AddAnggaranViewModelFactory
import com.example.savvyswantatra.viewModel.AnggaranViewModel
import com.example.savvyswantatra.viewModel.AnggaranViewModelFactory


@Composable
fun AnggaranScreen(navController: NavController) {
    val context = LocalContext.current
    val anggaranDao = AppDatabase.getInstance(context).anggaranDao()
    val kategoriAnggaranDao = AppDatabase.getInstance(context).kategoriAnggaranDao()
    val anggaranViewModel: AnggaranViewModel = viewModel(
        factory = AnggaranViewModelFactory(anggaranDao,kategoriAnggaranDao)
    )
    val anggaranList by anggaranViewModel.anggaranList.observeAsState(emptyList())

    Column {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(end = 20.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Row(
                modifier = Modifier.padding(16.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                IconButton(onClick = { navController.popBackStack() }) {
                    Icon(Icons.Filled.ArrowBack, contentDescription = "Kembali", tint = Color.Black)
                }
                Text(
                    text = "ANGGARAN",
                    style = Typography.displayMedium,
                    color = PurpleSavvy1
                )
            }
            IconButton(onClick = {
                navController.navigate(Screen.tambahAnggaran.route)
            }
            ) {
                Icon(
                    Icons.Default.Add,
                    contentDescription = "",
                    tint = Color.Black,
                )
            }
        }

        LazyColumn(
            modifier = Modifier.fillMaxHeight(),
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            if (anggaranList.isEmpty()) {
                item {
                    Column(
                        modifier = Modifier
                            .fillMaxSize()
                            .offset(y = 200.dp),
                        verticalArrangement = Arrangement.Center,
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        Image(
                            painterResource(id = R.drawable.notfound),
                            contentDescription = "",
                            modifier = Modifier.size(200.dp)
                        )
                        Text(text = "Tidak ada anggaran", style = Typography.bodyMedium, color = Color.LightGray, modifier = Modifier.offset(y = (-20).dp))
                    }
                }
            } else {
                items(anggaranList) { anggaran ->
                    Anggaran_card(
                        imageResources = anggaran.imageResources,
                        label = anggaran.nama,
                        nominal = anggaran.jumlah,
                        onDelete = { anggaranViewModel.removeAnggaran(anggaran) },
                        onCardClick = { navController.navigate("detailAnggaran/${anggaran.nama}") }
                    )
                }
            }
        }
    }
}