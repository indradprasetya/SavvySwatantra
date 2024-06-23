package com.example.savvyswantatra.Kalender

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.Divider
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.savvyswantatra.component.HarianKalenderItem
import com.example.savvyswantatra.component.kalenderbar
import com.example.savvyswantatra.model.DummyData
import com.example.savvyswantatra.model.DummyDataMingguan
import com.example.savvyswantatra.model.KalenderData
import com.example.savvyswantatra.model.ListItemData
import com.example.savvyswantatra.model.mingguanData
import com.example.savvyswantatra.ui.theme.PurpleSavvy1
import com.example.savvyswantatra.ui.theme.PurpleSavvy2
import com.example.savvyswantatra.ui.theme.Typography
import java.time.format.DateTimeFormatter
import com.example.savvyswantatra.component.MingguanKalenderItem
import java.text.NumberFormat
import java.time.LocalDate
import java.util.Locale


@Composable
fun MingguanKalender(
    navController: NavController,
    itemList: List<mingguanData> = DummyDataMingguan.TanggalList,
    modifier: Modifier = Modifier,
) {
    val groupedByDate = itemList.groupBy { it.date }

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

//            Row(
//                modifier = Modifier
//                    .padding(start = 10.dp, bottom = 10.dp, top = 5.dp, end = 18.dp)
//                    .fillMaxWidth(),
//                verticalAlignment = Alignment.CenterVertically
//            ) {
//                Text(
//                    text = "19",
//                    fontSize = 20.sp,
//                    color = PurpleSavvy1,
//                    style = Typography.bodyMedium,
//                    modifier = Modifier
//                        .align(Alignment.CenterVertically)
//                )
//
//                Spacer(modifier = Modifier.width(5.dp))
//
//                Column(
//                    modifier = Modifier.weight(1f)
//                ) {
//                    Text(
//                        text = "Rabu",
//                        fontSize = 10.sp,
//                        color = PurpleSavvy1,
//                        style = Typography.bodyMedium,
//                        modifier = Modifier
//                    )
//
//                    Text(
//                        text = "Juni 2024",
//                        color = PurpleSavvy1,
//                        style = Typography.bodyMedium,
//                        modifier = Modifier
//                    )
//                }
//
//                Text(
//                    text = "Rp49000",
//                    color = Color.White,
//                    style = Typography.bodyMedium,
//                    fontSize = 10.sp,
//                    modifier = Modifier
//                        .align(Alignment.CenterVertically)
//                        .background(color = PurpleSavvy2,
//                            shape = RoundedCornerShape(5.dp)
//                        )
//                        .padding(7.dp)
//
//                )
//            }
//            val totalPriceByDate = groupedByDate.mapValues { (_, items) ->
//                items.sumOf { it.harga }
//            }
//            val formattedTotal = NumberFormat.getCurrencyInstance(Locale("id", "ID")).format(totalPriceByDate) // Format ke dalam mata uang jika diperlukan

            LazyColumn(
                verticalArrangement = Arrangement.spacedBy(12.dp),
                modifier = modifier
                    .fillMaxHeight()
                    .background(Color.White)
            ) {
                groupedByDate.forEach { (date, items) ->
                    val formattedDate = date.format(DateTimeFormatter.ofPattern("yyyy-MM-dd"))
                    val totalHarga = items.sumOf { it.harga } // Menggunakan sumOf untuk menjumlahkan harga per tanggal
                    val formattedTotal = NumberFormat.getCurrencyInstance(Locale("id", "ID")).format(totalHarga)

                    item {
                        DateHeader(date = formattedDate, total = formattedTotal)
                    }
                    items(items = items) { item ->
                        MingguanKalenderItem(
                            kalender2 = item,
                            modifier = Modifier.padding(horizontal = 5.dp)
                        )
                        Spacer(modifier = Modifier.height(8.dp))
if(items.indexOf(item) < items.size - 1){
    HorizontalDivider(color = PurpleSavvy2, thickness = 2.dp)

}
                        Spacer(modifier = Modifier.height(8.dp)) // Spacer added here

                    }
                }
            }
        }
    }
}
@Composable
fun DateHeader(date: String, total: String, modifier: Modifier = Modifier) {
    val localDate = LocalDate.parse(date, DateTimeFormatter.ofPattern("yyyy-MM-dd"))
    val dayOfMonth = localDate.dayOfMonth.toString()
    val dayOfWeek = localDate.dayOfWeek.getDisplayName(java.time.format.TextStyle.FULL, Locale("id", "ID"))
    val monthYear = localDate.format(DateTimeFormatter.ofPattern("MMMM yyyy", Locale("id", "ID")))
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
                color = PurpleSavvy1,
                style = Typography.bodyMedium,
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

//@Composable
//fun ListByDate(itemList: List<ListItemData>) {
//    val groupedItems = itemList.groupBy { it.date }
//
//    LazyColumn {
//        groupedItems.forEach { (date, items) ->
//            val formattedDate = date.format(DateTimeFormatter.ofPattern("yyyy-MM-dd"))
//
//            // Tampilkan judul tanggal di atas item-item
//            item {
//                Text(
//                    text = "Date: $formattedDate",
//                    style = TextStyle(
//                        fontWeight = FontWeight.Bold,
//                        fontSize = 20.sp,
//                        color = Color.Black
//                    ),
//                    modifier = Modifier
//                        .padding(horizontal = 16.dp, vertical = 8.dp)
//                )
//            }
//
//            // Tampilkan item-item di dalam grup tanggal ini
//            items.forEach { item ->
//                item {
//                    Text(
//                        text = item.name,
//                        style = TextStyle(
//                            fontSize = 16.sp,
//                            color = Color.Gray
//                        ),
//                        modifier = Modifier
//                            .padding(horizontal = 32.dp, vertical = 4.dp)
//                    )
//                }
//            }
//        }
//    }
//}

@Preview(showBackground = true)
@Composable
fun PreviewMingguanKalender() {
    val navController = rememberNavController()
    val itemList = DummyDataMingguan.TanggalList

    MingguanKalender(navController = navController, itemList = itemList)
}
//
//@Composable
//fun MyApp() {
//    val itemList = createDummyData()
//
//    ListByDate(itemList = itemList)
//}
