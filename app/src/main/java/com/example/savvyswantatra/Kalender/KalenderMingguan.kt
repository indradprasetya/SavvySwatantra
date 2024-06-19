package com.example.savvyswantatra.Kalender
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AddCircle
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.ArrowForward
import androidx.compose.material.icons.filled.CheckCircle
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.savvyswantatra.R
import com.example.savvyswantatra.component.kalenderbar
import com.example.savvyswantatra.model.DummyData
import com.example.savvyswantatra.model.DummyData2
import com.example.savvyswantatra.model.KalenderData
import com.example.savvyswantatra.model.TanggalitemData
import com.example.savvyswantatra.model.TransaksiKalender
import com.example.savvyswantatra.ui.theme.PinkSavvy
import com.example.savvyswantatra.ui.theme.PurpleSavvy1
import com.example.savvyswantatra.ui.theme.PurpleSavvy2
import com.example.savvyswantatra.ui.theme.Typography
import com.example.savvyswantatra.ui.theme.WhiteSavvy
import com.example.savvyswantatra.ui.theme.poppinsFontFamily
import java.time.DayOfWeek
import java.time.LocalDate
import java.time.YearMonth
import java.time.format.TextStyle
import java.util.*


@Composable
fun KalenderMingguan(navController: NavController,
                     listDataTanggal : List<TanggalitemData> = DummyData2.TanggalList,
) {
    var isKalenderSelected by remember { mutableStateOf(false) }
    var ambilKalender by remember { mutableStateOf(value = false) }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(PurpleSavvy1)
    ) {
        kalenderbar(navController)
        Card(
            shape = RectangleShape,
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight()
                .padding(top = 180.dp)
        ) {
            Column(
                modifier = Modifier
                    .background(Color.White)
                    .padding(10.dp)
            ) {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(bottom = 10.dp),
                    horizontalArrangement = Arrangement.SpaceEvenly
                ) {
                    Column(horizontalAlignment = Alignment.CenterHorizontally) {
                        Text("Pemasukan", color = PurpleSavvy2, style = Typography.bodyMedium)
                        Text("Rp0", color = PurpleSavvy2, style = Typography.bodyMedium)
                    }
                    Column(horizontalAlignment = Alignment.CenterHorizontally) {
                        Text("Pengeluaran", color = PurpleSavvy2, style = Typography.bodyMedium)
                        Text("Rp0", color = PurpleSavvy2, style = Typography.bodyMedium)
                    }
                    Column(horizontalAlignment = Alignment.CenterHorizontally) {
                        Text(
                            "Total",
                            fontWeight = FontWeight.Bold,
                            color = PurpleSavvy1,
                            style = Typography.bodyMedium
                        )
                        Text(
                            "Rp0",
                            fontWeight = FontWeight.Bold,
                            color = PurpleSavvy1,
                            style = Typography.bodyMedium
                        )
                    }
                }

                LazyColumn {
                    val groupedItems = TanggalitemData.groupBy { it.date }
                    groupedItems.forEach { (date, items) ->
                        // Parse tanggal untuk mendapatkan tahun dan bulan
                        val year = items.firstOrNull()?.date?.substring(0, 4)?.toIntOrNull() ?: 0
                        val month = items.firstOrNull()?.date?.substring(5, 7)?.toIntOrNull() ?: 0

                        // Tampilkan judul tanggal, tahun, bulan di atas item-item
                        item {
                            Text(
                                text = "Date: ${formatDate(date)}",
                                style = TextStyle(
                                    fontWeight = FontWeight.Bold,
                                    fontSize = 20.sp,
                                    color = Color.Black
                                ),
                                modifier = Modifier
                                    .padding(horizontal = 16.dp, vertical = 8.dp)
                            )
                        }

                        // Tampilkan item-item di dalam grup tanggal, tahun, bulan ini
                        items.forEach { item ->
                            item {
                                Text(
                                    text = item.name,
                                    style = TextStyle(
                                        fontSize = 16.sp,
                                        color = Color.Gray
                                    ),
                                    modifier = Modifier
                                        .padding(horizontal = 32.dp, vertical = 4.dp)
                                )
                            }
                        }
                    }
                }
            }
            }



//                @Composable
//                fun KalenderView() {
//                    var currentYearMonth by remember { mutableStateOf(YearMonth.now()) }
//
//                    Column(
//                        horizontalAlignment = Alignment.CenterHorizontally,
//                        modifier = Modifier.fillMaxWidth()
//                    ) {
//                        Row(
//                            verticalAlignment = Alignment.CenterVertically,
//                            horizontalArrangement = Arrangement.SpaceBetween,
//                            modifier = Modifier
//                                .fillMaxWidth()
//                                .padding(horizontal = 16.dp)
//                        ) {
//                            IconButton(onClick = {
//                                currentYearMonth = currentYearMonth.minusMonths(1)
//                            }) {
//                                Icon(
//                                    imageVector = Icons.Default.ArrowBack,
//                                    contentDescription = "Previous Month",
//                                    tint = Color.White
//                                )
//                            }
//
//                            Text(
//                                text = "${
//                                    currentYearMonth.month.getDisplayName(
//                                        TextStyle.FULL,
//                                        Locale.getDefault()
//                                    )
//                                } ${currentYearMonth.year}",
//                                fontSize = 13.sp,
//                                fontFamily = poppinsFontFamily,
//                                textAlign = TextAlign.Center,
//                                color = Color.White,
//                                fontWeight = FontWeight.Thin
//                            )
//                            IconButton(onClick = {
//                                currentYearMonth = currentYearMonth.plusMonths(1)
//                            }) {
//                                Icon(
//                                    imageVector = Icons.Default.ArrowForward,
//                                    contentDescription = "Next Month",
//                                    tint = Color.White
//                                )
//                            }
//                        }
//                    }
//                }
            }
        }
    }
}
