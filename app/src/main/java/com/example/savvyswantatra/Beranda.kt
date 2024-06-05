package com.example.savvyswantatra

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AddCircle
import androidx.compose.material.icons.filled.DateRange
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.savvyswantatra.component.AnggaranData
import com.example.savvyswantatra.component.Detail_kategori_card
import com.example.savvyswantatra.component.KategoriAnggaran
import com.example.savvyswantatra.component.MainCard
import com.example.savvyswantatra.component.TampilAnggaran
import com.example.savvyswantatra.component.Transaksi
import androidx.navigation.compose.rememberNavController
import com.example.savvyswantatra.navigation.Screen
import com.example.savvyswantatra.ui.theme.OrangeSavvy
import com.example.savvyswantatra.ui.theme.PinkSavvy
import com.example.savvyswantatra.ui.theme.PurpleSavvy1
import com.example.savvyswantatra.ui.theme.PurpleSavvy2
import com.example.savvyswantatra.ui.theme.Typography
import com.example.savvyswantatra.ui.theme.WhiteSavvy

@Composable
fun BerandaScreen(navController: NavController,addedCategories: MutableList<KategoriAnggaran>) {

    Row(
        modifier = Modifier
            .padding(20.dp)
            .padding(top = 5.dp),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically, // Menata elemen secara vertikal di tengah
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
        IconButton(onClick ={} ) {
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
                .padding(bottom = 4.dp, end = 2.dp) ,
            verticalAlignment = Alignment.CenterVertically
        ) {
            items(addedCategories) { kategori ->
                TampilAnggaran(
                    imageResource = kategori.imageResources,
                    keterangan = kategori.nama,
                    jumlah_saldo = "0",
                    batas_anggaran = kategori.batas_anggaran ?: 0.0,
                    navController = navController
                )
            }
        }
    }
}


