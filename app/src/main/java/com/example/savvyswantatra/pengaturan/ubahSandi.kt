package com.example.savvyswantatra.pengaturan

import androidx.compose.foundation.background
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
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.savvyswantatra.navigation.Screen
import com.example.savvyswantatra.ui.theme.OrangeSavvy
import com.example.savvyswantatra.ui.theme.PurpleSavvy1
import com.example.savvyswantatra.ui.theme.Typography
import com.example.savvyswantatra.ui.theme.WhiteSavvy
import com.example.savvyswantatra.ui.theme.poppinsFontFamily

val custom = TextStyle(
    fontFamily = poppinsFontFamily,
    fontSize = 10.sp,
    fontWeight = FontWeight.SemiBold,
    color = WhiteSavvy,
    textAlign = TextAlign.Start
)

@Composable
fun ubahSandi(navController: NavController) {
    val (currentPassword, setCurrentPasword) = remember { mutableStateOf("") }
    val (newPassword, setNewPassword) = remember { mutableStateOf("") }
    val (confirmPassword, setConfirmPassword) = remember { mutableStateOf("") }

    val passwordVisibility = remember { mutableStateOf(false) }
    val newPasswordVisibility = remember { mutableStateOf(false) }
    val confirmPasswordVisibility = remember { mutableStateOf(false) }

    Column(
        verticalArrangement = Arrangement.Top,
        modifier = Modifier
            .fillMaxSize()
            .background(PurpleSavvy1)
            .padding(50.dp)
    ) {
        Row{
            Icon(
                Icons.Filled.ArrowBack,
                contentDescription = "ke pengaturan",
                tint = WhiteSavvy,
                modifier = Modifier
                    .clickable(onClick =
                    { navController.navigate("pengaturan") })
            )

        }
        Spacer(modifier = Modifier.height(100.dp))
        Text(
            text = "Ubah Kata Sandi",
            style = Typography.titleLarge,
            color = WhiteSavvy,
            fontFamily = poppinsFontFamily,
            modifier = Modifier
                .align(alignment = Alignment.CenterHorizontally)
        )

        Spacer(modifier = Modifier.height(20.dp))

        Text(
            text = "Kata sandi saat ini",
            style = custom,
            modifier = Modifier.align(Alignment.Start)
        )
        TextField(
            value = currentPassword,
            onValueChange = setCurrentPasword,
            label = {
                Text(
                    "",
                    fontFamily = poppinsFontFamily,
                    fontStyle = FontStyle.Italic,
                    color = WhiteSavvy
                )
            },
            trailingIcon = {
                IconButton(onClick = { passwordVisibility.value = !passwordVisibility.value }) {
                    Icon(
                        imageVector = if (passwordVisibility.value) Icons.Filled.Person else Icons.Filled.Person,
                        contentDescription = if (passwordVisibility.value) "Hide password" else "Show password",
                        tint = Color.White
                    )
                }
            },
            visualTransformation = if (passwordVisibility.value) VisualTransformation.None else PasswordVisualTransformation(),
            modifier = Modifier
                .padding(8.dp)
                .height(30.dp),
            colors = TextFieldDefaults.colors(
                unfocusedContainerColor = Color.Transparent,
            ),
            shape = RoundedCornerShape(12.dp)
        )

        Spacer(modifier = Modifier.height(15.dp))

        Text(
            text = "Kata sandi baru",
            style = custom,
            modifier = Modifier.align(Alignment.Start)
        )
        TextField(
            value = newPassword,
            onValueChange = setNewPassword,
            label = {
                Text(
                    "",
                    fontFamily = poppinsFontFamily,
                    fontStyle = FontStyle.Italic,
                    color = WhiteSavvy
                )
            },
            trailingIcon = {
                IconButton(onClick = {
                    newPasswordVisibility.value = !newPasswordVisibility.value
                }) {
                    Icon(
                        imageVector = if (newPasswordVisibility.value) Icons.Filled.Person else Icons.Filled.Person,
                        contentDescription = if (newPasswordVisibility.value) "Hide password" else "Show password",
                        tint = Color.White
                    )
                }
            },
            visualTransformation = if (newPasswordVisibility.value) VisualTransformation.None else PasswordVisualTransformation(),
            modifier = Modifier
                .padding(8.dp)
                .height(30.dp),
            colors = TextFieldDefaults.colors(
                unfocusedContainerColor = Color.Transparent,
            ),
            shape = RoundedCornerShape(12.dp)
        )

        Spacer(modifier = Modifier.height(15.dp))

        Text(
            text = "Ulangi kata sandi baru",
            style = custom,
            modifier = Modifier.align(Alignment.Start)
        )
        TextField(
            value = confirmPassword,
            onValueChange = setConfirmPassword,
            label = {
                Text(
                    "",
                    fontFamily = poppinsFontFamily,
                    fontStyle = FontStyle.Italic,
                    color = WhiteSavvy
                )
            },
            trailingIcon = {
                IconButton(onClick = {
                    confirmPasswordVisibility.value = !confirmPasswordVisibility.value
                }) {
                    Icon(
                        imageVector = if (confirmPasswordVisibility.value) Icons.Filled.Person else Icons.Filled.Person,
                        contentDescription = if (confirmPasswordVisibility.value) "Hide password" else "Show password",
                        tint = Color.White
                    )
                }
            },
            visualTransformation = if (confirmPasswordVisibility.value) VisualTransformation.None else PasswordVisualTransformation(),
            modifier = Modifier
                .padding(8.dp)
                .height(30.dp),
            colors = TextFieldDefaults.colors(
                unfocusedContainerColor = Color.Transparent,
            ),
            shape = RoundedCornerShape(12.dp)
        )

        Spacer(modifier = Modifier.height(30.dp))

        Button(
            onClick = { navController.navigate(Screen.pengaturan.route) },
            colors = ButtonDefaults.buttonColors(containerColor = OrangeSavvy),
            shape = RoundedCornerShape(10.dp),
            modifier = Modifier
                .size(width = 290.dp, height = 46.dp)
                .offset(y = 240.dp)
        ) {
            Text(text = "Ubah Kata Sandi", style = Typography.displayMedium)
        }
    }
}

@Preview(showBackground = true)
@Composable
fun ubahSandiPreview() {
    ubahSandi(navController = rememberNavController())
}
