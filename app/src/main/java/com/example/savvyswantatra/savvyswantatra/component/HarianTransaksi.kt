package com.example.savvyswantatra.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.requiredSize
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.CheckCircle
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.savvyswantatra.R
import com.example.savvyswantatra.model.TransaksiKalender
import com.example.savvyswantatra.ui.theme.PinkSavvy
import com.example.savvyswantatra.ui.theme.PurpleSavvy1
import com.example.savvyswantatra.ui.theme.PurpleSavvy2
import com.example.savvyswantatra.ui.theme.poppinsFontFamily

@Composable
fun HarianTransaksi(
    harian : TransaksiKalender,
    modifier: Modifier
) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight()
            .background(color = Color.Blue)
    ) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxSize()
                .padding(16.dp)
                .background(Color.Red)
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
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.Start
                ) {
                    Text(
                        text = "19",
                        fontFamily = poppinsFontFamily,
                        fontWeight = FontWeight.Bold,
                        fontSize = 30.sp,
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
                    ) {
                        Image(
                            painter = painterResource(id = harian.picture),
                            contentDescription = harian.name,
                            contentScale = ContentScale.Crop,
                            modifier = Modifier
                                .requiredSize(60.dp)
                                .clip(RoundedCornerShape(20.dp))
                        )
                        Icon(
                            imageVector = Icons.Default.CheckCircle,
                            contentDescription = "Pengeluaran Icon",
                            tint = PinkSavvy,
                            modifier = Modifier.offset(x = 40.dp, y = 42.dp)
                        )
                        Column(
                            modifier = Modifier.padding(start = 70.dp, top = 8.dp)

                        ) {
                            Text(
                                text = harian.name,
                                color = Color.Black,
                                fontWeight = FontWeight.Bold,
                                fontFamily = poppinsFontFamily
                            )
                            Row {
                                Text(
                                    text = harian.category,
                                    fontFamily = poppinsFontFamily,
                                    fontWeight = FontWeight.SemiBold,
                                    fontSize = 12.sp,
                                    color = PurpleSavvy2
                                )

                                Text(
                                    modifier = Modifier.padding(start = 90.dp),
                                    text = harian.price,
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

