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
import com.example.savvyswantatra.model.TransaksiKalender
import com.example.savvyswantatra.ui.theme.PinkSavvy
import com.example.savvyswantatra.ui.theme.PurpleSavvy1
import com.example.savvyswantatra.ui.theme.PurpleSavvy2
import com.example.savvyswantatra.ui.theme.WhiteSavvy
import com.example.savvyswantatra.ui.theme.poppinsFontFamily
import java.time.DayOfWeek
import java.time.LocalDate
import java.time.YearMonth
import java.time.format.TextStyle
import java.util.*


@Composable
fun HarianKalender(navController: NavController){
    var isKalenderSelected by remember { mutableStateOf(false) }
    var ambilKalender by remember { mutableStateOf(value = false) }
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(PurpleSavvy1)
    ) {
        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Top,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 40.dp, bottom = 0.dp)
                    .background(color = Color.Transparent)
                    .height(50.dp)
            ) {
                Text(
                    text = "Transaksi",
                    fontSize = 20.sp,
                    fontFamily = FontFamily.Monospace,
                    textAlign = TextAlign.Center,
                    modifier = Modifier.align(Alignment.Center),
                    color = Color.White


                )

                Icon(
                    imageVector = Icons.Default.Menu,
                    contentDescription = "Edit Icon",
                    tint = Color.White,

                    modifier = Modifier
                        .align(Alignment.CenterEnd)
                        .padding(end = 10.dp, top = 5.dp)
                        .size(40.dp)
                )
            }

            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(color = Color.Transparent)
                    .padding(vertical = 0.dp)
            ) {
                CalendarView(

                )
            }

            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(20.dp)
                    .background(color = PurpleSavvy1)
                    .padding(vertical = 0.dp)
            ) {
                Row(
                    modifier = Modifier.fillMaxSize(),
                    horizontalArrangement = Arrangement.SpaceEvenly,
                    verticalAlignment = Alignment.CenterVertically,

                    ) {
                    Text(
                        text = "Kalender",
                        fontSize = 10.sp,
                        color = if (isKalenderSelected) Color.White else Color.Gray, // Change color based on selection
                        fontFamily = poppinsFontFamily,
                        modifier = Modifier.run {
                            clickable {
                                // Toggle the selection state
                                isKalenderSelected = !isKalenderSelected
                            }
                                .padding(0.dp, 0.dp, 0.dp, 0.dp)
                                .border(
                                    BorderStroke(
                                        1.dp,
                                        if (isKalenderSelected) Color(
                                            255,
                                            229,
                                            180
                                        ) else Color.Transparent
                                    ),
                                    shape = RoundedCornerShape(0.dp),
                                    // Set border style to Dashed
                                )
                        }
                    )
                    Text(
                        text = "Harian",
                        fontSize = 10.sp,
                        fontFamily = poppinsFontFamily,
                        color = Color.White, // Mengatur warna teks menjadi putih
                        modifier = Modifier.clickable {

                        }
                    )
                    Text(
                        text = "Mingguan",
                        fontFamily = poppinsFontFamily,
                        fontSize = 10.sp,
                        color = Color.White, // Mengatur warna teks menjadi putih
                        modifier = Modifier.clickable {
                            // Code untuk navigasi saat teks diklik
                        }
                    )
                    Text(
                        text = "Bulanan",
                        fontFamily = poppinsFontFamily,
                        fontSize = 10.sp,
                        color = Color.White, // Mengatur warna teks menjadi putih
                        modifier = Modifier.clickable {
                            // Code untuk navigasi saat teks diklik
                        }
                    )
                    Text(
                        text = "Ringkasan",
                        fontSize = 10.sp,
                        fontFamily = poppinsFontFamily,

                        color = Color.White, // Mengatur warna teks menjadi putih
                        modifier = Modifier.clickable {
                            // Code untuk navigasi saat teks diklik
                        }
                    )
                }
            }

            Spacer(modifier = Modifier.height(10.dp))


            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(70.dp)
                    .background(color = Color.White)
            ) {
                Row(
                    modifier = Modifier.fillMaxSize(),
                    horizontalArrangement = Arrangement.SpaceEvenly,
                    verticalAlignment = Alignment.CenterVertically,
                ) {
                    Column(
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        Text(
                            "Pemasukan",
                            color = PurpleSavvy2
                        )
                        Text(
                            "Rp0",
                            color = PurpleSavvy2
                        )

                    }
                    Column(
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        Text(
                            "Pengeluaran",
                            color = PurpleSavvy2
                        )
                        Text(
                            "Rp0",
                            color = PurpleSavvy2
                        )
                    }
                    Column(
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        Text(
                            "Total",
                            fontWeight = FontWeight.Bold,
                            color = PurpleSavvy1
                        )
                        Text(
                            "Rp0",
                            fontWeight = FontWeight.Bold,
                            color = PurpleSavvy1
                        )
                    }

                }
            }
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .fillMaxHeight()
                    .background(color = Color.White)
            ) {
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .fillMaxSize()
                        .padding(16.dp)
                        .background(Color.White)
                ) {
                    Box(
                        modifier = Modifier
                            .size(width = 100.dp, height = 50.dp)
                            .background(color = Color.White)
                            .align(alignment = Alignment.TopStart)
                    ) {
                        Row(
                            modifier = Modifier
                                .fillMaxSize(),
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            Text(
                                text = "19",
                                fontFamily = poppinsFontFamily,
                                fontWeight = FontWeight.Bold,
                                fontSize = 24.sp,
                            )

                        }
                        Column(
                            modifier = Modifier
                                .fillMaxSize()
                                .padding(start = 30.dp)
                        ) {
                            Text(
                                text = "Rabu",
                                textAlign = TextAlign.Justify,
                                color = PurpleSavvy1
                            )
                            Text(
                                text = "Juni 2024",
                                textAlign = TextAlign.Justify,
                                color = PurpleSavvy1
                            )
                        }
                    }
                    Box(
                        modifier = Modifier
                            .size(width = 81.dp, height = 28.dp)
                            .clip(RoundedCornerShape(5.dp))
                            .background(color = PurpleSavvy1)
                            .align(alignment = Alignment.TopEnd)
                    ) {
                        Column(
                            modifier = Modifier
                                .fillMaxSize(),
                            verticalArrangement = Arrangement.Center,
                            horizontalAlignment = Alignment.CenterHorizontally

                        ) {
                            Text(
                                text = "Rp.49.000",
                                textAlign = TextAlign.Center,
                                color = Color.White
                            )
                        }

                    }
                    Row(
                        horizontalArrangement = Arrangement.Center,
                        verticalAlignment = Alignment.CenterVertically,
                        modifier = Modifier.padding(top = 70.dp, start = 10.dp, end = 10.dp)
                    ) {
                        Box(
                            modifier = Modifier
                                .fillMaxWidth()
                                .background(color = Color.White)
                                .height(70.dp)
                        ) {
                            Box(
                                modifier = Modifier
                                    .align(alignment = Alignment.CenterStart)
                                    .background(color = PinkSavvy)
                                    .clip(RoundedCornerShape(10.dp))
                            ) {
                                Image(
                                    painter = painterResource(id = R.drawable.makan),
                                    contentDescription = "makanan",
                                    contentScale = ContentScale.Crop,
                                    modifier = Modifier
                                        .requiredSize(60.dp)
                                        .clip(RoundedCornerShape(20.dp))
                                )
                            }
                                Image(
                                    painter = painterResource(id = R.drawable.pengeluaran),
                                    contentDescription = "Pengeluaran Icon",
                                    modifier = Modifier
                                        .offset(x = 45.dp, y = 50.dp)
                                        .size(20.dp)
                                )

                                Column(
                                    modifier = Modifier.padding(start = 70.dp, top = 8.dp)

                                ) {
                                    Text(
                                        text = "Makanan & Minuman",
                                        color = Color.Black,
                                        fontWeight = FontWeight.Bold,
                                        fontFamily = poppinsFontFamily
                                    )
                                    Row {
                                        Text(
                                            text = "Makan Warteg",
                                            fontFamily = poppinsFontFamily,
                                            fontWeight = FontWeight.SemiBold,
                                            fontSize = 12.sp,
                                            color = PurpleSavvy2
                                        )

                                        Text(
                                            modifier = Modifier.padding(start = 120.dp),
                                            text = "Rp10,000",
                                            fontFamily = poppinsFontFamily,
                                            fontWeight = FontWeight.SemiBold,
                                            fontSize = 12.sp,
                                            color = PurpleSavvy2

                                        )
                                    }
                                }
                            }

                    }
                    Spacer(modifier = Modifier.height(30.dp))
                    Row(
                        horizontalArrangement = Arrangement.Center,
                        verticalAlignment = Alignment.CenterVertically,
                        modifier = Modifier.padding(top = 160.dp, start = 10.dp, end = 10.dp)
                    ) {
                        Box(
                            modifier = Modifier
                                .fillMaxWidth()
                                .background(color = Color.White)
                                .height(70.dp)
                        ) {
                            Box(
                                modifier = Modifier
                                    .align(alignment = Alignment.CenterStart)

                            ) {
                                Image(
                                    painter = painterResource(id = R.drawable.kesehatanicon),
                                    contentDescription = "kesehatan",
                                    contentScale = ContentScale.Crop,
                                    modifier = Modifier
                                        .requiredSize(60.dp)
                                        .clip(RoundedCornerShape(20.dp))
                                )
                                Image(
                                    painter = painterResource(id = R.drawable.pengeluaran),
                                    contentDescription = "Pengeluaran Icon",
                                    modifier = Modifier
                                        .offset(x = 40.dp, y = 42.dp)
                                        .size(20.dp)
                                )
                            }
                                Column(
                                    modifier = Modifier.padding(start = 70.dp, top = 8.dp)

                                ) {
                                    Text(
                                        text = "Kesehatan",
                                        color = Color.Black,
                                        fontWeight = FontWeight.Bold,
                                        fontFamily = poppinsFontFamily
                                    )
                                    Row {
                                        Text(
                                            text = "Panadol",
                                            fontFamily = poppinsFontFamily,
                                            fontWeight = FontWeight.SemiBold,
                                            fontSize = 12.sp,
                                            color = PurpleSavvy2
                                        )

                                        Text(
                                            modifier = Modifier.padding(start = 160.dp),
                                            text = "Rp15,000",
                                            fontFamily = poppinsFontFamily,
                                            fontWeight = FontWeight.SemiBold,
                                            fontSize = 12.sp,
                                            color = PurpleSavvy2

                                        )
                                    }
                                }
                        }
                    }
                    Row(
                        horizontalArrangement = Arrangement.Center,
                        verticalAlignment = Alignment.CenterVertically,
                        modifier = Modifier.padding(top = 260.dp, start = 10.dp, end = 10.dp)
                    ) {
                        Box(
                            modifier = Modifier
                                .fillMaxWidth()
                                .background(color = Color.White)
                                .height(70.dp)
                        ) {
                            Box (
                                modifier = Modifier
                                    .align(alignment = Alignment.CenterStart)
                                    .background(color = PinkSavvy)
                            ) {
                                Image(
                                    painter = painterResource(id = R.drawable.income),
                                    contentDescription = "mandiri",
                                    contentScale = ContentScale.Crop,
                                    modifier = Modifier
                                        .requiredSize(60.dp)
                                        .clip(RoundedCornerShape(20.dp))
                                )
                                Image(
                                    painter = painterResource(id = R.drawable.pemasukan),
                                    contentDescription = "Pengeluaran Icon",
                                    modifier = Modifier
                                        .offset(x = 45.dp, y = 45.dp)
                                        .size(20.dp)
                                )
                            }
                                Column(
                                    modifier = Modifier.padding(start = 70.dp, top = 8.dp)

                                ) {
                                    Text(
                                        text = "Mandiri",
                                        color = Color.Black,
                                        fontWeight = FontWeight.Bold,
                                        fontFamily = poppinsFontFamily
                                    )
                                    Row {
                                        Text(
                                            text = "Transfer dari suhu Alfred",
                                            fontFamily = poppinsFontFamily,
                                            fontWeight = FontWeight.SemiBold,
                                            fontSize = 12.sp,
                                            color = PurpleSavvy2
                                        )

                                        Text(
                                            modifier = Modifier.padding(start = 60.dp),
                                            text = "Rp12,000",
                                            fontFamily = poppinsFontFamily,
                                            fontWeight = FontWeight.SemiBold,
                                            fontSize = 12.sp,
                                            color = PurpleSavvy2

                                        )
                                    }
                                }
                            }
                        }
                    Row(
                        horizontalArrangement = Arrangement.Center,
                        verticalAlignment = Alignment.CenterVertically,
                        modifier = Modifier.padding(top = 360.dp, start = 10.dp, end = 10.dp)
                    ) {
                        Box(
                            modifier = Modifier
                                .fillMaxWidth()
                                .background(color = Color.White)
                                .height(70.dp)
                                .clip(RoundedCornerShape(5.dp))
                        ) {
                            Box (
                                modifier = Modifier
                                    .align(alignment = Alignment.CenterStart)
                                    .background(color = PinkSavvy)
                            ) {
                                Image(
                                    painter = painterResource(id = R.drawable.income),
                                    contentDescription = "mandiri",
                                    contentScale = ContentScale.Crop,
                                    modifier = Modifier
                                        .requiredSize(60.dp)
                                        .clip(RoundedCornerShape(20.dp))
                                )
                                Image(
                                    painter = painterResource(id = R.drawable.pemasukan),
                                    contentDescription = "Pengeluaran Icon",
                                    modifier = Modifier
                                        .offset(x = 45.dp, y = 45.dp)
                                        .size(20.dp)
                                )
                            }
                            Column(
                                modifier = Modifier.padding(start = 70.dp, top = 8.dp)

                            ) {
                                Text(
                                    text = "Mandiri",
                                    color = Color.Black,
                                    fontWeight = FontWeight.Bold,
                                    fontFamily = poppinsFontFamily
                                )
                                Row {
                                    Text(
                                        text = "THR dari Paman",
                                        fontFamily = poppinsFontFamily,
                                        fontWeight = FontWeight.SemiBold,
                                        fontSize = 12.sp,
                                        color = PurpleSavvy2
                                    )

                                    Text(
                                        modifier = Modifier.padding(start = 115.dp),
                                        text = "Rp12,000",
                                        fontFamily = poppinsFontFamily,
                                        fontWeight = FontWeight.SemiBold,
                                        fontSize = 12.sp,
                                        color = PurpleSavvy2

                                    )
                                }
                            }
                        }
                    }
                    }
                }

                }

            }

        }




@Composable
fun CalendarView() {
    var currentYearMonth by remember { mutableStateOf(YearMonth.now()) }

    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.fillMaxWidth()
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween,
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp)
        ) {
            IconButton(onClick = {
                currentYearMonth = currentYearMonth.minusMonths(1)
            }) {
                Icon(imageVector = Icons.Default.ArrowBack, contentDescription = "Previous Month", tint = Color.White)
            }

            Text(
                text = "${currentYearMonth.month.getDisplayName(TextStyle.FULL, Locale.getDefault())} ${currentYearMonth.year}",
                fontSize = 13.sp,
                fontFamily = poppinsFontFamily,
                textAlign = TextAlign.Center,
                color = Color.White,
                fontWeight = FontWeight.Thin
            )
            IconButton(onClick = {
                currentYearMonth = currentYearMonth.plusMonths(1)
            }) {
                Icon(imageVector = Icons.Default.ArrowForward, contentDescription = "Next Month", tint = Color.White)
            }
        }
    }
}
