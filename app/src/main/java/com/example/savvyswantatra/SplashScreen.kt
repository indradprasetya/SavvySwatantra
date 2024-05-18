package com.example.savvyswantatra

import androidx.compose.animation.core.Animatable
import androidx.compose.animation.core.FastOutSlowInEasing
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.savvyswantatra.navigation.Screen
import com.example.savvyswantatra.ui.theme.Typography
import com.example.savvyswantatra.ui.theme.WhiteSavvy
import kotlinx.coroutines.delay

@Composable
fun SplashScreen(navController: NavController) {
    val scale = remember { Animatable(0f) }
    LaunchedEffect(key1 = true) {
        scale.animateTo(
            targetValue = 1f,
            animationSpec = tween(
                durationMillis = 500,
                easing = FastOutSlowInEasing
            )
        )
        delay(2000) // Lama splash screen ditampilkan
        navController.navigate(Screen.preLogin1.route) {
            popUpTo(Screen.Splash.route) { inclusive = true }
        }
    }
    Box(modifier = Modifier
        .fillMaxSize()
        .background(Color((0xFF392467))), contentAlignment = Alignment.Center, ) {
        Image(
            painter = painterResource(id = R.drawable.logo_awal),
            contentDescription = "Splash Screen",
            modifier = Modifier.scale(1.5f)
        )
        Text(
            text = "Savvy",
            style = Typography.titleLarge,
            textAlign = TextAlign.Center,
            color = WhiteSavvy,
            modifier = Modifier.padding(top = 120.dp)
        )
    }
}