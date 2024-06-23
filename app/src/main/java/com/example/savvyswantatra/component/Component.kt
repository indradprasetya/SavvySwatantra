package com.example.savvyswantatra.component

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.requiredHeight
import androidx.compose.foundation.layout.requiredSize
import androidx.compose.foundation.layout.requiredWidth
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AddCircle
import androidx.compose.material.icons.filled.DateRange
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Checkbox
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import androidx.room.Transaction
import com.example.savvyswantatra.R
import com.example.savvyswantatra.component.Image.bankList
import com.example.savvyswantatra.database.AppDatabase
import com.example.savvyswantatra.navigation.Screen
import com.example.savvyswantatra.ui.theme.OrangeSavvy
import com.example.savvyswantatra.ui.theme.PinkSavvy
import com.example.savvyswantatra.ui.theme.Purple80
import com.example.savvyswantatra.ui.theme.PurpleSavvy1
import com.example.savvyswantatra.ui.theme.PurpleSavvy2
import com.example.savvyswantatra.ui.theme.Typography
import com.example.savvyswantatra.ui.theme.WhiteSavvy
import com.example.savvyswantatra.ui.theme.poppinsFontFamily
import com.example.savvyswantatra.viewModel.AnggaranViewModel
import com.example.savvyswantatra.viewModel.AnggaranViewModelFactory
import com.example.savvyswantatra.viewModel.DetailScreenViewModel
import com.example.savvyswantatra.viewModel.DetailScreenViewModelFactory
import java.text.NumberFormat

@Composable
fun MainCard(navController: NavController) {
    val context = LocalContext.current
    val anggaranDao = AppDatabase.getInstance(context).anggaranDao()
    val kategoriAnggaranDao = AppDatabase.getInstance(context).kategoriAnggaranDao()
    val anggaranViewModel: AnggaranViewModel = viewModel(
        factory = AnggaranViewModelFactory(anggaranDao,kategoriAnggaranDao)
    )
    val anggaranList by anggaranViewModel.anggaranList.observeAsState(emptyList())

    // Menghitung total anggaran jika daftar tidak kosong
    val totalAnggaran = if (anggaranList.isNotEmpty()) {
        anggaranList.sumOf { it.jumlah }
    } else {
        0
    }

    val formatter = NumberFormat.getNumberInstance()
    val nominalFormatted = formatter.format(totalAnggaran)

    Card(
        shape = RoundedCornerShape(20.dp),
        modifier = Modifier
            .padding(24.dp)
            .padding(top = 70.dp)
            .width(350.dp)
            .height(155.dp),
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
                        text = "Rp. $nominalFormatted",
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
                    IconButton(onClick ={
                        navController.navigate(Screen.anggaran.route)
                    }) {
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
                    .padding(bottom = 4.dp, end = 25.dp)
                    .offset(x = 22.dp)
                    .offset(y = (-10).dp),
                horizontalArrangement = Arrangement.spacedBy(16.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                if (anggaranList.isEmpty()) {
                    item {
                        Box(
                            modifier = Modifier
                                .padding(start = 90.dp)
                                .padding(top = 5.dp)
                        ) {
                            Text(
                                text = "Tidak ada anggaran",
                                color = Color.White,
                                style = Typography.bodyMedium,
                            )
                        }
                    }
                } else {
                    items(anggaranList) { anggaran ->
                        SubSaldo(
                            imageResource = anggaran.imageResources,
                            keterangan = anggaran.nama,
                            jumlah_saldo = anggaran.jumlah
                        )
                    }
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
        jumlah_saldo = 10.000,
        warna = Color.Red
    )
    KatalogTransaksi(
        imageResource = R.drawable.income,
        keterangan ="THR dari sepuh Indra" ,
        waktu = "09.20",
        kategori = "Bank BCA" ,
        jumlah_saldo = 18.000,
        warna = Color(0xff039F00)
    )
    KatalogTransaksi(
        imageResource = R.drawable.makan,
        keterangan ="Makan Mie" ,
        waktu = "09.20",
        kategori = "Uang Tunai" ,
        jumlah_saldo = 12.000,
        warna = Color.Red
    )
}

@Composable
fun KatalogTransaksi(
    imageResource: Int,
    keterangan: String,
    waktu:String,
    kategori:String,
    jumlah_saldo: Double,
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
            val formatter = NumberFormat.getNumberInstance()
            val nominalFormatted = formatter.format(jumlah_saldo)
            Text(text =  "Rp.$nominalFormatted", style = Typography.bodyMedium, color = warna)
        }
    }

}
@Composable
fun SubSaldo(
    imageResource: Int,
    keterangan: String,
    jumlah_saldo: Double
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
        val formatter = NumberFormat.getNumberInstance()
        val nominalFormatted = formatter.format(jumlah_saldo)
        Text(text = "Rp.$nominalFormatted",style = Typography.bodyMedium,color = WhiteSavvy)
    }
}

@Composable
fun TampilAnggaran(
    imageResource: Int,
    keterangan: String,
    jumlah_saldo: Double,
    batas_anggaran: Double,
    navController: NavController,
    namaAnggaran: String,
    jumlah: Double
) {
    val persentase = if (batas_anggaran > 0) (jumlah / batas_anggaran) else 0.0
    val progress = remember { mutableStateOf(persentase.toFloat()) }
    LaunchedEffect(jumlah_saldo) {
        progress.value = persentase.toFloat()
    }
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
                    .width(215.dp)
                    .height(100.dp)
                    .clickable { navController.navigate(Screen.anggaran.route) },
                colors = CardDefaults.cardColors(containerColor = PinkSavvy)
            ) {
                Column {
                    Row(
                        verticalAlignment = Alignment.CenterVertically,
                        modifier = Modifier.padding(12.dp)
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
                            Text(
                                text = keterangan,
                                style = Typography.bodyMedium,
                                color = PurpleSavvy1
                            )
                            Row {
                                val formatter = NumberFormat.getNumberInstance()
                                val nominalFormatted = formatter.format(jumlah_saldo)
                                val nominalFormatted1 = formatter.format(batas_anggaran)
                                Text(
                                    text = "Rp.$nominalFormatted / ",
                                    style = Typography.bodyMedium,
                                    color = PurpleSavvy1,
                                    fontWeight = FontWeight.Normal
                                )
                                Text(
                                    text = "Rp.$nominalFormatted1 ",
                                    style = Typography.bodyMedium,
                                    color = PurpleSavvy1,
                                    fontWeight = FontWeight.Normal
                                )
                            }
                            Text(
                                text = namaAnggaran,
                                style = Typography.bodyMedium,
                                color = PurpleSavvy1,
                                fontWeight = FontWeight.SemiBold
                            )
                        }
                    }
                    Box(
                        modifier = Modifier
                            .fillMaxSize()
                            .padding(bottom = 10.dp),
                        contentAlignment = Alignment.Center
                    ) {
                        Box(
                            modifier = Modifier
                                .width(180.dp)
                                .height(8.dp)
                                .clip(RoundedCornerShape(4.dp))
                                .background(Color.White)
                                .border(1.dp, Color.Transparent, RoundedCornerShape(4.dp)),
                            contentAlignment = Alignment.CenterStart
                        ) {
                            Box(
                                modifier = Modifier
                                    .fillMaxWidth(progress.value)
                                    .height(8.dp)
                                    .clip(RoundedCornerShape(4.dp))
                                    .background(PurpleSavvy1)
                            ) {
                                Text(
                                    text = "${(persentase * 100).toInt()}%",
                                    style = Typography.bodyMedium,
                                    color = PurpleSavvy2,
                                    modifier = Modifier
                                        .padding(end = 5.dp)
                                        .align(Alignment.CenterEnd)
                                )
                            }
                        }
                    }
                }
            }
        }
    }
}

@Composable
fun Anggaran_card(imageResources: Int, label:String, nominal:Double,onDelete: () -> Unit, onCardClick: () -> Unit) {
    val openDialog = remember { mutableStateOf(false) }

    if (openDialog.value) {
        Surface(color = WhiteSavvy) {
            AlertDialog(
                onDismissRequest = { openDialog.value = false },
                title = { Text(text = "Konfirmasi Penghapusan", fontFamily = poppinsFontFamily) },
                text = { Text(text = "Apakah Anda ingin menghapus anggaran ini?") },
                confirmButton = {
                    TextButton(
                        onClick = {
                            onDelete()
                            openDialog.value = false
                        },
                        colors = ButtonDefaults.textButtonColors(contentColor = PurpleSavvy1)
                    ) {
                        Text("Ya, Hapus",fontFamily = poppinsFontFamily)
                    }
                },
                dismissButton = {
                    TextButton(
                        onClick = { openDialog.value = false },
                        colors = ButtonDefaults.textButtonColors(contentColor = PurpleSavvy1),

                    ) {
                        Text("Tidak, Batal",
                            fontFamily = poppinsFontFamily)
                    }
                }
            )
        }
    }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .clickable(onClick = onCardClick),
        contentAlignment = Alignment.TopCenter
    ) {
        Card(
            shape = RoundedCornerShape(20.dp),
            modifier = Modifier
                .width(320.dp) // Set the width of the card to 318.dp
                .height(110.dp), // Set the height of the card to 141.dp
            colors = CardDefaults.cardColors(containerColor = PurpleSavvy1)
        ){
            Column(
                modifier = Modifier
                    .padding(start = 20.dp)
            ) {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(
                        text = "Saldo Total",
                        style = Typography.labelSmall,
                        fontSize = 14.sp,
                        color = WhiteSavvy
                    )
                    IconButton(onClick = { openDialog.value = true }) {
                        Icon(
                            Icons.Default.Delete,
                            contentDescription = null,
                            modifier = Modifier.size(18.dp),
                            tint = WhiteSavvy
                        )
                    }
                }
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(end = 20.dp),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Row(
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Image(
                            painterResource(id = imageResources) ,
                            contentDescription = "",
                            modifier = Modifier
                                .requiredSize(40.dp)
                                .clip(shape = RoundedCornerShape(10.dp))
                        )
                        Text(
                            text = label,
                            style = Typography.labelSmall,
                            modifier = Modifier.padding(start = 16.dp),
                            color = Color.White
                        )
                    }
                    val formatter = NumberFormat.getNumberInstance()
                    val nominalFormatted = formatter.format(nominal)
                    Text(
                        text = "Rp. $nominalFormatted",
                        style = Typography.displayMedium,
                        color = OrangeSavvy
                    )
                }
            }
        }
    }
}
@OptIn(ExperimentalFoundationApi::class, ExperimentalLayoutApi::class)
@Composable
fun BankList(selectedImage: MutableState<Int>){
    val pagerState = rememberPagerState(pageCount = { bankList.size })

    HorizontalPager(state = pagerState) { page ->
        FlowRow(
            // Tambahkan ini untuk mengatur ke tengah
            verticalArrangement = Arrangement.spacedBy(8.dp),
            horizontalArrangement = Arrangement.spacedBy(8.dp),
            modifier = Modifier
                .padding(horizontal = 38.dp)
        ) {
            bankList.chunked(4).forEachIndexed { rowIndex, banks ->
                banks.forEachIndexed { columnIndex, bank ->
                    val index = rowIndex * 4 + columnIndex
                    Surface(
                        shape = RoundedCornerShape(5.dp),
                        border = BorderStroke(
                            width = 2.dp,
                            color = if (index == selectedImage.value) Color(0xFFFFA500) else Color.Transparent
                        ),
                        color = WhiteSavvy
                    ) {
                        Image(
                            painter = painterResource(id = bank),
                            contentDescription = null,
                            modifier = Modifier
                                .size(100.dp)
                                .clickable {
                                    selectedImage.value = index
                                }
                        )
                    }
                }
            }
        }
    }
}


@Composable
fun Detail_kategori_card(
    imageResource: Int,
    keterangan: String,
    jumlah_saldo: String,
    batas_anggaran: Double,
    onDelete: () -> Unit,
    onAddTransactionClick: () -> Unit,
    onCardClick: () -> Unit,
    jumlah: Double
) {
    val context = LocalContext.current
    val anggaranDao = AppDatabase.getInstance(context).anggaranDao()
    val kategoriAnggaranDao = AppDatabase.getInstance(context).kategoriAnggaranDao()
    val transaksiDao = AppDatabase.getInstance(context).transaksiDao()
    val viewModel: DetailScreenViewModel = viewModel(
        factory = DetailScreenViewModelFactory(kategoriAnggaranDao, transaksiDao)
    )

    val transaksiList by viewModel.transactions.observeAsState(emptyList())
    val persentase = (jumlah / batas_anggaran)
    val progress = remember { mutableStateOf(persentase.toFloat()) }
    val openDialog = remember { mutableStateOf(false) }

    LaunchedEffect(jumlah_saldo) {
        progress.value = persentase.toFloat()
    }

    if (openDialog.value) {
        AlertDialog(
            onDismissRequest = { openDialog.value = false },
            title = { Text(text = "Konfirmasi Penghapusan") },
            text = { Text(text = "Apakah Anda ingin menghapus anggaran ini?") },
            confirmButton = {
                TextButton(
                    onClick = {
                        onDelete()
                        openDialog.value = false
                    }
                ) {
                    Text("Hapus")
                }
            },
            dismissButton = {
                TextButton(onClick = { openDialog.value = false }) {
                    Text("Batal")
                }
            }
        )
    }

    Column {
        Row(
            verticalAlignment = Alignment.CenterVertically
        ) {
            Card(
                shape = RoundedCornerShape(20.dp),
                modifier = Modifier
                    .padding(start = 36.dp, top = 5.dp)
                    .width(320.dp)
                    .height(155.dp)
                    .clickable(onClick = onCardClick),
                colors = CardDefaults.cardColors(containerColor = PurpleSavvy1)
            ) {
                Column {
                    Row(
                        verticalAlignment = Alignment.CenterVertically,
                        modifier = Modifier.padding(16.dp)
                    ) {
                        val image: Painter = painterResource(id = imageResource)
                        Box(
                            modifier = Modifier
                                .size(50.dp)
                                .shadow(
                                    elevation = 4.dp,
                                    shape = RoundedCornerShape(10.dp),
                                    clip = false
                                )
                                .background(Color.White, shape = RoundedCornerShape(10.dp))
                                .border(
                                    width = 1.dp,
                                    color = Color.Transparent,
                                    shape = RoundedCornerShape(10.dp)
                                )
                                .padding(5.dp)
                        ) {
                            Image(
                                painter = image,
                                contentDescription = null,
                                modifier = Modifier
                                    .clip(CircleShape)
                                    .size(40.dp),
                                contentScale = ContentScale.Crop
                            )
                        }
                        Spacer(modifier = Modifier.width(8.dp))
                        Column {
                            Text(text = keterangan, style = Typography.displayMedium, color = WhiteSavvy)
                            Row {
                                val formatter = NumberFormat.getNumberInstance()
                                val nominalFormatted = formatter.format(jumlah_saldo.toDoubleOrNull() ?: 0.0)
                                val nominalFormatted1 = formatter.format(batas_anggaran)
                                Text(text = "Rp.$nominalFormatted / ", style = Typography.bodyMedium, color = WhiteSavvy, fontWeight = FontWeight.Normal)
                                Text(text = "Rp.$nominalFormatted1 ", style = Typography.bodyMedium, color = WhiteSavvy, fontWeight = FontWeight.Normal)
                            }
                        }
                        Spacer(modifier = Modifier.width(10.dp))
                        Box(
                            modifier = Modifier.fillMaxWidth(),
                            contentAlignment = Alignment.CenterEnd
                        ) {
                            IconButton(onClick = { openDialog.value = true }) {
                                Icon(
                                    Icons.Default.Delete,
                                    contentDescription = null,
                                    modifier = Modifier.size(18.dp)
                                )
                            }
                        }
                    }
                    Row(
                        modifier = Modifier
                            .offset(y = (-20).dp)
                            .padding(start = 4.dp),
                        verticalAlignment = Alignment.CenterVertically,
                    ) {
                        IconButton(onClick = { onAddTransactionClick() }) {
                            Icon(
                                Icons.Default.AddCircle,
                                contentDescription = null,
                                tint = OrangeSavvy
                            )
                        }
                        Text(text = "Tambah Transaksi", style = Typography.bodyMedium, color = WhiteSavvy, modifier = Modifier.offset(x = (-8).dp))
                    }
                    Box(
                        modifier = Modifier
                            .fillMaxSize()
                            .offset(y = (-20).dp),
                        contentAlignment = Alignment.Center
                    ) {
                        Box(
                            modifier = Modifier
                                .width(240.dp)
                                .height(12.dp)
                                .clip(RoundedCornerShape(8.dp))
                                .background(Color.White)
                                .border(1.dp, Color.Transparent, RoundedCornerShape(4.dp)),
                            contentAlignment = Alignment.CenterStart
                        ) {
                            Box(
                                modifier = Modifier
                                    .fillMaxWidth(progress.value)
                                    .height(12.dp)
                                    .clip(RoundedCornerShape(8.dp))
                                    .background(OrangeSavvy)
                            ) {
                                Text(
                                    text = "${(persentase * 100).toInt()}%",
                                    style = Typography.bodyMedium,
                                    color = PurpleSavvy2,
                                    modifier = Modifier
                                        .padding(end = 5.dp)
                                        .align(Alignment.CenterEnd)
                                )
                            }
                        }
                    }
                }
            }
        }
    }
}
