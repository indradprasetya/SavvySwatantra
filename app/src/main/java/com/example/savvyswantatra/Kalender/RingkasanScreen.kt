package com.example.savvyswantatra.Kalender

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Card
import androidx.compose.material3.Divider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.savvyswantatra.ui.theme.OrangeSavvy
import com.example.savvyswantatra.ui.theme.PurpleSavvy1
import com.example.savvyswantatra.ui.theme.PurpleSavvy2
import com.example.savvyswantatra.ui.theme.PurpleSavvy3
import com.example.savvyswantatra.ui.theme.Typography
import com.example.savvyswantatra.ui.theme.WhiteSavvy
import com.example.savvyswantatra.ui.theme.poppinsFontFamily


@Composable
fun RingkasanScreen (){
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
        Row (
            modifier = Modifier
                .padding(vertical = 155.dp)
        ){
            Spacer(modifier = Modifier.width(25.dp))
            Text(
                text = "Kalender",
                style = Typography.bodySmall,
                color = WhiteSavvy,


                )
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
            Text(
                text = "Bulanan",
                style = Typography.bodySmall,
                color = WhiteSavvy,


                )
            Spacer(modifier = Modifier.width(25.dp))
            Column {
                Text(
                    text = "Ringkasan",
                    style = Typography.bodySmall,
                    color = WhiteSavvy,

                    )
                Spacer(modifier = Modifier.height(5.dp))
                Divider(modifier = Modifier
                    .width(60.dp),
                    thickness = 4.dp,
                    color = OrangeSavvy
                )
            }

        }
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

                Spacer(modifier = Modifier
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

                Spacer(modifier = Modifier
                    .width(60.dp)
                )
                Column {
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
        }
        Column {
            PieChart()
        }
    }
}

@Composable
fun PieChart(){

}

@Preview(showBackground = true)
@Composable
fun RingkasanScreenPreview() {
    RingkasanScreen()
}
