package com.example.savvyswantatra.component

import android.provider.ContactsContract.Data
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
import com.example.savvyswantatra.Kalender.CalendarView
import com.example.savvyswantatra.R
import com.example.savvyswantatra.model.DummyData
import com.example.savvyswantatra.model.TransaksiKalender
import com.example.savvyswantatra.navigation.Screen
import com.example.savvyswantatra.ui.theme.*
import java.time.YearMonth
import java.time.format.TextStyle
import java.util.*
import com.example.savvyswantatra.model.KalenderData


@Composable
fun kalenderbar(navController: NavController) {
    // MutableState untuk mengontrol item yang dipilih
    var selectedItem by remember { mutableStateOf<String?>(null) }
    var isKalenderSelected by remember { mutableStateOf(false) }





    // Fungsi untuk menampilkan Divider di bawah item yang dipilih
    fun isItemSelected(item: String): Boolean {
        return selectedItem == item
    }
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
                // Header
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = 40.dp, bottom = 0.dp)
                        .background(color = Color.Transparent)
                        .height(50.dp)
                ) {
                    Text(
                        text = "Transaksi",
                        textAlign = TextAlign.Center,
                        modifier = Modifier.align(Alignment.Center),
                        color = Color.White,
                        style = Typography.titleMedium
                    )
                    Icon(
                        imageVector = Icons.Default.Menu,
                        contentDescription = "Menu Icon",
                        tint = Color.White,
                        modifier = Modifier
                            .align(Alignment.CenterEnd)
                            .padding(end = 25.dp, top = 3.dp)
                            .size(30.dp)
                    )
                }

                // Calendar View
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .background(color = Color.Transparent)
                        .padding(vertical = 0.dp)
                ) {
                    CalendarView()
                }

                // Tabs
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
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Box(modifier = Modifier
                            .clickable(onClick = {
                                selectedItem = "Kalender"
                                navController.navigate("TampilanKalender")
                            })) {
                            Text(
                                text = "Kalender",
                                fontSize = 10.sp,
                                color = Color.White,
                                fontFamily = poppinsFontFamily,
                                modifier = Modifier.clickable(onClick = {
                                    selectedItem = "Kalender"
                                    navController.navigate("TampilanKalender")
                                })
                            )
                            if (selectedItem == "Kalender") {
                                Divider(
                                    modifier = Modifier.width(45.dp)
                                        .align(Alignment.BottomCenter),
                                    thickness = 2.dp,
                                    color = OrangeSavvy
                                )
                            }
                        }
                        Box(modifier = Modifier
                            .clickable(onClick = {
                                selectedItem = "Harian"
                                navController.navigate("harianKalender")
                            })
                            .fillMaxHeight(),
                            contentAlignment = Alignment.Center) {
                            Text(
                                text = "Harian",
                                fontSize = 10.sp,
                                color = Color.White,
                                fontFamily = poppinsFontFamily
                            )
                            if (isItemSelected("Harian")) {
                                Divider(
                                    modifier = Modifier
                                        .align(Alignment.BottomCenter)
                                        .width(45.dp),
                                    thickness = 2.dp,
                                    color = OrangeSavvy // Warna OrangeSavvy
                                )
                            }
                        }
                        Text(
                            text = "Mingguan",
                            fontSize = 10.sp,
                            fontFamily = poppinsFontFamily,
                            color = Color.White,
                            modifier = Modifier.clickable (onClick = { navController.navigate("mingguanKalender") })
                        )

                        Text(
                            text = "Bulanan",
                            fontSize = 10.sp,
                            fontFamily = poppinsFontFamily,
                            color = Color.White,
                            modifier = Modifier.clickable (onClick = { navController.navigate("bulananKalender") })
                        )
                        Text(
                            text = "Ringkasan",
                            fontSize = 10.sp,
                            fontFamily = poppinsFontFamily,
                            color = Color.White,
                            modifier = Modifier.clickable (onClick = { navController.navigate("harianKalender") })
                        )
                    }
                }


//    Box(
//        modifier = Modifier
//            .background(PurpleSavvy1)
//            .fillMaxSize()
//
//    )
//    {
//        Text(
//            text = "Transaksi",
//            style = Typography.titleMedium,
//            fontWeight = FontWeight.SemiBold,
//            color = WhiteSavvy,
//            fontFamily = poppinsFontFamily,
//            modifier = Modifier
//                .align(Alignment.TopCenter)
//                .padding(vertical = 70.dp)
//
//        )
//        Spacer(modifier = Modifier.height(10.dp))
//        Text(
//            text = "Mei 2024",
//            style = Typography.bodySmall,
//            color = WhiteSavvy,
//            fontFamily = poppinsFontFamily,
//            modifier = Modifier
//                .align(Alignment.TopCenter)
//                .padding(vertical = 110.dp)
//
//        )
//        Row(
//            modifier = Modifier
//                .padding(vertical = 155.dp)
//        ) {
//            Spacer(modifier = Modifier.width(25.dp))
//            Column {
//                Text(
//                    text = "Kalender",
//                    style = Typography.bodySmall,
//                    color = Color.White,
//                    modifier = Modifier.clickable (onClick =
//                    { navController.navigate("kalender") })
//                )
//                if (isItemSelected("Kalender")) {
//                    Column {
//                        Spacer(modifier = Modifier.height(5.dp))
//                        Divider(
//                            modifier = Modifier.width(45.dp),
//                            thickness = 4.dp,
//                            color = OrangeSavvy // Warna OrangeSavvy
//                        )
//                    }
//                }
//            }
//            Spacer(modifier = Modifier.width(25.dp))
//            Column {
//                Text(
//                    text = "Harian",
//                    style = Typography.bodySmall,
//                    color = Color.White,
//                    modifier = Modifier.clickable(onClick =
//                    { navController.navigate("harianKalender") })
//                )
//                if (isItemSelected("Harian")) {
//                    Column {
//                        Spacer(modifier = Modifier.height(5.dp))
//                        Divider(
//                            modifier = Modifier.width(45.dp),
//                            thickness = 4.dp,
//                            color = OrangeSavvy  // Warna OrangeSavvy
//                        )
//                    }
//                }
//            }
//
//            Spacer(modifier = Modifier.width(25.dp))
//            Column {
//                Text(
//                    text = "Mingguan",
//                    style = Typography.bodySmall,
//                    color = Color.White,
//                    modifier = Modifier.clickable (onClick =
//                    { navController.navigate("mingguanKalender") })
//                )
//                if (isItemSelected("Mingguan")) {
//                    Column {
//                        Spacer(modifier = Modifier.height(5.dp))
//                        Divider(
//                            modifier = Modifier.width(45.dp),
//                            thickness = 4.dp,
//                            color = OrangeSavvy  // Warna OrangeSavvy
//                        )
//                    }
//                }
//            }
//
//            Spacer(modifier = Modifier.width(25.dp))
//            Column {
//                Text(
//                    text = "Bulanan",
//                    style = Typography.bodySmall,
//                    color = Color.White,
//                    modifier = Modifier.clickable (onClick =
//                    { navController.navigate("bulananKalender") })
//                )
//                if (isItemSelected("bulananKalender")) {
//                    Column {
//                        Spacer(modifier = Modifier.height(5.dp))
//                        Divider(
//                            modifier = Modifier.width(45.dp),
//                            thickness = 4.dp,
//                            color = OrangeSavvy  // Warna OrangeSavvy
//                        )
//                    }
//                }
//            }
//
//            Spacer(modifier = Modifier.width(25.dp))
//            Column {
//                Text(
//                    text = "Ringkasan",
//                    style = Typography.bodySmall,
//                    color = Color.White,
//                    modifier = Modifier.clickable  { setSelectedItem("Ringkasan")
//                        navController.navigate("ringkasanKalender")}
//                )
//                if (isItemSelected("Ringkasan")) {
//                    Column {
//                        Spacer(modifier = Modifier.height(5.dp))
//                        Divider(
//                            modifier = Modifier.width(45.dp),
//                            thickness = 4.dp,
//                            color = OrangeSavvy  // Warna OrangeSavvy
//                        )
//                    }
//                }
//            }
//
//
//            Spacer(modifier = Modifier.width(25.dp))
//        }
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
                    IconButton(onClick = { currentYearMonth = currentYearMonth.minusMonths(1) }) {
                        Icon(
                            imageVector = Icons.Default.ArrowBack,
                            contentDescription = "Previous Month",
                            tint = Color.White,
                            modifier = Modifier.size(20.dp)
                        )
                    }
                    Text(
                        text = "${
                            currentYearMonth.month.getDisplayName(
                                TextStyle.FULL,
                                Locale.getDefault()
                            )
                        } ${currentYearMonth.year}",
                        style = Typography.bodyMedium,
                        textAlign = TextAlign.Center,
                        color = Color.White,
                        fontWeight = FontWeight.Thin
                    )
                    IconButton(onClick = { currentYearMonth = currentYearMonth.plusMonths(1) }) {
                        Icon(
                            imageVector = Icons.Default.ArrowForward,
                            contentDescription = "Next Month",
                            tint = Color.White,
                            modifier = Modifier.size(20.dp)
                        )
                    }
                }
            }

        }
    }
    }
//}

@Preview(showBackground = true)
@Composable
fun PreviewKalenderBar() {
    val navController = rememberNavController()
    kalenderbar(navController = navController)
}




