package com.example.savvyswantatra.navigation

import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.savvyswantatra.SplashScreen
import com.example.savvyswantatra.Wt1_screen
import com.example.savvyswantatra.Wt2_screen
import com.example.savvyswantatra.Wt3_screen

@Composable
fun NavigationApp(){
    val navController = rememberNavController()
    NavHost(
        navController = navController,
        startDestination = Screen.Splash.route,
    ) {
        composable( Screen.Splash.route) {
            SplashScreen(navController = navController)
        }
        composable(Screen.preLogin1.route) {
            Wt1_screen(navController = navController)
        }
        composable(Screen.preLogin2.route) {
            Wt2_screen(navController = navController)
        }
        composable(Screen.preLogin3.route) {
            Wt3_screen(navController = navController)
        }

    }
}