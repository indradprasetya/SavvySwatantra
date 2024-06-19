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
    import com.example.savvyswantatra.component.kalenderbar
    import com.example.savvyswantatra.model.KalenderData
    import java.time.YearMonth
    import java.time.format.TextStyle
    import java.util.*

    @Composable
    fun HarianKalender(
        navController: NavController,
        listData : List<KalenderData> = DummyData.KalenderList,
        modifier: Modifier = Modifier,
    ) {
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

                Row(
                    modifier = Modifier
                        .padding(start = 10.dp, bottom = 10.dp, top = 5.dp, end = 18.dp)
                        .fillMaxWidth(),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(
                        text = "19",
                        fontSize = 20.sp,
                        color = PurpleSavvy1,
                        style = Typography.bodyMedium,
                        modifier = Modifier
                            .align(Alignment.CenterVertically)
                    )

                    Spacer(modifier = Modifier.width(5.dp))

                    Column(
                        modifier = Modifier.weight(1f)
                    ) {
                        Text(
                            text = "Rabu",
                            fontSize = 10.sp,
                            color = PurpleSavvy1,
                            style = Typography.bodyMedium,
                            modifier = Modifier
                        )

                        Text(
                            text = "Juni 2024",
                            color = PurpleSavvy1,
                            style = Typography.bodyMedium,
                            modifier = Modifier
                        )
                    }

                    Text(
                        text = "Rp49000",
                        color = Color.White,
                        style = Typography.bodyMedium,
                        fontSize = 10.sp,
                        modifier = Modifier
                            .align(Alignment.CenterVertically)
                            .background(color = PurpleSavvy2,
                                shape = RoundedCornerShape(5.dp))
                            .padding(7.dp)

                    )
                }

                LazyColumn(
                    verticalArrangement = Arrangement.spacedBy(12.dp),
                    modifier = Modifier
                        .fillMaxHeight() // Pastikan LazyColumn dapat memenuhi ruang yang tersedia
                        .background(Color.White)
                ) {
                    items(listData, key = { it.id }) {
                        HarianKalenderItem(
                            kalender1 = it,
                            modifier = Modifier.padding(horizontal = 5.dp)
                        )
                        if (listData.indexOf(it) < listData.size - 1) {
                            Divider(
                                color = PurpleSavvy2,
                                thickness = 2.dp,
                                modifier = Modifier.padding(
                                    horizontal = 16.dp,
                                    vertical = 15.dp
                                )
                            )
                        }
                    }
                }
            }
        }
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

    @Preview(showBackground = true)
    @Composable
    fun PreviewHarianKalender() {
        val navController = rememberNavController()
        HarianKalender(navController = navController)
    }



