package com.example.savvyswantatra.navigation

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Home
import com.example.savvyswantatra.R

data class BottomNavigationItem(
    val label: String = "",
    val icon: Int = R.drawable.beranda,
    val route: String = ""
) {
    fun bottomNavigationItems() : List<BottomNavigationItem> {
        return listOf(
            BottomNavigationItem(
                label = "Beranda",
                icon = R.drawable.beranda,
                route = Screen.beranda.route
            ),
            BottomNavigationItem(
                label = "Kalender",
                icon = R.drawable.calendar,
                route = Screen.kalender.route
            ),
            BottomNavigationItem(
                label = "Anggaran",
                icon = R.drawable.anggaran,
                route = Screen.anggaran.route
            ),
            BottomNavigationItem(
                label = "Simpanan",
                icon = R.drawable.simpanan,
                route = Screen.simpanan.route
            ),
            BottomNavigationItem(
                label = "Pengaturan",
                icon = R.drawable.settings,
                route = Screen.pengaturan.route
            ),
        )
    }
}