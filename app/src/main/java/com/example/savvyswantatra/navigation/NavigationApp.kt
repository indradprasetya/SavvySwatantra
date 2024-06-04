package com.example.savvyswantatra.navigation

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.savvyswantatra.AnggaranScreen
import com.example.savvyswantatra.BerandaScreen
import com.example.savvyswantatra.CalenderScreen
import com.example.savvyswantatra.pengaturan.ProfileScreen
import com.example.savvyswantatra.pengaturan.SettingScreen
import com.example.savvyswantatra.SimpananScreen
import com.example.savvyswantatra.SplashScreen
import com.example.savvyswantatra.Wt1_screen
import com.example.savvyswantatra.Wt2_screen
import com.example.savvyswantatra.Wt3_screen
import com.example.savvyswantatra.pengaturan.SyaratKet
import com.example.savvyswantatra.pengaturan.ubahSandi
import com.example.savvyswantatra.register.Login
import com.example.savvyswantatra.register.OtpCode
import com.example.savvyswantatra.register.OtpPhoneNumber
import com.example.savvyswantatra.register.Register
import com.example.savvyswantatra.register.Verif
import com.example.savvyswantatra.register.VerifSucceed
import com.example.savvyswantatra.tambahSimpanan
import com.example.savvyswantatra.ui.theme.PurpleSavvy2
import com.example.savvyswantatra.ui.theme.Typography
import com.example.savvyswantatra.ui.theme.WhiteSavvy

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun NavigationApp() {
    val navController = rememberNavController()
    NavHost(
        navController = navController,
        startDestination = Screen.tambahsimpanan.route
    ) {
        composable(Screen.Splash.route) {
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
        composable(Screen.profil.route) {
            ProfileScreen(navController = navController)
        }
        composable(Screen.register.route) {
            Register(navController = navController)
        }
        composable(Screen.login.route) {
            Login(navController = navController)
        }
        composable(Screen.verif.route) {
            Verif(navController = navController)
        }
        composable(Screen.otpphonenumber.route) {
            OtpPhoneNumber(navController = navController)
        }
        composable(Screen.otpcode.route) {
            OtpCode(navController = navController)
        }
        composable(Screen.verifsucceed.route) {
            VerifSucceed(navController = navController)
        }
        composable(Screen.syaratket.route) {
            SyaratKet()
        }
        composable(Screen.ubahsandi.route) {
            ubahSandi(navController = navController)
        }
        composable(Screen.tambahsimpanan.route) {
            tambahSimpanan(navController = navController)
        }






        composable(Screen.beranda.route) {
            Scaffold(
                modifier = Modifier.fillMaxSize(),
                bottomBar = { BottomNavigationBar(navController) }
            ) {
                BerandaScreen(navController = navController)
            }
        }
        composable(Screen.kalender.route) {
            Scaffold(
                modifier = Modifier.fillMaxSize(),
                bottomBar = { BottomNavigationBar(navController) }
            ) {
                CalenderScreen(navController)
            }
        }
        composable(Screen.anggaran.route) {
            Scaffold(
                modifier = Modifier.fillMaxSize(),
                bottomBar = { BottomNavigationBar(navController) }
            ) {
                AnggaranScreen(navController = navController)
            }
        }
        composable(Screen.simpanan.route) {
            Scaffold(
                modifier = Modifier.fillMaxSize(),
                bottomBar = { BottomNavigationBar(navController) }
            ) {
                SimpananScreen(navController = navController)
            }
        }
        composable(Screen.pengaturan.route) {
            Scaffold(
                modifier = Modifier.fillMaxSize(),
                bottomBar = { BottomNavigationBar(navController) }
            ) {
                SettingScreen(navController = navController)
            }

            }
        }
    }

    @Composable
    fun BottomNavigationBar(navController: NavController) {
        val navBackStackEntry by navController.currentBackStackEntryAsState()
        val currentDestination = navBackStackEntry?.destination

        Surface(
            shape = RoundedCornerShape(topStart = 16.dp, topEnd = 16.dp),
            shadowElevation = 6.dp,
            color = WhiteSavvy
        ) {
            NavigationBar(
                containerColor = WhiteSavvy
            ) {
                BottomNavigationItem().bottomNavigationItems().forEachIndexed { _, navigationItem ->
                    NavigationBarItem(
                        selected = navigationItem.route == currentDestination?.route,
                        label = {
                            Text(
                                navigationItem.label,
                                style = Typography.bodySmall
                            )
                        },
                        icon = {
                            Icon(
                                painter = painterResource(id = navigationItem.icon),
                                contentDescription = navigationItem.label,
                                modifier = Modifier.size(25.dp)
                            )
                        },
                        onClick = {
                            navController.navigate(navigationItem.route) {
                                popUpTo(navController.graph.findStartDestination().id) {
                                    saveState = true
                                }
                                launchSingleTop = true
                                restoreState = true
                            }
                        },
                        colors = androidx.compose.material3.NavigationBarItemDefaults
                            .colors(
                                selectedIconColor = PurpleSavvy2,
                                indicatorColor = WhiteSavvy,
                                selectedTextColor = PurpleSavvy2
                            )
                    )
                }
            }
        }
    }


