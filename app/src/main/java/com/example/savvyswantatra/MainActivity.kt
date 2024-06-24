package com.example.savvyswantatra

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.navigation.compose.rememberNavController
import com.example.savvyswantatra.Kalender.HarianKalender
import com.example.savvyswantatra.ui.theme.SavvySwantatraTheme
import com.example.savvyswantatra.navigation.NavigationApp

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            SavvySwantatraTheme {
                // A surface container using the 'background' color from the theme
                Surface(color = MaterialTheme.colorScheme.background) {
                    NavigationApp()
                    }
                }
            }
        }
    }
