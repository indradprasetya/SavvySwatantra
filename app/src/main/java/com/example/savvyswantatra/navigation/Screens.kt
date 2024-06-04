package com.example.savvyswantatra.navigation


sealed class Screen(val route: String) {
    data object Splash : Screen("splash")
    data object preLogin1 : Screen("preLogin1")
    data object preLogin2 : Screen("preLogin2")
    data object preLogin3 : Screen("preLogin3")
    data object beranda : Screen("beranda")
    data object kalender : Screen("kalender")
    data object anggaran : Screen("anggaran")
    data object simpanan : Screen("simpanan")
    data object pengaturan : Screen("pengaturan")
    data object profil : Screen("profil")
    data object register : Screen("register")
    data object login : Screen("login")
    data object verif: Screen("verif")
    data object otpphonenumber : Screen("otpphonenumber")
    data object otpcode : Screen("otocode")
    data object verifsucceed : Screen("verifsucceed")
    data object syaratket : Screen("syaratket")
    data object ubahsandi : Screen("ubahsandi")
    data object tambahsimpanan : Screen("tambahsimpanan")
}




