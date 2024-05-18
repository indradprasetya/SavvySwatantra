package com.example.savvyswantatra.register

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults.buttonColors
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.savvyswantatra.ui.theme.OrangeSavvy
import com.example.savvyswantatra.ui.theme.PurpleSavvy1
import com.example.savvyswantatra.ui.theme.PurpleSavvy2
import com.example.savvyswantatra.ui.theme.Typography
import com.example.savvyswantatra.ui.theme.poppinsFontFamily

@Composable
fun Register() {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Top,
        modifier = Modifier.fillMaxSize()
    ) {
//        Title
        Spacer(modifier = Modifier.height(100.dp))
        Text(text = "Selamat Datang!", style = Typography.titleLarge, color = PurpleSavvy1)
        Text(
            text = "Sikahkan  isi form dibawah ini untuk \n membuat akun savvy anda",
            style = Typography.labelSmall,
            textAlign = TextAlign.Center,
            color = PurpleSavvy2
        )
        Spacer(modifier = Modifier.height(70.dp))
//        Form
        OutlinedTextField(
            value = "",
            onValueChange = {},
            label = { Text("Nama", fontFamily = poppinsFontFamily) })
        OutlinedTextField(
            value = "",
            onValueChange = {},
            label = { Text("Email", fontFamily = poppinsFontFamily) })
        OutlinedTextField(
            value = "",
            onValueChange = {},
            label = { Text("Password", fontFamily = poppinsFontFamily) })

        OutlinedTextField(
            value = "",
            onValueChange = {},
            label = { Text("Ulangi Password", fontFamily = poppinsFontFamily) })
//        Button
        Button(
            onClick = { /*TODO*/ },
            colors = buttonColors(containerColor = OrangeSavvy),
            shape = RoundedCornerShape(10.dp),
            modifier = Modifier
                .size(width = 186.dp, height = 46.dp)
                .offset(y = 170.dp)
        ) {
            Text(text = "Lanjut", style = Typography.displayMedium)
        }


    }


}

