package com.example.savvyswantatra.Kalender

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AddCircle
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Divider
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.zIndex
import com.example.savvyswantatra.ui.theme.OrangeSavvy
import com.example.savvyswantatra.ui.theme.Pink40
import com.example.savvyswantatra.ui.theme.Pinkeu
import com.example.savvyswantatra.ui.theme.PurpleSavvy1
import com.example.savvyswantatra.ui.theme.PurpleSavvy2
import com.example.savvyswantatra.ui.theme.PurpleSavvy3
import com.example.savvyswantatra.ui.theme.Typography
import com.example.savvyswantatra.ui.theme.WhiteSavvy
import com.example.savvyswantatra.ui.theme.poppinsFontFamily
import java.time.LocalDate
import java.time.YearMonth

@Composable
fun TampilanKalender() {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(PurpleSavvy1)

    )
    {
        Text(
            text = "Transaksi",
            style = Typography.titleMedium,
            fontWeight = FontWeight.SemiBold,
            color = WhiteSavvy,
            fontFamily = poppinsFontFamily,
            modifier = Modifier
                .align(Alignment.TopCenter)
                .padding(vertical = 70.dp)

        )
        Spacer(modifier = Modifier.height(10.dp))
        Text(
            text = "Mei 2024",
            style = Typography.bodySmall,
            color = WhiteSavvy,
            fontFamily = poppinsFontFamily,
            modifier = Modifier
                .align(Alignment.TopCenter)
                .padding(vertical = 110.dp)

        )
        Row(
            modifier = Modifier
                .padding(vertical = 155.dp)
        ) {
            Spacer(modifier = Modifier.width(25.dp))
            Column {
                Text(
                    text = "Kalender",
                    style = Typography.bodySmall,
                    color = WhiteSavvy,

                    )
                Spacer(modifier = Modifier.height(5.dp))
                Divider(
                    modifier = Modifier
                        .width(50.dp),
                    thickness = 4.dp,
                    color = OrangeSavvy
                )
            }

            Spacer(modifier = Modifier.width(25.dp))
            Text(
                text = "Harian",
                style = Typography.bodySmall,
                color = WhiteSavvy,


                )
            Spacer(modifier = Modifier.width(25.dp))
            Text(
                text = "Mingguan",
                style = Typography.bodySmall,
                color = WhiteSavvy,


                )
            Spacer(modifier = Modifier.width(25.dp))
            Column {
                Text(
                    text = "Bulanan",
                    style = Typography.bodySmall,
                    color = WhiteSavvy,


                    )
                Spacer(modifier = Modifier.height(5.dp))

            }

            Spacer(modifier = Modifier.width(25.dp))
            Text(
                text = "Ringkasan",
                style = Typography.bodySmall,
                color = WhiteSavvy,


                )

        }
        // Card di bagian bawah
        Card(
            shape = RectangleShape,
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight()
                .padding(top = 180.dp)
        ) {
            Row(
                modifier = Modifier
                    .padding(top = 15.dp)
            )
            {
                Spacer(
                    modifier = Modifier
                        .width(35.dp)
                )
                Column {
                    Text(
                        text = "Pemasukan",
                        style = Typography.bodyMedium,
                        color = PurpleSavvy3,
                    )
                    Text(
                        text = "Rp4,586,089",
                        style = Typography.bodyMedium,
                        color = PurpleSavvy3,
                    )
                }

                Spacer(
                    modifier = Modifier
                        .width(60.dp)
                )
                Column {
                    Text(
                        text = "Pengeluaran",
                        style = Typography.bodyMedium,
                        color = PurpleSavvy3,
                    )
                    Text(
                        text = "Rp4,586,089",
                        style = Typography.bodyMedium,
                        color = PurpleSavvy3,
                    )
                }

                Spacer(
                    modifier = Modifier
                        .width(60.dp)
                )
                Column(
                ) {
                    Text(
                        text = "Total",
                        style = Typography.bodyMedium,
                        color = PurpleSavvy2,
                    )
                    Text(
                        text = "Rp605,964",
                        style = Typography.bodyMedium,
                        color = PurpleSavvy2,
                    )
                }
            }
            hari()
            Spacer(modifier = Modifier.height(16.dp))
            Row {

            }
            SimpleCalendar()
            /*Icon(imageVector = Icons.Default.AddCircle,
                contentDescription = "add",
                modifier = Modifier
                    .padding(start = 335.dp)
                    .width(54.dp)
                    .height(54.dp)
                    ,
                tint = Pink40
            )*/
        }
    }
}

@Composable
fun hari(){
    Card(
        shape = RoundedCornerShape(5.dp),
        modifier = Modifier
            .width(400.dp) // Set the width of the card to 318.dp
            .height(30.dp)
            .padding(horizontal = 24.dp)
            .padding(top = 5.dp),
        colors = CardDefaults.cardColors(containerColor = PurpleSavvy1)
    ){
        Row(
            modifier = Modifier
                .padding(vertical = 5.dp)
                .padding(horizontal = 27.dp)
        ) {

            Text(
                text = "Min",
                style = Typography.bodySmall,
                color = WhiteSavvy,

                )
            Spacer(modifier = Modifier.width(20.dp))
            Text(
                text = "Sen",
                style = Typography.bodySmall,
                color = WhiteSavvy,

                )
            Spacer(modifier = Modifier.width(20.dp))
            Text(
                text = "Sel",
                style = Typography.bodySmall,
                color = WhiteSavvy,


                )
            Spacer(modifier = Modifier.width(20.dp))
            Text(
                text = "Rab",
                style = Typography.bodySmall,
                color = WhiteSavvy,


                )
            Spacer(modifier = Modifier.width(20.dp))
            Text(
                text = "Kam",
                style = Typography.bodySmall,
                color = WhiteSavvy,

                )
            Spacer(modifier = Modifier.width(20.dp))
            Text(
                text = "Jumat",
                style = Typography.bodySmall,
                color = WhiteSavvy,

                )
            Spacer(modifier = Modifier.width(20.dp))
            Text(
                text = "Sabtu",
                style = Typography.bodySmall,
                color = WhiteSavvy,

                )

        }
    }
}
@Composable
fun SimpleCalendar() {
    val days = listOf(26, 27, 28, 29, 30, 31, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, 26, 27, 28, 29, 30, 1, 2, 3, 4, 5, 6)
    Box(modifier = Modifier.fillMaxSize()) {
        Column {
            for (week in days.chunked(7)) {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(8.dp),
                    horizontalArrangement = Arrangement.SpaceEvenly
                ) {
                    for (day in week) {
                        Text(
                            text = "$day",
                            style = Typography.bodySmall,
                            modifier = Modifier
                                .width(40.dp)
                                .height(70.dp)
                                .background(Color.Transparent)
                                .padding(8.dp),
                            textAlign = TextAlign.Center
                        )
                    }
                }
            }
        }
        Icon(
            imageVector = Icons.Default.AddCircle,
            contentDescription = "add",
            modifier = Modifier
                .align(Alignment.TopEnd)
                .offset(x = (-16).dp, y = 430.dp)
                .width(60.dp)
                .height(60.dp)
                .zIndex(1f), // Ikon berada di atas kotak kalender
            tint = Pinkeu
        )
    }
}



@Preview(showBackground = true)
@Composable
fun TampilanKalenderPreview() {
    TampilanKalender()
}
