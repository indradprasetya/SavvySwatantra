package com.example.savvyswantatra

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.example.savvyswantatra.component.MainCard
import com.example.savvyswantatra.component.TampilAnggaran
import com.example.savvyswantatra.component.Transaksi
import com.example.savvyswantatra.navigation.Screen
import com.example.savvyswantatra.ui.theme.PurpleSavvy1
import com.example.savvyswantatra.ui.theme.PurpleSavvy2
import com.example.savvyswantatra.ui.theme.Typography
import com.example.savvyswantatra.viewModel.AnggaranViewModel
import com.example.savvyswantatra.viewModel.AnggaranViewModelFactory
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import com.example.savvyswantatra.database.AppDatabase
import com.example.savvyswantatra.viewModel.DetailScreenViewModel
import com.example.savvyswantatra.viewModel.DetailScreenViewModelFactory
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.collectLatest


@Composable
fun BerandaScreen(navController: NavController) {
    val context = LocalContext.current
    val anggaranDao = AppDatabase.getInstance(context).anggaranDao()
    val kategoriAnggaranDao = AppDatabase.getInstance(context).kategoriAnggaranDao()
    val transaksiDao = AppDatabase.getInstance(context).transaksiDao()
    val viewModel: AnggaranViewModel = viewModel(
        factory = AnggaranViewModelFactory(anggaranDao,kategoriAnggaranDao)
    )
    val DetailviewModel: DetailScreenViewModel = viewModel(
        factory = DetailScreenViewModelFactory(kategoriAnggaranDao, transaksiDao)
    )

    val anggaranList by viewModel.anggaranList.observeAsState(emptyList())
    val anggaran = anggaranList.find { it.nama != "" }
    val kategoriAnggaran by DetailviewModel.categories.collectAsState()
    val kategoriAnggaranList = kategoriAnggaran.filter { it.batas_anggaran != 0.0 }
    val transaksiList by DetailviewModel.transactions.observeAsState(emptyList())

    Row(
        modifier = Modifier
            .padding(20.dp)
            .padding(top = 5.dp),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center,
            modifier = Modifier.padding(start = 5.dp)
        ) {
            val image: Painter = painterResource(id = R.drawable.zhaolusi)
            Image(
                painter = image,
                contentDescription = null,
                modifier = Modifier
                    .clip(CircleShape)
                    .size(50.dp)
                    .clickable(onClick = { navController.navigate(Screen.profil.route) }),
                contentScale = ContentScale.Crop,
            )
            Spacer(modifier = Modifier.width(12.dp))
            Text(
                text = "Annie",
                color = PurpleSavvy2
            )
        }
        Spacer(modifier = Modifier.width(205.dp))
        IconButton(onClick = {} ) {
            Icon(
                Icons.Default.Notifications,
                contentDescription = null,
                tint = PurpleSavvy2,
                modifier = Modifier.size(24.dp)
            )
        }
    }
    Column {
        MainCard(navController)
        Transaksi()
        Row(
            modifier = Modifier.padding(start = 30.dp, top = 25.dp)
        ) {
            Text(
                text = "Sudah Habis Berapa Bulan ini?",
                style = Typography.displayMedium,
                color = PurpleSavvy1
            )
        }
        LazyRow(
            Modifier
                .padding(bottom = 4.dp, end = 2.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            items(kategoriAnggaranList) { kategori ->
                val transaksiForThisKategori =
                    transaksiList.filter { it.namaKategori == kategori.nama && it.namaAnggaran == kategori.namaAnggaran }
                val totalJumlahForThisKategori = transaksiForThisKategori.sumByDouble { it.jumlah }
                    TampilAnggaran(
                        imageResource = kategori.imageResources,
                        keterangan = kategori.nama,
                        jumlah_saldo = totalJumlahForThisKategori,
                        batas_anggaran = kategori.batas_anggaran ?: 0.0,
                        navController = navController,
                        namaAnggaran = kategori.namaAnggaran ?: "",
                        jumlah = totalJumlahForThisKategori
                    )

            }
        }
    }
}



