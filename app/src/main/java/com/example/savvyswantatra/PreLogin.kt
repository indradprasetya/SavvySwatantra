package com.example.savvyswantatra

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.unit.sp
import com.example.savvyswantatra.ui.theme.GraySavvy2
import com.example.savvyswantatra.ui.theme.OrangeSavvy
import com.example.savvyswantatra.ui.theme.PinkSavvy
import com.example.savvyswantatra.ui.theme.PurpleSavvy1
import com.example.savvyswantatra.ui.theme.PurpleSavvy2

@Composable
fun Prelogin() {
    Column {
        Text(text = "Halo Android", fontSize = 60.sp, color = PurpleSavvy1)
        Text(text = "Halo Android", fontSize = 60.sp, color = PurpleSavvy2)
        Text(text = "Halo Android", fontSize = 60.sp, color = GraySavvy2)
        Text(text = "Halo Android", fontSize = 60.sp, color = OrangeSavvy)
        Text(text = "Halo Android", fontSize = 60.sp, color = PinkSavvy)
    }
}