package com.example.savvyswantatra

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.Row
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
import androidx.compose.material.icons.automirrored.filled.KeyboardArrowLeft
import androidx.compose.material.icons.automirrored.filled.KeyboardArrowRight
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material.icons.filled.KeyboardArrowLeft
import androidx.compose.material.icons.filled.KeyboardArrowRight
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.example.savvyswantatra.component.Transaksi
import com.example.savvyswantatra.component.TransaksiData
import com.example.savvyswantatra.component.months
import com.example.savvyswantatra.navigation.Screen
import com.example.savvyswantatra.ui.theme.OrangeSavvy
import com.example.savvyswantatra.ui.theme.PurpleSavvy1
import com.example.savvyswantatra.ui.theme.Typography
import com.example.savvyswantatra.ui.theme.WhiteSavvy
import java.text.NumberFormat



@Composable
fun RiwayatAnggaranScreen(navController: NavController) {
    var year by remember { mutableStateOf(2024)}
    var selectedMonth by remember { mutableStateOf("") }
    Column(
        modifier = Modifier
            .fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Box(
            modifier = Modifier
                .requiredWidth(width = 400.dp)
                .requiredHeight(height = 158.dp)
                .background(color = PurpleSavvy1)
        )
        {
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
                    IconButton(onClick = { year -- }) {
                        Icon(Icons.AutoMirrored.Filled.KeyboardArrowLeft, contentDescription = "", tint = Color.White)
                    }
                    Text(text = "$year",style = Typography.displayMedium, color = Color.White)
                    IconButton(onClick = { year ++ }) {
                        Icon(Icons.AutoMirrored.Filled.KeyboardArrowRight, contentDescription ="", tint = Color.White )
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
                            color = if (month == selectedMonth) OrangeSavvy else Color.White, // OrangeSavvy jika dipilih
                            modifier = Modifier
                                .padding(4.dp)
                                .width(IntrinsicSize.Max)
                                .clickable { selectedMonth = month },
                            style = Typography.displayMedium.merge(
                                TextStyle(
                                    textDecoration = if (month == selectedMonth) TextDecoration.Underline else TextDecoration.None,
                                    lineHeight = 50.sp
                                )
                            ), // Menambahkan line height
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
                    .shadow(elevation = 4.dp, shape = RoundedCornerShape(10.dp), clip = false)
                    .background(Color.White, shape = RoundedCornerShape(10.dp))
                    .border(
                        width = 1.dp,
                        color = Color.Transparent,
                        shape = RoundedCornerShape(10.dp)
                    )
                    .padding(5.dp)
            ) {
                Image(
                    painterResource(id = R.drawable.kesehatan),
                    contentDescription = "",
                    modifier = Modifier.size(50.dp)
                )
            }
            Column {
                Text(text = "Kesehatan", style = Typography.displaySmall, color = PurpleSavvy1)
                Row {
                    Text(text = "Rp.100.000 / ", style = Typography.bodyMedium, color = PurpleSavvy1, fontWeight = FontWeight.Normal)
                    Text(text = "Rp.500.000 ", style = Typography.bodyMedium, color = PurpleSavvy1, fontWeight = FontWeight.Normal)
                }
            }
        }
        LazyColumn {
            items(TransaksiData.transaksiList) { transaksi ->
                RiwayatAnggaranCard(transaksi = transaksi,navController= navController, onDelete = {TransaksiData.transaksiList.remove(transaksi)})
            }
        }
    }
}

@Composable
fun RiwayatAnggaranCard(transaksi: Transaksi,navController: NavController,onDelete: () -> Unit) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 20.dp)
            .padding(horizontal = 30.dp)
            .clickable {
                navController.navigate(Screen.riwayatAnggaran.route) },

            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Row(
                modifier = Modifier.weight(1f), // Use a flexible weight to align labels
                horizontalArrangement = Arrangement.spacedBy(10.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(text = transaksi.nama, color = PurpleSavvy1, style = Typography.displayMedium)
                Column {
                    val formatter = NumberFormat.getNumberInstance()
                    val nominalFormatted = formatter.format(transaksi.jumlah)
                    Text(text = "Rp. $nominalFormatted", color = PurpleSavvy1, style = Typography.bodyMedium)
                    Text(text = transaksi.tanggal, color = PurpleSavvy1, style = Typography.bodyMedium, fontWeight = FontWeight.Normal)
                }
            }
        IconButton(onClick = { onDelete() }, modifier = Modifier.weight(0.1f)) { Icon(Icons.Default.Delete, contentDescription = "", tint = OrangeSavvy, modifier = Modifier.size(24.dp))
        }
    }
}