package com.example.savvyswantatra.Kalender

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AddCircle
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.ArrowForward
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Divider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
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
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.zIndex
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.savvyswantatra.component.kalenderbar
import com.example.savvyswantatra.ui.theme.OrangeSavvy
import com.example.savvyswantatra.ui.theme.Pink40
import com.example.savvyswantatra.ui.theme.Pinkeu
import com.example.savvyswantatra.ui.theme.PurpleSavvy1
import com.example.savvyswantatra.ui.theme.PurpleSavvy2
import com.example.savvyswantatra.ui.theme.PurpleSavvy3
import com.example.savvyswantatra.ui.theme.Typography
import com.example.savvyswantatra.ui.theme.WhiteSavvy
import androidx.compose.foundation.BorderStroke
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.platform.LocalContext
import com.example.savvyswantatra.ui.theme.poppinsFontFamily
import java.text.SimpleDateFormat
import java.time.LocalDate
import java.time.YearMonth
import java.util.Calendar
import java.util.Locale

@Composable
fun TampilanKalender(navController: NavController) {
    var currentMonth by remember { mutableStateOf(Calendar.getInstance().get(Calendar.MONTH)) }
    var currentYear by remember { mutableStateOf(Calendar.getInstance().get(Calendar.YEAR)) }

    val calendar = Calendar.getInstance()
    calendar.set(Calendar.MONTH, currentMonth)
    calendar.set(Calendar.YEAR, currentYear)

    kalenderbar(navController = navController,
        currentMonth = currentMonth,
        currentYear = currentYear,
        onPreviousMonth = {
            if (currentMonth == 0) {
                currentMonth = 11
                currentYear--
            } else {
                currentMonth--
            }
        },
        onNextMonth = {
            if (currentMonth == 11) {
                currentMonth = 0
                currentYear++
            } else {
                currentMonth++
            }
        })
    Card(
        shape = RectangleShape,
        modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight()
            .padding(top = 180.dp),
        colors = CardDefaults.cardColors(containerColor = WhiteSavvy)


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
        Spacer(modifier = Modifier.height(10.dp))
        //hari()

        SimpleCalendar(currentMonth, currentYear, navController)


    }
}
/*
@Composable
fun hari() {
    Card(
        shape = RoundedCornerShape(5.dp),
        modifier = Modifier
            .width(400.dp) // Set the width of the card to 318.dp
            .height(30.dp)
            .padding(horizontal = 24.dp)
            .padding(top = 5.dp),
        colors = CardDefaults.cardColors(containerColor = PurpleSavvy1)
    ) {
        Row(
            modifier = Modifier
                .padding(vertical = 5.dp)
                .padding(horizontal = 27.dp)
        ) {

            Text(
                text = "Min",
                style = Typography.bodySmall,
                color = WhiteSavvy,

                )
            Spacer(modifier = Modifier.width(20.dp))
            Text(
                text = "Sen",
                style = Typography.bodySmall,
                color = WhiteSavvy,

                )
            Spacer(modifier = Modifier.width(20.dp))
            Text(
                text = "Sel",
                style = Typography.bodySmall,
                color = WhiteSavvy,


                )
            Spacer(modifier = Modifier.width(20.dp))
            Text(
                text = "Rab",
                style = Typography.bodySmall,
                color = WhiteSavvy,


                )
            Spacer(modifier = Modifier.width(20.dp))
            Text(
                text = "Kam",
                style = Typography.bodySmall,
                color = WhiteSavvy,

                )
            Spacer(modifier = Modifier.width(20.dp))
            Text(
                text = "Jumat",
                style = Typography.bodySmall,
                color = WhiteSavvy,

                )
            Spacer(modifier = Modifier.width(20.dp))
            Text(
                text = "Sabtu",
                style = Typography.bodySmall,
                color = WhiteSavvy,

                )

        }
    }
}*/

@Composable
fun SimpleCalendar(month: Int, year: Int, navController : NavController) {
    val calendar = Calendar.getInstance()
    calendar.set(Calendar.MONTH, month)
    calendar.set(Calendar.YEAR, year)
    calendar.set(Calendar.DAY_OF_MONTH, 1)

    val daysInMonth = calendar.getActualMaximum(Calendar.DAY_OF_MONTH)
    val firstDayOfWeek = calendar.get(Calendar.DAY_OF_WEEK) - 1

    val weeks = (daysInMonth + firstDayOfWeek + 6) / 7
    val icons = listOf(Icons.Default.AddCircle)


    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp)
    ) {

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 8.dp)
                .background(PurpleSavvy1),
            horizontalArrangement = Arrangement.SpaceAround
        ) {
            val daysOfWeek = listOf("Min", "Sen", "Sel", "Rab", "Kam", "Jum", "Sab")
            for (day in daysOfWeek) {
                Text(
                    text = day,
                    style = Typography.bodySmall,
                    color = WhiteSavvy,
                    textAlign = TextAlign.Center,
                    modifier = Modifier
                        .weight(1f)
                        .padding(vertical = 5.dp)
                )
            }

        }

        }


        LazyVerticalGrid(
            modifier = Modifier
                .offset(y=(1).dp),
            columns = GridCells.Fixed(7),
            contentPadding = PaddingValues(4.dp),

        )
        {
            items(firstDayOfWeek) {
                Box(modifier = Modifier.size(40.dp)) { /* Empty box for padding */ }
            }
            items(daysInMonth) { day ->
                Box(
                    modifier = Modifier
                        .size(70.dp)
                        .padding(4.dp),
                    contentAlignment = Alignment.Center
                ) {
                    Text(
                        text = (day + 1).toString(),
                        style = Typography.bodySmall,
                        color = PurpleSavvy1,
                        textAlign = TextAlign.Center
                    )
                }


            }

        }
    Icon(
        imageVector = Icons.Default.AddCircle,
        contentDescription = "add",
        modifier = Modifier
            .offset(x = (20).dp, y = 0.dp)
            .width(60.dp)
            .height(60.dp)
            .zIndex(1f)// Ikon berada di atas kotak kalender
            .clickable(onClick =
            { navController.navigate("pengeluaranKalender") }),
        tint = Pinkeu
    )

    }

@Preview(showBackground = true)
@Composable
fun TampilanKalenderPreview() {
    TampilanKalender(navController = rememberNavController())
}

