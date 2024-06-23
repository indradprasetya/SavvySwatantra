package com.example.savvyswantatra.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.requiredSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
//import com.example.savvyswantatra.model.ListItemData
import com.example.savvyswantatra.ui.theme.PurpleSavvy2
import com.example.savvyswantatra.ui.theme.Typography
import com.example.savvyswantatra.ui.theme.poppinsFontFamily
import java.text.NumberFormat
import java.time.LocalDate
import java.util.Locale

//fun createDummyData(): List<ListItemData> {
//    val dummyData = mutableListOf<ListItemData>()
//    val specificDate = LocalDate.of(2024, 5, 17) // 17 Mei 2024
//
//    // Tambahkan beberapa item untuk tanggal tersebut
//    for (i in 1..50) {
//        dummyData.add(ListItemData(specificDate, "Item $i"))
//    }
//
//    return dummyData
//}
//
//// Contoh penggunaan createDummyData()
//val itemList = createDummyData()


@Composable
fun MingguanKalenderItem(
    kalender2 : com.example.savvyswantatra.model.mingguanData,
    modifier: Modifier,
){
    Row(
        horizontalArrangement = Arrangement.Start,
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier
            .fillMaxWidth()
            .padding(start = 15.dp)

    ) {
        Box(
            modifier = Modifier
                .requiredSize(50.dp)
        ) {
            Box( modifier = Modifier.clip(RoundedCornerShape(20.dp))
            ) {
                Image(
                    painter = painterResource(id = kalender2.image),
                    contentDescription = "Makanan",
                    contentScale = ContentScale.Crop,
                    modifier = Modifier
                        .fillMaxSize()
                )

            }
            Image(
                painter = painterResource(id = kalender2.icon),
                contentDescription = "Pengeluaran Icon",
                modifier = Modifier
                    .requiredSize(20.dp)
                    .align(Alignment.BottomEnd)

            )
        }
        Spacer(modifier = Modifier.height(1.dp))
        Column(modifier = Modifier .padding(8.dp)) {
            Text(

                text = kalender2.kategori,
                color = Color.Black,
                style = Typography.bodyMedium
            )
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(end = 15.dp),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Text(
                    text = kalender2.deskripsi,
                    fontFamily = poppinsFontFamily,
                    fontWeight = FontWeight.SemiBold,
                    fontSize = 12.sp,
                    color = PurpleSavvy2
                )
                Text(
                    text = NumberFormat.getCurrencyInstance(Locale("id", "ID")).format(kalender2.harga),
                    fontFamily = poppinsFontFamily,
                    fontWeight = FontWeight.SemiBold,
                    fontSize = 12.sp,
                    color = PurpleSavvy2
                )
            }
        }
    }
}

