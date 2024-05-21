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
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.savvyswantatra.navigation.Screen
import com.example.savvyswantatra.ui.theme.OrangeSavvy
import com.example.savvyswantatra.ui.theme.PinkSavvy
import com.example.savvyswantatra.ui.theme.PurpleSavvy1
import com.example.savvyswantatra.ui.theme.PurpleSavvy2
import com.example.savvyswantatra.ui.theme.Typography
import com.example.savvyswantatra.ui.theme.WhiteSavvy

@Composable
fun BerandaScreen(navController: NavController) {
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
                    .clickable(onClick = {navController.navigate(Screen.profil.route)}),
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
        MainCard()
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
                .padding(top = 20.dp)
                .padding(bottom = 4.dp, end = 2.dp) ,
            verticalAlignment = Alignment.CenterVertically
        ) {
            item {
                TampilAnggaran(imageResource = R.drawable.makan, keterangan = "Makanan", jumlah_saldo = "490.000/700.000")
            }
            item {
                TampilAnggaran(imageResource = R.drawable.makan, keterangan = "Makanan", jumlah_saldo = "490.000/700.000")
            }
            // Anda bisa menambahkan lebih banyak item di sini
        }
    }


    }



@Composable
fun MainCard() {
    Card(
        shape = RoundedCornerShape(20.dp),
        modifier = Modifier
            .padding(24.dp)
            .padding(top = 70.dp)
            .width(350.dp) // Set the width of the card to 318.dp
            .height(155.dp), // Set the height of the card to 141.dp
        colors = CardDefaults.cardColors(containerColor = PurpleSavvy1)
    ) {
        Column {
            Row(horizontalArrangement = Arrangement.SpaceBetween) {
                Column(
                    modifier = Modifier.padding(24.dp)
                ) {
                    Text(
                        text = "Saldo Total",
                        style = Typography.displayMedium,
                        fontWeight = FontWeight.Normal,
                        color = WhiteSavvy
                    )
                    Spacer(modifier = Modifier.height(8.dp))
                    Text(
                        text = "Rp.5.000.000",
                        style = Typography.bodyLarge,
                        color = WhiteSavvy
                    )
                }
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    modifier = Modifier
                        .padding(top = 10.dp)
                        .padding(start = 15.dp),
                ) {
                    IconButton(onClick ={}) {
                        Icon(
                            Icons.Default.AddCircle,
                            contentDescription = "add",
                            modifier = Modifier
                                .size(24.dp)
                                .offset(x = 10.dp),
                            tint = OrangeSavvy
                        )
                    }
                    Text(
                        text = "Tambah Pemasukan",
                        color = WhiteSavvy,
                        style = Typography.labelSmall
                    )
                }

            }
            LazyRow(
                Modifier
                    .padding(bottom = 4.dp, end = 25.dp) // Menambahkan padding di akhir LazyRow
                    .offset(x = 22.dp)
                    .offset(y = (-10).dp),
                horizontalArrangement = Arrangement.spacedBy(16.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                item {
                    SubSaldo(imageResource = R.drawable.cash, keterangan = "Uang Tunai", jumlah_saldo ="3.000.000")
                }
                item {
                    SubSaldo(imageResource = R.drawable.bca, keterangan = "Bank BCA", jumlah_saldo ="2.000.000")
                }
                item {
                    SubSaldo(imageResource = R.drawable.mandiri, keterangan = "Bank Mandiri", jumlah_saldo ="3.000.000")
                }
            }

        }
    }

}
@Composable
fun Transaksi() {
    Row(
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier
            .padding(start = 30.dp, end = 15.dp)
            .fillMaxWidth(),
    ) {
        Column {
            Text(
                text = "Transaksi",
                style = Typography.displayMedium,
                color = PurpleSavvy1
            )
            Text(
                text = "19 juni 2024",
                style = Typography.bodySmall,
                color = PurpleSavvy1
            )
        }
        IconButton(onClick = {}) {
            Icon(
                Icons.Default.DateRange,
                contentDescription = "",
                tint = OrangeSavvy,
                modifier = Modifier.size(24.dp)
            )
        }
    }
    KatalogTransaksi(
        imageResource = R.drawable.makan,
        keterangan ="Makan Warteg" ,
        waktu = "07.20",
        kategori = "Uang Tunai" ,
        jumlah_saldo = "-Rp10.000",
        warna = Color.Red
    )
    KatalogTransaksi(
        imageResource = R.drawable.income,
        keterangan ="THR dari sepuh Indra" ,
        waktu = "09.20",
        kategori = "Bank BCA" ,
        jumlah_saldo = "+Rp18.000",
        warna = Color(0xff039F00)
    )
    KatalogTransaksi(
        imageResource = R.drawable.makan,
        keterangan ="Makan Mie" ,
        waktu = "09.20",
        kategori = "Uang Tunai" ,
        jumlah_saldo = "-Rp12.000",
        warna = Color.Red
    )
}

    @Composable
    fun KatalogTransaksi(
        imageResource: Int,
        keterangan: String,
        waktu:String,
        kategori:String,
        jumlah_saldo: String,
        warna: Color
    ) {
        Row(
            horizontalArrangement = Arrangement.SpaceBetween,
            modifier = Modifier
                .fillMaxWidth()
                .padding(end = 24.dp)
                .drawBehind {
                    val strokeWidth = 1.dp.toPx() // Ketebalan border
                    val y = size.height - strokeWidth / 2 // Posisi border
                    drawLine(
                        color = Color.LightGray, // Warna border
                        start = Offset(x = 85f, y = y), // Mengatur posisi awal garis
                        end = Offset(x = 1010f, y = y), // Mengatur posisi akhir garis
                        strokeWidth = strokeWidth
                    )
                },
            verticalAlignment = Alignment.CenterVertically
        ) {
            Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier
                    .padding(start = 30.dp)
                    .padding(top = 5.dp)
            ) {
                val image: Painter = painterResource(id = imageResource)
                Image(
                    painter = image,
                    contentDescription = null,
                    modifier = Modifier
                        .clip(CircleShape)
                        .size(40.dp),
                    contentScale = ContentScale.Crop
                )

                Spacer(modifier = Modifier.width(8.dp))
                Column {
                    Text(text = keterangan, style = Typography.displayMedium, color = PurpleSavvy1)
                    Text(text = waktu, style = Typography.bodySmall, color = PurpleSavvy1)
                }
            }
            Column(
                modifier = Modifier.padding(top = 15.dp, bottom = 15.dp)
            ) {
                Text(text = kategori, style = Typography.bodySmall    , color = PurpleSavvy1)
                Text(text = jumlah_saldo, style = Typography.bodyMedium, color = warna)
            }
        }

    }
@Composable
fun SubSaldo(
    imageResource: Int,
    keterangan: String,
    jumlah_saldo: String
){
    Row(verticalAlignment = Alignment.CenterVertically,) {
        val image: Painter = painterResource(id = imageResource)
        Image(
            painter = image,
            contentDescription = null,
            modifier = Modifier
                .clip(CircleShape)
                .size(40.dp),
            contentScale = ContentScale.FillWidth
        )
    }
    Spacer(modifier = Modifier.width(8.dp))
    Column {
        Text(text = keterangan, style = Typography.bodySmall, color = WhiteSavvy)
        Text(text = "Rp.$jumlah_saldo",style = Typography.bodyMedium,color = WhiteSavvy)
    }
}

@Composable
fun TampilAnggaran(
    imageResource: Int,
    keterangan: String,
    jumlah_saldo: String
){
    val progress = remember { mutableStateOf(0.5f) }
    Column {
        Row(
            Modifier
                .padding(bottom = 4.dp, end = 2.dp)
                .fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Card(
                shape = RoundedCornerShape(20.dp),
                modifier = Modifier
                    .padding(start = 24.dp, top = 5.dp)
                    .width(215.dp) // Set the width of the card to 318.dp
                    .height(100.dp), // Set the height of the card to 141.dp
                colors = CardDefaults.cardColors(containerColor = PinkSavvy)
            ){
                Column {
                    Row(verticalAlignment = Alignment.CenterVertically,
                        modifier = Modifier.padding(12.dp)) { // Menambahkan Row untuk menampilkan Image dan Column bersamaan
                        val image: Painter = painterResource(id = imageResource)
                        Image(
                            painter = image,
                            contentDescription = null,
                            modifier = Modifier
                                .clip(CircleShape)
                                .size(40.dp),
                            contentScale = ContentScale.Crop
                        )
                        Spacer(modifier = Modifier.width(8.dp))
                        Column {
                            Text(text = keterangan, style = Typography.bodyMedium, color = PurpleSavvy1)
                            Text(text = "Rp.$jumlah_saldo",style = Typography.bodySmall,color = PurpleSavvy1)
                        }
                    }
                    Box(
                        modifier = Modifier.fillMaxSize()
                            .padding(bottom = 10.dp), // Fill the parent
                        contentAlignment = Alignment.Center // Center the content
                    ) {
                        Box(
                            modifier = Modifier
                                .width(180.dp)
                                .height(8.dp)
                                .clip(RoundedCornerShape(4.dp)) // Clip the Box with rounded corners
                                .background(Color.White)
                                .border(1.dp, Color.Transparent, RoundedCornerShape(4.dp)), // Add a border with rounded corners
                            contentAlignment = Alignment.CenterStart
                        ) {
                            Box(
                                modifier = Modifier
                                    .fillMaxWidth(progress.value)
                                    .height(8.dp)
                                    .clip(RoundedCornerShape(4.dp)) // Clip the Box with rounded corners
                                    .background(PurpleSavvy1)
                            )
                        }
                    }

                }
            }
        }
    }
}

