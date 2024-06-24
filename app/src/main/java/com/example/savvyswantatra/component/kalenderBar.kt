package com.example.savvyswantatra.component

import android.provider.ContactsContract.Data
import android.util.Log
import android.widget.CalendarView
import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
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
import androidx.navigation.compose.rememberNavController
//import com.example.savvyswantatra.Kalender.CalendarView
import com.example.savvyswantatra.R
import com.example.savvyswantatra.model.DummyData
import com.example.savvyswantatra.model.TransaksiKalender
import com.example.savvyswantatra.navigation.Screen
import com.example.savvyswantatra.ui.theme.*
import java.time.YearMonth
import java.time.format.TextStyle
import java.util.*
import com.example.savvyswantatra.model.KalenderData
import java.text.SimpleDateFormat


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

//@Preview(showBackground = true)
//@Composable
//fun PreviewKalenderBar() {
//    val navController = rememberNavController()
//    kalenderbar(navController = navController)
//}




