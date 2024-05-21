package com.example.savvyswantatra

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.requiredHeight
import androidx.compose.foundation.layout.requiredWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.savvyswantatra.navigation.Screen
import com.example.savvyswantatra.ui.theme.Typography


@Composable

fun Wt1_screen(navController: NavController) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFF392467)),
        contentAlignment = Alignment.Center,
        content = {
            Image(
                painter = painterResource(id = R.drawable.gelombang1),
                contentDescription ="",
                modifier = Modifier
                    .requiredWidth(width = 646.dp)
                    .requiredHeight(height = 613.dp)
                    .offset(y = 190.dp)
            )
            Image(
                painter = painterResource(id = R.drawable.icon_celengan),
                contentDescription ="icon celengan",
                modifier = Modifier
                    .requiredWidth(width = 240.dp)
                    .requiredHeight(height = 300.dp)
                    .offset(y = (-70).dp)
            )
            Text(
                text = "Tidak perlu khawatir ",
                color = Color(0xff392467),
                textAlign = TextAlign.Center,
                style = Typography.titleLarge,
                modifier = Modifier.padding(top = 200.dp))

            Text(
                text = "Dengan Savvy finansial anda \npasti terkendali",
                color = Color(0xff5d3587),
                textAlign = TextAlign.Center,
                style = Typography.labelSmall,
                modifier = Modifier.padding(top = 280.dp)
            )
            Button(
                onClick = { navController.navigate(Screen.preLogin2.route) },
                shape = RoundedCornerShape(10.dp),
                colors = ButtonDefaults.buttonColors(containerColor = Color(0xffeb7f63)),
                contentPadding = PaddingValues(all = 10.dp),
                modifier = Modifier
                    .requiredWidth(width = 186.dp)
                    .requiredHeight(height = 46.dp)
                    .offset(y = 300.dp)
            ) {
                Text(
                    text = "Lanjut",
                    color = Color.White,
                    textAlign = TextAlign.Center,
                    style = Typography.displayMedium
                )
            }


        }
    )

}

@Composable
fun Wt2_screen(navController: NavController) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFF392467)),
        contentAlignment = Alignment.Center,
        content = {
            Image(
                painter = painterResource(id = R.drawable.gelombang2),
                contentDescription ="",
                modifier = Modifier
                    .requiredWidth(width = 646.dp)
                    .requiredHeight(height = 613.dp)
                    .offset(y = 190.dp)
            )
            Image(
                painter = painterResource(id = R.drawable.icon_cewek),
                contentDescription ="icon celengan",
                modifier = Modifier
                    .requiredWidth(width = 240.dp)
                    .requiredHeight(height = 300.dp)
                    .offset(y = (-70).dp)
            )
            Text(
                text = "Selalu Hadir ",
                color = Color(0xff392467),
                textAlign = TextAlign.Center,
                style = Typography.titleLarge,
                modifier = Modifier.padding(top = 200.dp))

            Text(
                text = " Savvy akan selalu hadir dalam \n" +
                        "membantu finansial anda",
                color = Color(0xff5d3587),
                textAlign = TextAlign.Center,
                style = Typography.labelSmall,
                modifier = Modifier.padding(top = 280.dp)
            )
            Button(
                onClick = { navController.navigate(Screen.preLogin3.route)},
                shape = RoundedCornerShape(10.dp),
                colors = ButtonDefaults.buttonColors(containerColor = Color(0xffeb7f63)),
                contentPadding = PaddingValues(all = 10.dp),
                modifier = Modifier
                    .requiredWidth(width = 186.dp)
                    .requiredHeight(height = 46.dp)
                    .offset(y = 300.dp)
            ) {
                Text(
                    text = "Lanjut",
                    color = Color.White,
                    textAlign = TextAlign.Center,
                    style = Typography.displayMedium
                )
            }


        }
    )

}
@Composable
fun Wt3_screen(navController: NavController) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFF392467)),
        contentAlignment = Alignment.Center,
        content = {
            Image(
                painter = painterResource(id = R.drawable.gelombang3),
                contentDescription ="",
                modifier = Modifier
                    .requiredWidth(width = 646.dp)
                    .requiredHeight(height = 613.dp)
                    .offset(y = 190.dp)
            )
            Image(
                painter = painterResource(id = R.drawable.icon_impian),
                contentDescription ="icon celengan",
                modifier = Modifier
                    .requiredWidth(width = 240.dp)
                    .requiredHeight(height = 300.dp)
                    .offset(y = (-70).dp)
            )
            Text(
                text = "Wujudkan Impian ",
                color = Color(0xff392467),
                textAlign = TextAlign.Center,
                style = Typography.titleLarge,
                modifier = Modifier.padding(top = 200.dp))

            Text(
                text = " Bersama Savvy wujudkan impian finansial\n" +
                        "yang sehat untuk masa depan lebih baik",
                color = Color(0xff5d3587),
                textAlign = TextAlign.Center,
                style = Typography.labelSmall,
                modifier = Modifier.padding(top = 280.dp)
            )
            Button(
                onClick = { navController.navigate(Screen.beranda.route)},
                shape = RoundedCornerShape(10.dp),
                colors = ButtonDefaults.buttonColors(containerColor = Color(0xffeb7f63)),
                contentPadding = PaddingValues(all = 10.dp),
                modifier = Modifier
                    .requiredWidth(width = 186.dp)
                    .requiredHeight(height = 46.dp)
                    .offset(y = 300.dp)
            ) {
                Text(
                    text = "Lanjut",
                    color = Color.White,
                    textAlign = TextAlign.Center,
                    style = Typography.displayMedium
                )
            }


        }
    )

}