package com.example.savvyswantatra.Kalender

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Card
import androidx.compose.material3.CardColors
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Divider
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
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
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.savvyswantatra.R
import com.example.savvyswantatra.component.TransaksiBulanan
import com.example.savvyswantatra.component.TransaksibulananData
import com.example.savvyswantatra.component.getEndDateOfMonth
import com.example.savvyswantatra.component.getMonthIndex
import com.example.savvyswantatra.component.kalenderbar
import com.example.savvyswantatra.component.monthNames
import com.example.savvyswantatra.ui.theme.OrangeSavvy
import com.example.savvyswantatra.ui.theme.PurpleSavvy1
import com.example.savvyswantatra.ui.theme.PurpleSavvy2
import com.example.savvyswantatra.ui.theme.PurpleSavvy3
import com.example.savvyswantatra.ui.theme.Typography
import com.example.savvyswantatra.ui.theme.WhiteSavvy
import com.example.savvyswantatra.ui.theme.poppinsFontFamily
import java.text.DateFormatSymbols
import java.util.Calendar


@Composable
fun MonthlyScreen(navController : NavController) {
    var selectedMonth by remember { mutableStateOf<String?>(null) }
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
    Card(
        shape = RectangleShape,
        modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight()
            .padding(top = 180.dp)
            .padding(bottom = 45.dp),
        colors = CardDefaults.cardColors(containerColor = WhiteSavvy),


        ) {
        Row(
            modifier = Modifier
                .padding(top = 15.dp)
        )
        {
            Spacer(
                modifier = Modifier
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

            Spacer(
                modifier = Modifier
                    .width(45.dp)
            )
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center,
            ) {
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

        Column(modifier = Modifier
            .padding(10.dp)
            .navigationBarsPadding()
        ) {
            monthNames.forEach { month ->
                LazyColumn(modifier = Modifier.padding(16.dp)) {
                    items(monthNames) { month ->
                        Text(
                            text = month,
                            style = Typography.titleMedium,
                            color = PurpleSavvy1,
                            modifier = Modifier
                                .padding(vertical = 8.dp)
                                .clickable { selectedMonth = month }
                        )
                        // Ketika bulan dipencet, tampilkan kartu transaksi untuk bulan tersebut
                        if (selectedMonth == month) {
                            MonthlyCard(
                                month = month,
                                transactions = TransaksibulananData[month] ?: emptyList()
                            )
                            Spacer(modifier = Modifier.height(10.dp))
                        } else {
                            // Tambahkan tombol atau cara lain untuk memilih bulan
                            Divider(modifier = Modifier.fillMaxWidth(), color = PurpleSavvy1)
                            Spacer(modifier = Modifier.height(20.dp))

                        }
                    }
                }
            }
        }
    }
}

@Composable
    fun MonthlyCard(month: String, transactions: List<TransaksiBulanan>) {
        Card(
            shape = RoundedCornerShape(5.dp),
            colors = CardDefaults.cardColors(containerColor = PurpleSavvy1),
            modifier = Modifier
                .fillMaxWidth(),
        ) {
            Column(
                modifier = Modifier.padding(16.dp)
            ) {
                val startDate = "01"
                val endDate = getEndDateOfMonth(month)
                Text(
                    text = "$startDate/${getMonthIndex(month)} - $endDate/${getMonthIndex(month)}",
                    style = Typography.titleSmall,
                    color = WhiteSavvy,
                )
                Spacer(modifier = Modifier.height(10.dp))

                transactions.forEach { transaction ->
                    TransactionItem(transaction = transaction)
                    Spacer(modifier = Modifier.height(8.dp))
                }
            }
        }
}


@Composable
    fun TransactionItem(transaction: TransaksiBulanan) {
        Column {
            Text(
                text = transaction.catatan,
                style = Typography.bodyMedium,
                color = WhiteSavvy,
            )
            Text(
                text = "Rp ${transaction.jumlah}",
                style = Typography.bodySmall,
                color = WhiteSavvy,
            )
        }
    }


@Preview(showBackground = true)
@Composable
fun MonthlyScreenPreview() {
    val navController = rememberNavController()
    MonthlyScreen(navController)
}