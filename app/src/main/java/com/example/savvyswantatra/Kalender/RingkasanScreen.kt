package com.example.savvyswantatra.Kalender

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Divider
import androidx.compose.material3.Icon
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.graphics.drawscope.drawIntoCanvas
import androidx.compose.ui.graphics.nativeCanvas
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.savvyswantatra.R
import com.example.savvyswantatra.component.kalenderbar
import com.example.savvyswantatra.ui.theme.OrangeSavvy
import com.example.savvyswantatra.ui.theme.PieChartTheme
import com.example.savvyswantatra.ui.theme.Pink80
import com.example.savvyswantatra.ui.theme.Pinkeu
import com.example.savvyswantatra.ui.theme.PurpleSavvy1
import com.example.savvyswantatra.ui.theme.PurpleSavvy2
import com.example.savvyswantatra.ui.theme.PurpleSavvy3
import com.example.savvyswantatra.ui.theme.Typography
import com.example.savvyswantatra.ui.theme.WhiteSavvy
import com.example.savvyswantatra.ui.theme.poppinsFontFamily
import java.util.Calendar
import kotlin.math.PI
import kotlin.math.cos
import kotlin.math.sin

data class PieChartData(val color: Color, val fraction: Float, val label: String)


@Composable
fun RingkasanScreen (navController: NavController){
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
        // Card di bagian bawah
        Card(
            shape = RectangleShape,
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight()
                .padding(top = 180.dp)
                .padding(bottom = 55.dp),
            colors = CardDefaults.cardColors(containerColor = WhiteSavvy)

        ){
            Column(
                modifier = Modifier
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
                        Text("Pemasukan", color = Pinkeu, style = Typography.bodyMedium)
                        Text("Rp0", color = Pinkeu, style = Typography.bodyMedium)
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
                Spacer(modifier = Modifier.height(30.dp))
                Text(
                    text = "Pengeluaran anda",
                    style = Typography.titleMedium,
                    fontFamily = poppinsFontFamily,
                    fontWeight = FontWeight.SemiBold,
                    color = PurpleSavvy1,
                    modifier = Modifier
                        .padding(start = 24.dp)
                )
                Spacer(modifier = Modifier.height(10.dp))
                PieChartTheme {
                    Surface(
                        modifier = Modifier
                            .padding(horizontal = 95.dp)
                            .height(200.dp)
                            .width(200.dp),
                        color = Color.Transparent
                    ) {
                        PieChart(
                            data = listOf(13f, 35f, 25f, 27f),
                            colors = listOf(OrangeSavvy, Pinkeu, PurpleSavvy1, PurpleSavvy3),
                            labels = listOf("13%", "35%", "25%", "27%")
                        )
                    }
                }
                Text(
                    text = "Peringatan",
                    style = Typography.titleMedium,
                    fontFamily = poppinsFontFamily,
                    fontWeight = FontWeight.SemiBold,
                    color = PurpleSavvy1,
                    modifier = Modifier
                        .padding(start = 24.dp)
                )
                Box(
                    modifier = Modifier
                        .padding(vertical = 5.dp)
                        .padding(horizontal = 24.dp)
                        .size(335.dp, 12.dp)
                        .background((Pink80), shape = RoundedCornerShape(6.dp))
                ) {
                    Box(
                        modifier = Modifier
                            .size(260.dp, 12.dp)
                            .background((OrangeSavvy), shape = RoundedCornerShape(6.dp))
                    )
                }
                Row {
                    Column(
                        modifier = Modifier
                            .padding(top = 20.dp)
                            .padding(start = 24.dp)
                    ) {
                        Icon(
                            painter = painterResource(id = R.drawable.makananminuman),
                            contentDescription = "",
                            modifier = Modifier
                                .size(50.dp),
                            tint = Color.Unspecified
                        )
                        Spacer(modifier = Modifier.height(12.dp))
                        Icon(
                            painter = painterResource(id = R.drawable.shoppingicon),
                            contentDescription = "",
                            modifier = Modifier
                                .size(50.dp)
                                .padding(start = 1.dp),
                            tint = Color.Unspecified
                        )
                        Spacer(modifier = Modifier.height(12.dp))
                        Icon(
                            painter = painterResource(id = R.drawable.kesehatanicon),
                            contentDescription = "",
                            modifier = Modifier
                                .size(50.dp)
                                .padding(start = 1.dp),
                            tint = Color.Unspecified
                        )
                        Spacer(modifier = Modifier.height(12.dp))
                        Icon(
                            painter = painterResource(id = R.drawable.travelicon),
                            contentDescription = "",
                            modifier = Modifier
                                .size(50.dp)
                                .padding(start = 1.dp),
                            tint = Color.Unspecified
                        )
                    }
                    Spacer(modifier = Modifier.width(30.dp))
                    ProgressBarExample()
                }

            }


        }

    }

@Composable
fun PieChart(
    data: List<Float>,
    colors: List<Color>,
    labels: List<String>,
    modifier: Modifier = Modifier
) {
    val total = data.sum()
    val proportions = data.map { it / total }
    val sweepAngles = proportions.map { 360 * it }

    Canvas(modifier = modifier) {
        var startAngle = 0f
        for ((index, angle) in sweepAngles.withIndex()) {
            drawArc(
                color = colors[index],
                startAngle = startAngle,
                sweepAngle = angle,
                useCenter = true,
                size = Size(size.width, size.height)
            )


            // Menghitung posisi tengah slice
            val halfAngle = startAngle + angle / 2
            val radius = size.minDimension / 4f
            val labelRadius = radius + size.minDimension / 8f
            val xPos = (size.width / 2) + labelRadius * cos(halfAngle * PI / 180)- 30
            val yPos = (size.height / 2) + labelRadius * sin(halfAngle * PI / 180)

            // Menggambar label
            drawIntoCanvas { canvas ->
                val paint = android.graphics.Paint()
                paint.textSize = 30f
                paint.color = android.graphics.Color.WHITE
                paint.typeface=android.graphics.Typeface.DEFAULT_BOLD
                canvas.nativeCanvas.drawText(labels[index], xPos.toFloat(), yPos.toFloat(), paint)
            }


            startAngle += angle
        }
        // Gambar lingkaran putih di tengah
        drawCircle(color = Color.White, radius = size.minDimension / 4f)
    }
}






@Composable
fun ProgressBarExample() {
    val progressData = listOf(0.79f, 0.45f, 0.60f, 0.30f) // Contoh nilai progress
    val colors = listOf(Pinkeu, PurpleSavvy3,OrangeSavvy,  PurpleSavvy1) // Contoh warna
    val progressTexts = listOf("Makanan dan Minuman", "Belanja", "Kesehatan", "Travel")
    Column {
        progressData.forEachIndexed { index, progress ->
            Column {
                Spacer(modifier = Modifier.height(20.dp))
                Text(
                    text = progressTexts[index],
                    style = Typography.bodyMedium,
                    color = PurpleSavvy1
                )
                Spacer(modifier = Modifier.height(5.dp)) // Jarak antara teks dan progress bar
                Box(
                    modifier = Modifier
                        .padding(vertical = 4.dp)
                        .size(254.dp, 12.dp)
                        .background((Pink80), shape = RoundedCornerShape(6.dp))
                ) {
                    Box(
                        modifier = Modifier
                            .fillMaxWidth(progress)
                            .fillMaxHeight()
                            .background(colors[index], shape = RoundedCornerShape(6.dp))
                    )
                }
            }
        }

    }
}

