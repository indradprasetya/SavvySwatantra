    package com.example.savvyswantatra.Kalender

    import android.graphics.Paint.Align
    import android.provider.ContactsContract.Data
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
    import androidx.compose.ui.focus.focusModifier
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
    import androidx.navigation.compose.rememberNavController
    import com.example.savvyswantatra.R
    import com.example.savvyswantatra.model.DummyData
    import com.example.savvyswantatra.model.TransaksiKalender
    import com.example.savvyswantatra.navigation.Screen
    import com.example.savvyswantatra.ui.theme.*
    import com.example.savvyswantatra.component.HarianKalenderItem
    import com.example.savvyswantatra.component.MingguanKalenderItem
    import com.example.savvyswantatra.component.kalenderbar
    import com.example.savvyswantatra.model.DummyDataMingguan
    import com.example.savvyswantatra.model.KalenderData
    import com.example.savvyswantatra.model.mingguanData
    import java.text.NumberFormat
    import java.time.LocalDate
    import java.time.YearMonth
    import java.time.format.DateTimeFormatter
    import java.time.format.TextStyle
    import java.util.*

    @Composable
    fun HarianKalender(
        navController: NavController,
        itemList: List<KalenderData> = DummyData.KalenderList,
        modifier: Modifier = Modifier,
    ) {
        val groupedByDate = itemList.groupBy { it.dateDataHarian }

        kalenderbar(navController)
        Card(
            shape = RectangleShape,
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight()
                .padding(top = 180.dp)
        ) {
            Column(
                modifier = modifier
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

                LazyColumn(
                    verticalArrangement = Arrangement.spacedBy(12.dp),
                    modifier = modifier
                        .fillMaxHeight()
                        .background(Color.White)
                ) {
                    groupedByDate.forEach { (date, items) ->
                        val formattedDate = date.format(DateTimeFormatter.ofPattern("yyyy-MM-dd"))
                        val totalHarga = items.sumOf { it.harga }
                        val formattedTotal =
                            NumberFormat.getCurrencyInstance(Locale("id", "ID")).format(totalHarga)

                        item {
                            DateHeaderHarian(date = formattedDate, total = formattedTotal)
                        }
                        items(items = items) { item ->
                            HarianKalenderItem(
                                kalender1 = item,
                                modifier = Modifier.padding(horizontal = 5.dp)
                            )
                            Spacer(modifier = Modifier.height(8.dp))
                            HorizontalDivider(color = PurpleSavvy2, thickness = 2.dp)

                        }
                    }


                }
            }
        }
    }

    @Composable
    fun DateHeaderHarian(date: String, total: String, modifier: Modifier = Modifier) {
        val localDate =
            LocalDate.parse(date, DateTimeFormatter.ofPattern("yyyy-MM-dd"))
        val dayOfMonth = localDate.dayOfMonth.toString()
        val dayOfWeek = localDate.dayOfWeek.getDisplayName(
            java.time.format.TextStyle.FULL,
            Locale("id", "ID")
        )
        val monthYear = localDate.format(
            DateTimeFormatter.ofPattern(
                "MMMM yyyy",
                Locale("id", "ID")
            )
        )
        Card(
            shape = RectangleShape,
            modifier = modifier
                .fillMaxWidth()
                .padding(vertical = 8.dp)
        ) {
            Row(
                modifier = Modifier
                    .background(Color.White)
                    .padding(8.dp),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Text(
                    text = dayOfMonth,
                    color = PurpleSavvy2,
                    style = Typography.bodyLarge
                )
                Spacer(modifier = Modifier.width(5.dp))

                Column(
                    modifier = Modifier.weight(1f)
                ) {
                    Text(
                        text = dayOfWeek,
                        fontSize = 10.sp,
                        color = PurpleSavvy2,
                        style = Typography.bodyMedium,
                    )

                    Text(
                        text = monthYear,
                        color = PurpleSavvy2,
                        style = Typography.bodyMedium,
                    )
                }

                Text(
                    text = total,
                    color = Color.White,
                    style = Typography.bodyMedium,
                    fontSize = 10.sp,
                    modifier = Modifier
                        .background(
                            color = PurpleSavvy2,
                            shape = RoundedCornerShape(5.dp)
                        )
                        .padding(horizontal = 8.dp, vertical = 4.dp)
                )
            }
        }
    }
    @Preview(showBackground = true)
    @Composable
    fun PreviewHarianKalender() {
        val navController = rememberNavController()
        HarianKalender(navController = navController)
    }



