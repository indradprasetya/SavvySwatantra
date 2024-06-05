package com.example.savvyswantatra
import android.graphics.drawable.Icon
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.requiredSize
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.AddCircle
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.savvyswantatra.component.Anggaran
import com.example.savvyswantatra.component.AnggaranData
import com.example.savvyswantatra.component.Anggaran_card
import com.example.savvyswantatra.navigation.Screen
import com.example.savvyswantatra.ui.theme.OrangeSavvy
import com.example.savvyswantatra.ui.theme.PurpleSavvy1
import com.example.savvyswantatra.ui.theme.Typography
import com.example.savvyswantatra.ui.theme.WhiteSavvy
import org.intellij.lang.annotations.JdkConstants.HorizontalAlignment


@Composable
fun AnggaranScreen(navController: NavController) {
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
            if (AnggaranData.anggaranList.isEmpty()) {
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
                items(AnggaranData.anggaranList) { anggaran ->
                    Anggaran_card(
                        imageResources = anggaran.imageResources,
                        label = anggaran.nama,
                        nominal = anggaran.jumlah,
                        onDelete = { AnggaranData.anggaranList.remove(anggaran) },
                        onCardClick = {navController.navigate("detailAnggaran/${anggaran.nama}")}
                    )
                }
            }
        }

    }
}
