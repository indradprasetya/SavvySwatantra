package com.example.savvyswantatra

import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.requiredHeight
import androidx.compose.foundation.layout.requiredWidth
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material.icons.filled.KeyboardArrowLeft
import androidx.compose.material.icons.filled.KeyboardArrowRight
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.example.savvyswantatra.component.months
import com.example.savvyswantatra.database.AppDatabase
import com.example.savvyswantatra.model.Transaksi
import com.example.savvyswantatra.ui.theme.OrangeSavvy
import com.example.savvyswantatra.ui.theme.PurpleSavvy1
import com.example.savvyswantatra.ui.theme.Typography
import com.example.savvyswantatra.viewModel.AnggaranViewModel
import com.example.savvyswantatra.viewModel.AnggaranViewModelFactory
import com.example.savvyswantatra.viewModel.DetailScreenViewModel
import com.example.savvyswantatra.viewModel.DetailScreenViewModelFactory
import com.example.savvyswantatra.viewModel.RiwayatAnggaranViewModel
import com.example.savvyswantatra.viewModel.RiwayatAnggaranViewModelFactory
import java.text.NumberFormat

@Composable
fun RiwayatAnggaranScreen(
    navController: NavController,
    namaKategori: String,
    namaAnggaran: String,
    jumlahSaldo: Double,
    batasAnggaran: Double,
    iconKategori: Int
) {
    val context = LocalContext.current
    val kategoriAnggaranDao = AppDatabase.getInstance(context).kategoriAnggaranDao()
    val transaksiDao = AppDatabase.getInstance(context).transaksiDao()
    val anggaranDao = AppDatabase.getInstance(context).anggaranDao()

    val viewModel: RiwayatAnggaranViewModel = viewModel(
        factory = RiwayatAnggaranViewModelFactory(anggaranDao, kategoriAnggaranDao, transaksiDao)
    )
    val anggaranViewModel: AnggaranViewModel = viewModel(
        factory = AnggaranViewModelFactory(anggaranDao, kategoriAnggaranDao)
    )
    val DetailviewModel: DetailScreenViewModel = viewModel(
        factory = DetailScreenViewModelFactory(kategoriAnggaranDao, transaksiDao)
    )
    val anggaranList by anggaranViewModel.anggaranList.observeAsState()
    val anggaran = anggaranList?.find { it.nama == namaAnggaran }
    viewModel.selectedCategory = namaKategori
    viewModel.selectedBudget = namaAnggaran

    val year by viewModel.year.collectAsState()
    val selectedMonth by viewModel.selectedMonth.collectAsState()

    val filteredTransactions by viewModel.filteredTransactions.collectAsState()
    Log.d("RiwayatAnggaranScreen", "RiwayatAnggaranScreen_filteredTransactions:$filteredTransactions")

    val transaksiList by DetailviewModel.transactions.observeAsState(emptyList())
    val transaksiForThisKategori = transaksiList.filter { it.namaKategori == namaKategori && it.namaAnggaran == namaAnggaran }
    val totalJumlahForThisKategori = transaksiForThisKategori.sumByDouble { it.jumlah }

    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Box(
            modifier = Modifier
                .requiredWidth(400.dp)
                .requiredHeight(158.dp)
                .background(PurpleSavvy1)
        ) {
            Column {
                Row(
                    modifier = Modifier.padding(16.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    IconButton(onClick = {
                        navController.popBackStack()
                    }) {
                        Icon(Icons.Filled.ArrowBack, contentDescription = "Kembali", tint = Color.White)
                    }
                }
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.Center,
                    modifier = Modifier
                        .fillMaxWidth()
                        .offset(y = (-25).dp)
                ) {
                    IconButton(onClick = { viewModel.setYear(year - 1) }) {
                        Icon(Icons.Filled.KeyboardArrowLeft, contentDescription = "", tint = Color.White)
                    }
                    Text(text = "$year", style = Typography.displayMedium, color = Color.White)
                    IconButton(onClick = { viewModel.setYear(year + 1) }) {
                        Icon(Icons.Filled.KeyboardArrowRight, contentDescription = "", tint = Color.White)
                    }
                }
                val scrollState = rememberLazyListState()

                LazyRow(
                    state = scrollState,
                    modifier = Modifier
                        .padding(horizontal = 8.dp)
                        .padding(bottom = 4.dp),
                    horizontalArrangement = Arrangement.spacedBy(12.dp)
                ) {
                    items(months) { month ->
                        Text(
                            text = month,
                            color = if (month == selectedMonth) OrangeSavvy else Color.White,
                            modifier = Modifier
                                .padding(4.dp)
                                .width(IntrinsicSize.Max)
                                .clickable { viewModel.setSelectedMonth(month) },
                            style = Typography.displayMedium.merge(
                                TextStyle(
                                    textDecoration = if (month == selectedMonth) TextDecoration.Underline else TextDecoration.None,
                                    lineHeight = 50.sp
                                )
                            ),
                            fontWeight = FontWeight.Normal
                        )
                    }
                }
            }
        }
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(8.dp),
            modifier = Modifier
                .offset(x = (-70).dp)
                .offset(y = (15).dp)
        ) {
            Box(
                modifier = Modifier
                    .size(50.dp)
                    .shadow(4.dp, RoundedCornerShape(10.dp), clip = false)
                    .background(Color.White, RoundedCornerShape(10.dp))
                    .border(
                        width = 1.dp,
                        color = Color.Transparent,
                        shape = RoundedCornerShape(10.dp)
                    )
                    .padding(5.dp)
            ) {
                Image(
                    painterResource(id = iconKategori),
                    contentDescription = "$iconKategori",
                    modifier = Modifier.size(50.dp)
                )
            }
            Column {
                Text(text = namaKategori, style = Typography.displaySmall, color = PurpleSavvy1)
                Row {
                    val formatter = NumberFormat.getNumberInstance()
                    val jumlahSaldoFormatted = formatter.format(totalJumlahForThisKategori)
                    val batasAnggaranFormatted = formatter.format(batasAnggaran)
                    Text(text = "Rp. $jumlahSaldoFormatted / ", style = Typography.bodyMedium, color = PurpleSavvy1, fontWeight = FontWeight.Normal)
                    Text(text = "Rp. $batasAnggaranFormatted", style = Typography.bodyMedium, color = PurpleSavvy1, fontWeight = FontWeight.Normal)
                }
            }
        }
        LazyColumn(verticalArrangement = Arrangement.spacedBy((-20).dp)) {
            items(filteredTransactions) { transaksi ->
                RiwayatAnggaranCard(
                    transaksi = transaksi,
                    navController = navController,
                    onDelete = {
                        viewModel.deleteTransaction(transaksi)
                        if (anggaran != null) {
                            anggaranViewModel.updateAnggaran(anggaran)
                            anggaran.jumlah+= transaksi.jumlah

                        }
                    }
                )
            }
        }
    }
}

@Composable
fun RiwayatAnggaranCard(
    navController: NavController,
    transaksi: Transaksi,
    onDelete: () -> Unit,
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 20.dp, horizontal = 30.dp),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Row(
            modifier = Modifier.weight(1f),
            horizontalArrangement = Arrangement.spacedBy(10.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(text = transaksi.nama, color = PurpleSavvy1, style = Typography.displayMedium)
            Spacer(modifier = Modifier.width(100.dp))
            Column {
                val formatter = NumberFormat.getNumberInstance()
                val nominalFormatted = formatter.format(transaksi.jumlah)
                Text(
                    text = "Rp. $nominalFormatted",
                    color = PurpleSavvy1,
                    style = Typography.bodyMedium,
                    modifier = Modifier.width(120.dp)
                )
                Text(
                    text = transaksi.tanggal,
                    color = PurpleSavvy1,
                    style = Typography.bodyMedium,
                    fontWeight = FontWeight.Normal,
                    modifier = Modifier.width(120.dp)
                )
            }
        }
        IconButton(onClick = {
            onDelete()
        }, modifier = Modifier.weight(0.1f)) {
            Icon(Icons.Default.Delete, contentDescription = "", tint = OrangeSavvy, modifier = Modifier.size(24.dp))
        }
    }
}
