package com.example.savvyswantatra

import androidx.compose.runtime.remember
import androidx.compose.runtime.mutableStateOf
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults.buttonColors
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.savvyswantatra.ui.theme.OrangeSavvy
import com.example.savvyswantatra.ui.theme.PurpleSavvy1
import com.example.savvyswantatra.ui.theme.PurpleSavvy2
import com.example.savvyswantatra.ui.theme.Typography
import com.example.savvyswantatra.ui.theme.poppinsFontFamily



@Composable
fun masuk(){

    val emailState = remember { mutableStateOf("") }
    val passwordState = remember { mutableStateOf("") }
    
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Top,
        modifier = Modifier.fillMaxSize()
    ) {
//        Title
        Spacer(modifier = Modifier.height(100.dp))
        Text(text = "Masuk Aplikasi", style = Typography.titleLarge, color = PurpleSavvy1)
        Text(
            text = "Silahkan masukkan akun Anda \n yang telah terdaftar",
            textAlign = TextAlign.Center,
            color = PurpleSavvy2
        )
        Spacer(modifier = Modifier.height(70.dp))
//        Form
        OutlinedTextField(
            value = emailState.value,
            onValueChange = { emailState.value = it },
            modifier = Modifier,
            label = { Text("Masukkan email", fontFamily = poppinsFontFamily, fontStyle = FontStyle.Italic, style = Typography.labelMedium,) })
        OutlinedTextField(
            value = passwordState.value,
            onValueChange = { passwordState.value = it },
            label = { Text("Masukkan kata sandi", fontFamily = poppinsFontFamily, fontStyle = FontStyle.Italic, style = Typography.labelMedium,) })


//        teks
        Spacer(modifier = Modifier.height(30.dp))
        Text(
            text = buildAnnotatedString {
                append("Lupa kata sandi? ")
                withStyle(style = SpanStyle(color = OrangeSavvy)) {
                    append("Atur ulang")
                }
            }
        )
        Spacer(modifier = Modifier.height(20.dp))

//        Button
        Button(
            onClick = { /*TODO*/ },
            colors = buttonColors(containerColor = OrangeSavvy),
            shape = RoundedCornerShape(10.dp),
            modifier = Modifier
                .size(width = 290.dp, height = 46.dp)

        )
        {
            Text(text = "Masuk", style = Typography.displayMedium)
        }

        Spacer(modifier = Modifier.height(10.dp))
        Text(
            text = "Atau",
            textAlign = TextAlign.Center,
            color = PurpleSavvy2,
            fontWeight = FontWeight.SemiBold
        )

        Spacer(modifier = Modifier.height(10.dp))
        Button(
            onClick = { /*TODO*/ },
            colors = buttonColors(containerColor = OrangeSavvy),
            shape = RoundedCornerShape(10.dp),
            modifier = Modifier
                .size(width = 290.dp, height = 46.dp)
        ){
            Row {
                Icon(
                painter = painterResource(id = R.drawable.google),
                contentDescription = "Google Icon",
                modifier = Modifier
                    .size(24.dp)
                    .padding(start = 1.dp),
                tint = Color.Unspecified
            )
            Text(
                text = "Masuk dengan Google",
                style = Typography.displayMedium,
                modifier = Modifier.padding(start = 8.dp)
            )}

        }

        Spacer(modifier = Modifier.height(10.dp))
        Text(
            text = buildAnnotatedString {
                append("Belum punya akun? ")
                withStyle(style = SpanStyle(color = OrangeSavvy)) {
                    append("Daftar")
                }
            }
        )

    }


}
@Preview(showBackground = true)
@Composable
private fun masukPrev() {
    masuk()
}