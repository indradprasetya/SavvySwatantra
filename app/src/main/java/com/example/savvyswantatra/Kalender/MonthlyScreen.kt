package com.example.savvyswantatra.Kalender

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Divider
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.savvyswantatra.R
import com.example.savvyswantatra.component.kalenderbar
import com.example.savvyswantatra.ui.theme.OrangeSavvy
import com.example.savvyswantatra.ui.theme.PurpleSavvy1
import com.example.savvyswantatra.ui.theme.PurpleSavvy2
import com.example.savvyswantatra.ui.theme.PurpleSavvy3
import com.example.savvyswantatra.ui.theme.Typography
import com.example.savvyswantatra.ui.theme.WhiteSavvy
import com.example.savvyswantatra.ui.theme.poppinsFontFamily
import java.util.Calendar

@Composable
fun MonthlyScreen(navController: NavController) {
    var currentMonth by remember { mutableStateOf(Calendar.getInstance().get(Calendar.MONTH)) }
    var currentYear by remember { mutableStateOf(Calendar.getInstance().get(Calendar.YEAR)) }

    val onPreviousMonth: () -> Unit = {
        if (currentMonth == 0) {
            currentMonth = 11
            currentYear--
        } else {
            currentMonth--
        }
    }

    val onNextMonth: () -> Unit = {
        if (currentMonth == 11) {
            currentMonth = 0
            currentYear++
        } else {
            currentMonth++
        }
    }
        kalenderbar(navController, currentMonth, currentYear, onPreviousMonth, onNextMonth)
        // Card di bagian bawah
        Card(
            shape = RectangleShape,
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight()
                .padding(top = 180.dp)
        ){
            Row (modifier = Modifier
                .padding(top = 15.dp))
            {
                Spacer(modifier = Modifier
                    .width(45.dp)
                )
                Column(
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.Center,
                ) {
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

                Spacer(modifier = Modifier
                    .width(45.dp)
                )
                Column (
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.Center,
                ){
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

                Spacer(modifier = Modifier
                    .width(45.dp)
                )
                Column(
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.Center,
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
            Column(
                modifier = Modifier
                    .padding(24.dp)
                    .padding(top = 2.dp)
            ) {
                MeiCard()
                Spacer(modifier = Modifier.height(10.dp))
                Text(
                    text = "Juni",
                    style = Typography.titleMedium,
                    color = PurpleSavvy1,

                    )
                Text(
                    text = "01/05 - 30/05",
                    style = Typography.bodySmall,
                    color = PurpleSavvy1,

                    )
                Divider(modifier = Modifier.fillMaxWidth(), thickness = 1.dp, color = PurpleSavvy1)
                Spacer(modifier = Modifier.height(10.dp))
                Text(
                    text = "Juli",
                    style = Typography.titleMedium,
                    color = PurpleSavvy1,

                    )
                Text(
                    text = "01/05 - 31/05",
                    style = Typography.bodySmall,
                    color = PurpleSavvy1,

                    )
                Divider(modifier = Modifier.fillMaxWidth(), thickness = 1.dp, color = PurpleSavvy1)
                Spacer(modifier = Modifier.height(10.dp))
                Text(
                    text = "Agustus",
                    style = Typography.titleMedium,
                    color = PurpleSavvy1,

                    )
                Text(
                    text = "01/05 - 31/05",
                    style = Typography.bodySmall,
                    color = PurpleSavvy1,

                    )
                Divider(modifier = Modifier.fillMaxWidth(), thickness = 1.dp, color = PurpleSavvy1)
                Spacer(modifier = Modifier.height(10.dp))
                Text(
                    text = "September",
                    style = Typography.titleMedium,
                    color = PurpleSavvy1,

                    )
                Text(
                    text = "01/05 - 31/05",
                    style = Typography.bodySmall,
                    color = PurpleSavvy1,

                    )
                Divider(modifier = Modifier.fillMaxWidth(), thickness = 1.dp, color = PurpleSavvy1)
                Spacer(modifier = Modifier.height(10.dp))
                Text(
                    text = "Oktober",
                    style = Typography.titleMedium,
                    color = PurpleSavvy1,

                    )
                Text(
                    text = "01/05 - 31/05",
                    style = Typography.bodySmall,
                    color = PurpleSavvy1,

                    )
                Divider(modifier = Modifier.fillMaxWidth(), thickness = 1.dp, color = PurpleSavvy1)
                Spacer(modifier = Modifier.height(10.dp))
                Text(
                    text = "November",
                    style = Typography.titleMedium,
                    color = PurpleSavvy1,

                    )
                Text(
                    text = "01/05 - 31/05",
                    style = Typography.bodySmall,
                    color = PurpleSavvy1,

                    )
                Divider(modifier = Modifier.fillMaxWidth(), thickness = 1.dp, color = PurpleSavvy1)
            }


        }

    }

@Composable
fun MeiCard(){
    Card(
        shape = RoundedCornerShape(5.dp),
        modifier = Modifier
            .width(350.dp) // Set the width of the card to 318.dp
            .height(252.dp), // Set the height of the card to 141.dp
        colors = CardDefaults.cardColors(containerColor = PurpleSavvy1)
    ){
        Column(
            modifier = Modifier
                .padding(8.dp)
        ) {
            Text(
                text = "Mei",
                style = Typography.titleMedium,
                fontWeight = FontWeight.SemiBold,
                color = WhiteSavvy,
                fontFamily = poppinsFontFamily,

            )
            Text(
                text = "01/05 - 31/05",
                style = Typography.bodySmall,
                color = WhiteSavvy,
                fontFamily = poppinsFontFamily,

            )
        }
        Row (
            modifier = Modifier
                .padding(start=120.dp)
        ){
            Column {
                Row {
                    Text(
                        text = "17",
                        style = Typography.titleMedium,
                        fontWeight = FontWeight.SemiBold,
                        color = WhiteSavvy,
                        fontFamily = poppinsFontFamily,

                        )
                    Text(
                        text = "Senin",
                        style = Typography.bodySmall,
                        color = WhiteSavvy,
                        fontFamily = poppinsFontFamily,
                        modifier = Modifier
                            .padding(5.dp)

                        )
                }
                Column {
                    Row {
                        Icon(
                            painter = painterResource(id = R.drawable.panahatas),
                            contentDescription = "Google Icon",
                            modifier = Modifier
                                .size(15.dp)
                                .padding(2.dp),
                            tint = OrangeSavvy
                        )
                        Column(
                            modifier = Modifier
                                .padding(start = 2.dp)
                        ) {
                            Text(
                                text = "Makanan & Minuman",
                                style = Typography.bodySmall,
                                color = WhiteSavvy,
                                fontFamily = poppinsFontFamily,

                                )
                            Text(
                                text = "Nasi Ayam",
                                style = Typography.bodySmall,
                                color = PurpleSavvy3,
                                fontFamily = poppinsFontFamily,

                                )
                        }
                    }
                        Row {
                            Icon(
                                painter = painterResource(id = R.drawable.panahbawah),
                                contentDescription = "Google Icon",
                                modifier = Modifier
                                    .size(15.dp)
                                    .padding(2.dp),
                                tint = Color.Green
                            )
                            Column(
                                modifier = Modifier
                                    .padding(start = 2.dp)
                            ) {
                                Text(
                                    text = "Mandiri",
                                    style = Typography.bodySmall,
                                    color = WhiteSavvy,
                                    fontFamily = poppinsFontFamily,

                                    )
                                Text(
                                    text = "Transfer dari Alfred",
                                    style = Typography.bodySmall,
                                    color = PurpleSavvy3,
                                    fontFamily = poppinsFontFamily,
                                )
                            }
                        }


                }
                Row {
                    Text(
                        text = "18",
                        style = Typography.titleMedium,
                        fontWeight = FontWeight.SemiBold,
                        color = WhiteSavvy,
                        fontFamily = poppinsFontFamily,

                        )
                    Text(
                        text = "Selasa",
                        style = Typography.bodySmall,
                        color = WhiteSavvy,
                        fontFamily = poppinsFontFamily,
                        modifier = Modifier
                            .padding(5.dp)

                    )
                }
                Column {
                    Row {
                        Icon(
                            painter = painterResource(id = R.drawable.panahatas),
                            contentDescription = "Google Icon",
                            modifier = Modifier
                                .size(15.dp)
                                .padding(2.dp),
                            tint = OrangeSavvy
                        )
                        Column(
                            modifier = Modifier
                                .padding(start = 2.dp)
                        ) {
                            Text(
                                text = "Kesehatan",
                                style = Typography.bodySmall,
                                color = WhiteSavvy,
                                fontFamily = poppinsFontFamily,

                                )
                            Text(
                                text = "Panadol",
                                style = Typography.bodySmall,
                                color = PurpleSavvy3,
                                fontFamily = poppinsFontFamily,

                                )
                        }
                    }
                    Row {
                        Icon(
                            painter = painterResource(id = R.drawable.panahbawah),
                            contentDescription = "Google Icon",
                            modifier = Modifier
                                .size(15.dp)
                                .padding(2.dp),
                            tint = Color.Green
                        )
                        Column(
                            modifier = Modifier
                                .padding(start = 2.dp)
                        ) {
                            Text(
                                text = "Mandiri",
                                style = Typography.bodySmall,
                                color = WhiteSavvy,
                                fontFamily = poppinsFontFamily,

                                )
                            Text(
                                text = "THR dari paman",
                                style = Typography.bodySmall,
                                color = PurpleSavvy3,
                                fontFamily = poppinsFontFamily,
                            )
                        }
                    }

                }

            }
            Column (
                modifier = Modifier
                    .padding(start = 25.dp)
            ) {
                Text(
                    text = "Rp22,000",
                    style = Typography.bodyMedium,
                    color = WhiteSavvy,
                    )
                Spacer(modifier = Modifier.height(25.dp))
                Text(
                    text = "Rp10,000",
                    style = Typography.bodySmall,
                    color = PurpleSavvy3,
                )
                Spacer(modifier = Modifier.height(15.dp))
                Text(
                    text = "Rp12,000",
                    style = Typography.bodySmall,
                    color = PurpleSavvy3,
                )
                Spacer(modifier = Modifier.height(7.dp))
                Text(
                    text = "Rp22,000",
                    style = Typography.bodyMedium,
                    color = WhiteSavvy,
                )
                Spacer(modifier = Modifier.height(20.dp))
                Text(
                    text = "Rp10,000",
                    style = Typography.bodySmall,
                    color = PurpleSavvy3,
                )
                Spacer(modifier = Modifier.height(15.dp))
                Text(
                    text = "Rp12,000",
                    style = Typography.bodySmall,
                    color = PurpleSavvy3,
                )

            }


        }

    }
}

@Preview(showBackground = true)
@Composable
fun MonthlyScreenPreview() {
    MonthlyScreen(navController = rememberNavController())
}
