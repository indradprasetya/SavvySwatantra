package com.example.savvyswantatra.register

import android.widget.Space
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.requiredHeight
import androidx.compose.foundation.layout.requiredWidth
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CutCornerShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults.buttonColors
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.savvyswantatra.R
import com.example.savvyswantatra.ui.theme.OrangeSavvy
import com.example.savvyswantatra.ui.theme.PinkSavvy
import com.example.savvyswantatra.ui.theme.PurpleSavvy1
import com.example.savvyswantatra.ui.theme.PurpleSavvy2
import com.example.savvyswantatra.ui.theme.Typography
import com.example.savvyswantatra.ui.theme.WhiteSavvy
import com.example.savvyswantatra.ui.theme.poppinsFontFamily

@Composable
fun Verif() {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Top,
        modifier = Modifier
            .fillMaxSize()
            .background(PurpleSavvy1)
    ) {
//        Title
        Spacer(modifier = Modifier.height(100.dp))
        Text(text = "Verifikasi Akun Anda", style = Typography.titleLarge, color = WhiteSavvy)
        Text(
            text = "Silahkan verifikasi akun Anda terlebih dahulu,\nsebelum masuk ke dalam aplikasi ",
            style = Typography.labelSmall,
            textAlign = TextAlign.Center,
            color = PinkSavvy
        )
//        Image
        Image(
            painter = painterResource(id = R.drawable.verif),
            contentDescription = "verif",
            modifier = Modifier
                .size(258.dp)
                .offset(y = 50.dp)
        )
//        Button
        Button(
            onClick = { /*TODO*/ },
            colors = buttonColors(containerColor = OrangeSavvy),
            shape = RoundedCornerShape(10.dp),
            modifier = Modifier
                .size(width = 186.dp, height = 46.dp)
                .offset(y = 220.dp)
        ) {
            Text(text = "Lanjut", style = Typography.displayMedium)
        }
    }
}

@Composable
fun OtpPhoneNumber() {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Top,
        modifier = Modifier
            .fillMaxSize()
            .background(PurpleSavvy1)
    ) {
//        Title
        Spacer(modifier = Modifier.height(100.dp))
        Text(text = "Masukkan Nomor HP", style = Typography.titleLarge, color = WhiteSavvy)
        Text(
            text = "Masukkan No.HP Anda untuk menerima\nkode OTP",
            style = Typography.labelSmall,
            textAlign = TextAlign.Center,
            color = PinkSavvy
        )
//        Form
        TextField(
            value = "",
            onValueChange = {},
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
            modifier = Modifier.offset(y = 30.dp)
            )
//        Button
            Button(
                onClick = { /*TODO*/ },
                colors = buttonColors(containerColor = OrangeSavvy),
                shape = RoundedCornerShape(10.dp),
                modifier = Modifier
                    .size(width = 186.dp, height = 46.dp)
                    .offset(y = 420.dp)
            ) {
                Text(text = "Kirim Kode OTP", style = Typography.displayMedium)
            }
    }
}

@Composable
fun OtpCode() {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Top,
        modifier = Modifier
            .fillMaxSize()
            .background(PurpleSavvy1)
    ) {
//        Title
        Spacer(modifier = Modifier.height(100.dp))
        Text(text = "Masukkan Kode OTP", style = Typography.titleLarge, color = WhiteSavvy)
        Text(
            text = "Masukkan kode OTP yang Anda terima\nmelalui pesan",
            style = Typography.labelSmall,
            textAlign = TextAlign.Center,
            color = PinkSavvy
        )
//        Form
        TextField(
            value = "",
            onValueChange = {},
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
            modifier = Modifier.offset(y = 30.dp)
        )
//        Button
        Button(
            onClick = { /*TODO*/ },
            colors = buttonColors(containerColor = OrangeSavvy),
            shape = RoundedCornerShape(10.dp),
            modifier = Modifier
                .size(width = 186.dp, height = 46.dp)
                .offset(y = 420.dp)
        ) {
            Text(text = "Verifikasi", style = Typography.displayMedium)
        }
    }
}




