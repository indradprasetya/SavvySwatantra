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
import androidx.compose.material3.LocalTextStyle
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.core.text.isDigitsOnly
import androidx.navigation.NavController
import com.example.savvyswantatra.R
import com.example.savvyswantatra.navigation.Screen
import com.example.savvyswantatra.ui.theme.OrangeSavvy
import com.example.savvyswantatra.ui.theme.PinkSavvy
import com.example.savvyswantatra.ui.theme.PurpleSavvy1
import com.example.savvyswantatra.ui.theme.PurpleSavvy2
import com.example.savvyswantatra.ui.theme.Typography
import com.example.savvyswantatra.ui.theme.WhiteSavvy
import com.example.savvyswantatra.ui.theme.poppinsFontFamily

@Composable
fun Verif(navController: NavController) {
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
            onClick = { navController.navigate(Screen.otpphonenumber.route) },
            colors = buttonColors(containerColor = OrangeSavvy),
            shape = RoundedCornerShape(10.dp),
            modifier = Modifier
                .size(width = 186.dp, height = 46.dp)
                .offset(y = 220.dp)
        ) {
            Text(text = "Lanjut", style = Typography.displayMedium, color = WhiteSavvy)
        }
    }
}

@Composable
fun OtpPhoneNumber(navController: NavController) {
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
        Spacer(modifier = Modifier.height(30.dp))
        var otpPhoneNumberState by remember { mutableStateOf("") }
        OutlinedTextField(
            singleLine = true,
            value = otpPhoneNumberState,
            onValueChange = { if (it.isDigitsOnly()){
                if (it.length <= 13) otpPhoneNumberState = it
            } },
            textStyle = Typography.bodyMedium,
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
            colors = TextFieldDefaults.colors(
                unfocusedContainerColor = WhiteSavvy,
                focusedContainerColor = WhiteSavvy,
                cursorColor = PurpleSavvy2,
                unfocusedTextColor = PurpleSavvy2,
                focusedTextColor = PurpleSavvy2,
            ),
            placeholder = { Text("08xxxxxxxxxx", style = Typography.bodyMedium) },
        )

//        Button
            Button(
                onClick = { navController.navigate(Screen.otpcode.route) },
                colors = buttonColors(containerColor = OrangeSavvy),
                shape = RoundedCornerShape(10.dp),
                modifier = Modifier
                    .size(width = 186.dp, height = 46.dp)
                    .offset(y = 420.dp)
            ) {
                Text(text = "Kirim Kode OTP", style = Typography.displayMedium, color = WhiteSavvy)
            }
    }
}

@Composable
fun OtpCode(navController: NavController) {
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
        Spacer(modifier = Modifier.height(30.dp))
        var otpCodeState by remember { mutableStateOf("") }
        OutlinedTextField(
            singleLine = true,
            value = otpCodeState,
            onValueChange = { if (it.isDigitsOnly()){
                if (it.length <= 4) otpCodeState = it
            } },
            textStyle = LocalTextStyle.current.copy(textAlign = TextAlign.Center, fontStyle = Typography.bodyLarge.fontStyle),
            modifier = Modifier.requiredWidth(186.dp).align(Alignment.CenterHorizontally),
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
            colors = TextFieldDefaults.colors(
                unfocusedContainerColor = WhiteSavvy,
                focusedContainerColor = WhiteSavvy,
                cursorColor = PurpleSavvy2,
                unfocusedTextColor = PurpleSavvy2,
                focusedTextColor = PurpleSavvy2,
            ),
        )

//        Button
        Button(
            onClick = { navController.navigate(Screen.verifsucceed.route)},
            colors = buttonColors(containerColor = OrangeSavvy),
            shape = RoundedCornerShape(10.dp),
            modifier = Modifier
                .size(width = 186.dp, height = 46.dp)
                .offset(y = 420.dp)
        ) {
            Text(text = "Verifikasi", style = Typography.displayMedium, color = WhiteSavvy)
        }
    }
}

@Composable
fun VerifSucceed(navController: NavController) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Top,
        modifier = Modifier
            .fillMaxSize()
            .background(PurpleSavvy1)
    ) {
        Spacer(modifier = Modifier.height(100.dp))
//Image
        Image(
            painter = painterResource(id = R.drawable.verif_succeed),
            contentDescription = "verif",
            modifier = Modifier
                .size(258.dp)
                .offset(y = 50.dp)
        )
//        Title
        Text(text = "Verifikasi Berhasil ", style = Typography.titleLarge, color = WhiteSavvy)
        Text(
            text = "Selamat datang di Savvy, atur keuanganmu\njauh lebih mudah",
            style = Typography.labelSmall,
            textAlign = TextAlign.Center,
            color = PinkSavvy
        )
//        Button
        Button(
            onClick = { navController.navigate(Screen.beranda.route) },
            colors = buttonColors(containerColor = OrangeSavvy),
            shape = RoundedCornerShape(10.dp),
            modifier = Modifier
                .size(width = 186.dp, height = 46.dp)
                .offset(y = 220.dp)
        ) {
            Text(text = "Lanjut", style = Typography.displayMedium, color = WhiteSavvy)
        }
    }
}



