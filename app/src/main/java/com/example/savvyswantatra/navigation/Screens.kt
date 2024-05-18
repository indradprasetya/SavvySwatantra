    package com.example.savvyswantatra.navigation



    sealed class  Screen(val route : String){
        data object Splash : Screen("splash")
        data object preLogin1 : Screen("preLogin1")
        data object preLogin2 : Screen("preLogin2")
        data object preLogin3 : Screen("preLogin3")
    }
//    enum class Screens {
//        PreLogin,
//        Login,
//        Register,
//        Verification,
//        PhoneVerification,
//        OTPVerification,
//        Home,
//        Calendar,
//        Budget,
//        Saving,
//        Settings,
//        Profile,
//        Password,
//        Agreement
//    }