package com.example.savvyswantatra.component

import android.util.Log
import androidx.compose.foundation.background
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
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.AppBarDefaults
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.ArrowForward
import androidx.compose.material.icons.filled.KeyboardArrowLeft
import androidx.compose.material.icons.filled.KeyboardArrowRight
import androidx.compose.material3.Divider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.savvyswantatra.ui.theme.OrangeSavvy
import com.example.savvyswantatra.ui.theme.PurpleSavvy1
import com.example.savvyswantatra.ui.theme.Typography
import com.example.savvyswantatra.ui.theme.WhiteSavvy
import com.example.savvyswantatra.ui.theme.poppinsFontFamily
import java.text.SimpleDateFormat
import java.util.Calendar
import java.util.Locale


@Composable
fun kalenderbar(navController: NavController, currentMonth: Int,
                currentYear: Int,
                onPreviousMonth: () -> Unit,
                onNextMonth: () -> Unit) {
    // MutableState untuk mengontrol item yang dipilih


    var (selectedItem, setSelectedItem) = rememberSaveable { mutableStateOf("Kalender") }

    Log.d("KalenderBar", "Recompose with selectedItem: $selectedItem")

    // Fungsi untuk menampilkan Divider di bawah item yang dipilih
    fun isItemSelected(item: String): Boolean {
        return selectedItem == item
    }

    Box(
        modifier = Modifier
            .background(PurpleSavvy1)
            .fillMaxSize()

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
        Spacer(modifier = Modifier.height(20.dp))
        Row(
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .padding(top = 100.dp)
                .padding(start = 15.dp)
                .padding(end = 15.dp)
                .align(Alignment.TopCenter)


        ) {
            Spacer(modifier = Modifier.width(15.dp))
            IconButton(onClick = onPreviousMonth) {
                Icon(
                    Icons.Filled.KeyboardArrowLeft,
                    contentDescription = "Previous Month",
                    tint = WhiteSavvy
                )
            }
            Text(
                text = "${getMonthName(currentMonth)} $currentYear",
                style = Typography.bodySmall,
                color = WhiteSavvy
            )
            IconButton(onClick = onNextMonth) {
                Icon(
                    Icons.Filled.KeyboardArrowRight,
                    contentDescription = "Next Month",
                    tint = WhiteSavvy
                )
            }
            Spacer(modifier = Modifier.width(15.dp))

        }
            Row(
                modifier = Modifier
                    .padding(vertical = 155.dp)
            ) {
                Spacer(modifier = Modifier.width(25.dp))
                Column {
                    Text(
                        text = "Kalender",
                        style = Typography.bodySmall,
                        color = Color.White,
                        modifier = Modifier.clickable {
                            setSelectedItem("Kalender")
                            navController.navigate("kalender")
                        }
                    )
                    if (isItemSelected("Kalender")) {
                        Column {
                            Spacer(modifier = Modifier.height(5.dp))
                            Divider(
                                modifier = Modifier.width(45.dp),
                                thickness = 4.dp,
                                color = OrangeSavvy // Warna OrangeSavvy
                            )
                        }
                    }
                }
                Spacer(modifier = Modifier.width(25.dp))
                Column {
                    Text(
                        text = "Harian",
                        style = Typography.bodySmall,
                        color = Color.White,
                        modifier = Modifier.clickable {
                            setSelectedItem("Harian")
                            navController.navigate("harianKalender")
                        }
                    )
                    if (isItemSelected("Harian")) {
                        Column {
                            Spacer(modifier = Modifier.height(5.dp))
                            Divider(
                                modifier = Modifier.width(45.dp),
                                thickness = 4.dp,
                                color = OrangeSavvy  // Warna OrangeSavvy
                            )
                        }
                    }
                }

                Spacer(modifier = Modifier.width(25.dp))
                Column {
                    Text(
                        text = "Mingguan",
                        style = Typography.bodySmall,
                        color = Color.White,
                        modifier = Modifier.clickable
                        {
                            setSelectedItem("Mingguan")
                            navController.navigate("mingguanKalender")
                        }
                    )
                    if (isItemSelected("Mingguan")) {
                        Column {
                            Spacer(modifier = Modifier.height(5.dp))
                            Divider(
                                modifier = Modifier.width(45.dp),
                                thickness = 4.dp,
                                color = OrangeSavvy  // Warna OrangeSavvy
                            )
                        }
                    }
                }

                Spacer(modifier = Modifier.width(25.dp))
                Column {
                    Text(
                        text = "Bulanan",
                        style = Typography.bodySmall,
                        color = Color.White,
                        modifier = Modifier.clickable
                        {
                            setSelectedItem("bulananKalender")
                            navController.navigate("bulananKalender")
                        }
                    )
                    if (isItemSelected("bulananKalender")) {
                        Column {
                            Spacer(modifier = Modifier.height(5.dp))
                            Divider(
                                modifier = Modifier.width(45.dp),
                                thickness = 4.dp,
                                color = OrangeSavvy  // Warna OrangeSavvy
                            )
                        }
                    }
                }

                Spacer(modifier = Modifier.width(25.dp))
                Column {
                    Text(
                        text = "Ringkasan",
                        style = Typography.bodySmall,
                        color = Color.White,
                        modifier = Modifier.clickable {
                            setSelectedItem("Ringkasan")
                            navController.navigate("ringkasanKalender")
                            Log.d("KalenderBar", "Ringkasan clicked")
                        }
                    )
                    if (isItemSelected("Ringkasan")) {
                        Column {
                            Spacer(modifier = Modifier.height(5.dp))
                            Divider(
                                modifier = Modifier.width(45.dp),
                                thickness = 4.dp,
                                color = OrangeSavvy  // Warna OrangeSavvy
                            )
                        }
                    }
                }


                Spacer(modifier = Modifier.width(25.dp))
            }
        }
    }

fun getMonthName(month: Int): String {
    return SimpleDateFormat("MMMM", Locale("id", "ID")).format(Calendar.getInstance().apply {
        set(Calendar.MONTH, month)
    }.time)
}




