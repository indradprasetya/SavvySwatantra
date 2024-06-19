package com.example.savvyswantatra.register

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults.buttonColors
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
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.core.text.isDigitsOnly
import androidx.navigation.NavController
import com.example.savvyswantatra.navigation.Screen
import com.example.savvyswantatra.ui.theme.OrangeSavvy
import com.example.savvyswantatra.ui.theme.PurpleSavvy1
import com.example.savvyswantatra.ui.theme.PurpleSavvy2
import com.example.savvyswantatra.ui.theme.Typography
import com.example.savvyswantatra.ui.theme.WhiteSavvy
import com.example.savvyswantatra.ui.theme.poppinsFontFamily

@Composable
fun Register(navController: NavController) {
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
        var nameRegisterState by remember { mutableStateOf("") }
        OutlinedTextField(
            singleLine = true,
            value = nameRegisterState,
            onValueChange = { nameRegisterState = it },
            textStyle = Typography.bodyMedium,
            colors = TextFieldDefaults.colors(
                unfocusedContainerColor = Color.Transparent,
                focusedContainerColor = Color.Transparent,
                cursorColor = PurpleSavvy2,
                unfocusedTextColor = PurpleSavvy2,
                focusedTextColor = PurpleSavvy2,
            ),
            label = { Text("Masukkan Nama", style = Typography.bodyMedium) }
        )

        var emailRegisterState by remember { mutableStateOf("") }
        OutlinedTextField(
            singleLine = true,
            value = emailRegisterState,
            onValueChange = { emailRegisterState = it },
            textStyle = Typography.bodyMedium,
            colors = TextFieldDefaults.colors(
                unfocusedContainerColor = Color.Transparent,
                focusedContainerColor = Color.Transparent,
                cursorColor = PurpleSavvy2,
                unfocusedTextColor = PurpleSavvy2,
                focusedTextColor = PurpleSavvy2,
            ),
            label = { Text("Masukkan Email", style = Typography.bodyMedium) }
        )

        var passRegisterState by remember { mutableStateOf("") }
        OutlinedTextField(
            singleLine = true,
            value = passRegisterState,
            onValueChange = { passRegisterState = it },
            textStyle = Typography.bodyMedium,
            colors = TextFieldDefaults.colors(
                unfocusedContainerColor = Color.Transparent,
                focusedContainerColor = Color.Transparent,
                cursorColor = PurpleSavvy2,
                unfocusedTextColor = PurpleSavvy2,
                focusedTextColor = PurpleSavvy2,
            ),
            label = { Text("Masukkan Password", style = Typography.bodyMedium) }
        )

        var repeatpassRegisterState by remember { mutableStateOf("") }
        OutlinedTextField(
            singleLine = true,
            value = repeatpassRegisterState,
            onValueChange = { repeatpassRegisterState = it },
            textStyle = Typography.bodyMedium,
            colors = TextFieldDefaults.colors(
                unfocusedContainerColor = Color.Transparent,
                focusedContainerColor = Color.Transparent,
                cursorColor = PurpleSavvy2,
                unfocusedTextColor = PurpleSavvy2,
                focusedTextColor = PurpleSavvy2,
            ),
            label = { Text("Ulangi Password", style = Typography.bodyMedium) }
        )
//        Button
        Button(
            onClick = { navController.navigate(Screen.verif.route) },
            colors = buttonColors(containerColor = OrangeSavvy),
            shape = RoundedCornerShape(10.dp),
            modifier = Modifier
                .size(width = 186.dp, height = 46.dp)
                .offset(y = 162.dp)
        ) {
            Text(text = "Lanjut", style = Typography.displayMedium, color = WhiteSavvy)
        }
        Row(modifier = Modifier.offset(y = 167.dp)) {
            Text(text = "Sudah Punya Akun?", style = Typography.bodyMedium, color = PurpleSavvy1)
            Text(
                text = " Masuk",
                style = Typography.bodyMedium,
                color = OrangeSavvy,
                modifier = Modifier.clickable { navController.navigate(Screen.login.route) })
        }


    }


}

