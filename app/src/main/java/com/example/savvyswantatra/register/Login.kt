package com.example.savvyswantatra.register

import android.widget.Space
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.example.savvyswantatra.R
import com.example.savvyswantatra.ui.theme.OrangeSavvy
import com.example.savvyswantatra.ui.theme.PurpleSavvy1
import com.example.savvyswantatra.ui.theme.PurpleSavvy2
import com.example.savvyswantatra.ui.theme.Typography
import com.example.savvyswantatra.ui.theme.poppinsFontFamily

@Composable
fun Login() {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Top,
        modifier = Modifier.fillMaxSize()
    ) {
//        Title
        Spacer(modifier = Modifier.height(100.dp))
        Text(text = "Masuk Aplikasi", style = Typography.titleLarge, color = PurpleSavvy1)
        Text(
            text = "Silahkan masukkan akun Anda\nyang telah terdaftar",
            style = Typography.labelSmall,
            textAlign = TextAlign.Center,
            color = PurpleSavvy2
        )
        Spacer(modifier = Modifier.height(70.dp))
//        Form
        OutlinedTextField(
            value = "",
            onValueChange = {},
            label = { Text("E-mail", fontFamily = poppinsFontFamily) })
        OutlinedTextField(
            value = "",
            onValueChange = {},
            label = { Text("Password", fontFamily = poppinsFontFamily) })
        Row(modifier = Modifier.offset(y = 10.dp)) {
            Text(text = "Lupa Kata Sandi?", style = Typography.bodyMedium, color = PurpleSavvy1)
            Text(
                text = " Atur Ulang",
                style = Typography.bodyMedium,
                color = OrangeSavvy,
                modifier = Modifier.clickable {})
        }
//        Button
        Spacer(modifier = Modifier.height(40.dp))
        Button(
            onClick = { /*TODO*/ },
            colors = ButtonDefaults.buttonColors(containerColor = OrangeSavvy),
            shape = RoundedCornerShape(10.dp),
            modifier = Modifier
                .size(width = 280.dp, height = 46.dp)
        ) {
            Text(text = "Masuk", style = Typography.displayMedium)
        }
        Text(
            text = "Atau",
            style = Typography.displayMedium,
            color = PurpleSavvy1,
            modifier = Modifier.padding(top = 10.dp, bottom = 10.dp)
        )
        Button(
            onClick = { /*TODO*/ },
            colors = ButtonDefaults.buttonColors(containerColor = OrangeSavvy),
            shape = RoundedCornerShape(10.dp),
            modifier = Modifier
                .size(width = 280.dp, height = 46.dp)
        ) {
            Image(painter = painterResource(id = R.drawable.google), contentDescription = "google")
            Spacer(modifier = Modifier.width(10.dp))
            Text(text = "Masuk dengan Google", style = Typography.displayMedium)
        }
        Row() {
            Text(text = "Belum Punya Akun?", style = Typography.bodyMedium, color = PurpleSavvy1)
            Text(
                text = " Daftar",
                style = Typography.bodyMedium,
                color = OrangeSavvy,
                modifier = Modifier.clickable {})
        }
    }
}