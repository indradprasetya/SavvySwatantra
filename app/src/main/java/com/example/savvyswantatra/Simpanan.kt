package com.example.savvyswantatra

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.DatePicker
import androidx.compose.material3.DisplayMode
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.material3.rememberDatePickerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.OffsetMapping
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.text.input.TransformedText
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp
import androidx.compose.ui.zIndex
import androidx.core.text.isDigitsOnly
import androidx.navigation.NavController
import com.example.savvyswantatra.navigation.Screen
import com.example.savvyswantatra.ui.theme.GraySavvy1
import com.example.savvyswantatra.ui.theme.GraySavvy2
import com.example.savvyswantatra.ui.theme.GraySavvy3
import com.example.savvyswantatra.ui.theme.OrangeSavvy
import com.example.savvyswantatra.ui.theme.PurpleSavvy1
import com.example.savvyswantatra.ui.theme.PurpleSavvy2
import com.example.savvyswantatra.ui.theme.Typography
import com.example.savvyswantatra.ui.theme.WhiteSavvy

@Composable
fun SimpananScreen(navController: NavController) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Top,
        modifier = Modifier.fillMaxSize()
    ) {
//        Title
        Spacer(modifier = Modifier.height(20.dp))
        Text(text = "TABUNGANKU", style = Typography.bodyLarge, color = PurpleSavvy2)
//        Greeting
        Row(
            horizontalArrangement = Arrangement.spacedBy(30.dp),
            modifier = Modifier.padding(top = 20.dp)
        ) {
            Column {
                Text(
                    text = "Halo Annie",
                    style = Typography.displayMedium,
                    color = PurpleSavvy2,
                    modifier = Modifier
                )
                Text(
                    text = "Ayo Selesaikan Target Tabunganmu!",
                    style = Typography.bodyMedium,
                    color = PurpleSavvy2,
                    modifier = Modifier
                )
            }
            Image(painter = painterResource(id = R.drawable.plus),
                contentDescription = "linkedin",
                modifier = Modifier
                    .size(30.dp)
                    .clickable(onClick = {
                        navController.navigate(Screen.tambahsimpanan.route)
                    }
                    ))
        }
    }
}

@Composable
fun tambahSimpanan(navController: NavController) {
    Column(
        verticalArrangement = Arrangement.Top,
        modifier = Modifier.padding(top = 20.dp)

    ) {
//        Title
        var selectedIndex by remember { mutableStateOf(0) }
        val itemsList = listOf("Harian", "Mingguan", "Bulanan")
        Text(
            text = "TAMBAH TABUNGAN",
            style = Typography.bodyLarge,
            color = PurpleSavvy2,
            modifier = Modifier.align(Alignment.CenterHorizontally)
        )
        Column(
            modifier = Modifier.padding(start = 40.dp)
        ) {
            //        Radio Option
            Spacer(modifier = Modifier.height(20.dp))
            Text(
                text = "Pilih salah satu metode",
                style = Typography.bodyMedium,
                color = PurpleSavvy2,
            )
            Row(
            ) {

                val cornerRadius = 16.dp
                itemsList.forEachIndexed { index, item ->

                    Button(
                        onClick = { selectedIndex = index },
                        modifier = when (index) {
                            0 ->
                                Modifier
                                    .offset(0.dp, 0.dp)
                                    .zIndex(if (selectedIndex == index) 1f else 0f)

                            else ->
                                Modifier
                                    .offset((-1 * index).dp, 0.dp)
                                    .zIndex(if (selectedIndex == index) 1f else 0f)
                        },
                        shape = when (index) {
                            0 -> RoundedCornerShape(
                                topStart = cornerRadius,
                                topEnd = 0.dp,
                                bottomStart = cornerRadius,
                                bottomEnd = 0.dp
                            )

                            itemsList.size - 1 -> RoundedCornerShape(
                                topStart = 0.dp,
                                topEnd = cornerRadius,
                                bottomStart = 0.dp,
                                bottomEnd = cornerRadius
                            )

                            else -> RoundedCornerShape(
                                topStart = 0.dp,
                                topEnd = 0.dp,
                                bottomStart = 0.dp,
                                bottomEnd = 0.dp
                            )
                        },
                        border = BorderStroke(
                            1.dp, if (selectedIndex == index) {
                                PurpleSavvy2
                            } else {
                                PurpleSavvy1.copy(alpha = 0.75f)
                            }
                        ),
                        colors = if (selectedIndex == index) {
                            ButtonDefaults.outlinedButtonColors(
                                containerColor = PurpleSavvy2.copy(alpha = 0.1f),
                                contentColor = PurpleSavvy2
                            )
                        } else {
                            ButtonDefaults.outlinedButtonColors(
                                containerColor = Color.Transparent,
                                contentColor = PurpleSavvy1
                            )
                        }
                    ) {
                        Text(item)
                    }

                }
            }
//      Form
//      Total
            var totalState by remember { mutableStateOf("") }
            Row(
                verticalAlignment = Alignment.Bottom,
                horizontalArrangement = Arrangement.spacedBy(47.dp),
            ) {
                Text(text = "Total(Rp)", style = Typography.bodyMedium, color = PurpleSavvy2)
                TextField(
                    singleLine = true,
                    value = totalState,
                    onValueChange = { if (it.isDigitsOnly()) totalState = it },
                    textStyle = Typography.bodyMedium,
                    modifier = Modifier
                        .size(width = 200.dp, height = 46.dp),
                    keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
                    colors = androidx.compose.material3.TextFieldDefaults.colors(
                        unfocusedContainerColor = Color.Transparent,
                        focusedContainerColor = Color.Transparent,
                        cursorColor = PurpleSavvy2,
                        unfocusedTextColor = PurpleSavvy2,
                        focusedTextColor = PurpleSavvy2,
                    ),
                )
            }
//        Tujuan
            var tujuanState by remember { mutableStateOf("") }
            Row(
                verticalAlignment = Alignment.Bottom,
                horizontalArrangement = Arrangement.spacedBy(67.dp),
            ) {
                Text(text = "Tujuan", style = Typography.bodyMedium, color = PurpleSavvy2)
                TextField(
                    singleLine = true,
                    value = tujuanState,
                    onValueChange = { tujuanState = it },
                    textStyle = Typography.bodyMedium,
                    modifier = Modifier
                        .size(width = 200.dp, height = 46.dp),
                    colors = androidx.compose.material3.TextFieldDefaults.colors(
                        unfocusedContainerColor = Color.Transparent,
                        focusedContainerColor = Color.Transparent,
                        cursorColor = PurpleSavvy2,
                        unfocusedTextColor = PurpleSavvy2,
                        focusedTextColor = PurpleSavvy2,
                    ),

                    )
            }

//        Tanggal Mulai
            var kalenderState1 by remember { mutableStateOf("") }
            val maxChar = 8
            Row(
                verticalAlignment = Alignment.Bottom,
                horizontalArrangement = Arrangement.spacedBy(22.dp),
            ) {
                Text(text = "Tanggal Akhir", style = Typography.bodyMedium, color = PurpleSavvy2)
                TextField(
                    singleLine = true,
                    value = kalenderState1,
                    textStyle = Typography.bodyMedium,
                    modifier = Modifier
                        .size(width = 200.dp, height = 46.dp),
                    keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
                    colors = androidx.compose.material3.TextFieldDefaults.colors(
                        unfocusedContainerColor = Color.Transparent,
                        focusedContainerColor = Color.Transparent,
                        cursorColor = PurpleSavvy2,
                        unfocusedTextColor = PurpleSavvy2,
                        focusedTextColor = PurpleSavvy2,
                        unfocusedPlaceholderColor = Color(0xFF686D76),
                    ),
                    onValueChange = {
                        if (it.isDigitsOnly()) {
                            if (it.length <= maxChar) kalenderState1 = it
                        }

                    },
                    visualTransformation = DateTransformation(),
                    placeholder = { Text("DD/MM/YYYY", style = Typography.bodyMedium) }
                )
            }

//        Tanggal Akhir
            var kalenderState2 by remember { mutableStateOf("") }
            Row(
                verticalAlignment = Alignment.Bottom,
                horizontalArrangement = Arrangement.spacedBy(24.dp),
            ) {
                Text(text = "Tanggal Akhir", style = Typography.bodyMedium, color = PurpleSavvy2)
                TextField(
                    singleLine = true,
                    value = kalenderState2,
                    textStyle = Typography.bodyMedium,
                    modifier = Modifier
                        .size(width = 200.dp, height = 46.dp),
                    keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
                    colors = androidx.compose.material3.TextFieldDefaults.colors(
                        unfocusedContainerColor = Color.Transparent,
                        focusedContainerColor = Color.Transparent,
                        cursorColor = PurpleSavvy2,
                        unfocusedTextColor = PurpleSavvy2,
                        focusedTextColor = PurpleSavvy2,
                        unfocusedPlaceholderColor = Color(0xFF686D76),
                    ),
                    onValueChange = {
                        if (it.isDigitsOnly()) {
                            if (it.length <= maxChar) kalenderState2 = it
                        }
                    },
                    visualTransformation = DateTransformation(),
                    placeholder = { Text("DD/MM/YYYY", style = Typography.bodyMedium) }
                )
            }
//      Nominal per hari/minggu/bulan
            var nominalState by remember { mutableStateOf("") }
            Row(
                verticalAlignment = Alignment.Bottom,
                horizontalArrangement = Arrangement.spacedBy(62.dp),
            ) {
                Text(text = "Nominal", style = Typography.bodyMedium, color = PurpleSavvy2)
                TextField(
                    singleLine = true,
                    value = nominalState,
                    onValueChange = { if (it.isDigitsOnly()) nominalState = it },
                    textStyle = Typography.bodyMedium,
                    modifier = Modifier
                        .size(width = 200.dp, height = 46.dp),
                    keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
                    colors = androidx.compose.material3.TextFieldDefaults.colors(
                        unfocusedContainerColor = Color.Transparent,
                        focusedContainerColor = Color.Transparent,
                        cursorColor = PurpleSavvy2,
                        unfocusedTextColor = PurpleSavvy2,
                        focusedTextColor = PurpleSavvy2,
                        unfocusedPlaceholderColor = Color(0xFF686D76),
                    ),
                    placeholder = {
                        Text(
                            "Nominal " + itemsList[selectedIndex],
                            style = Typography.bodyMedium
                        )
                    }
                )
            }
        }


//        Button
        Spacer(modifier = Modifier.height(40.dp))
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center,
            modifier = Modifier.fillMaxWidth()
        ) {
            Row(
                horizontalArrangement = Arrangement.spacedBy(15.dp),
            ) {
                Button(
                    onClick = { navController.navigate(Screen.beranda.route) },
                    colors = ButtonDefaults.buttonColors(containerColor = OrangeSavvy),
                    shape = RoundedCornerShape(10.dp),
                    modifier = Modifier
                        .size(width = 140.dp, height = 46.dp)
                ) {
                    Text(text = "Tambah", style = Typography.displayMedium, color = WhiteSavvy)
                }
                Button(
                    onClick = { navController.navigate(Screen.beranda.route) },
                    colors = ButtonDefaults.buttonColors(containerColor = GraySavvy3),
                    shape = RoundedCornerShape(10.dp),
                    modifier = Modifier
                        .size(width = 140.dp, height = 46.dp)
                ) {
                    Text(text = "Hapus", style = Typography.displayMedium, color = OrangeSavvy)
                }

            }

        }
    }

}


//Kalender
class DateTransformation() : VisualTransformation {
    override fun filter(text: AnnotatedString): TransformedText {
        return dateFilter(text)
    }
}

fun dateFilter(text: AnnotatedString): TransformedText {

    val trimmed = if (text.text.length >= 8) text.text.substring(0..7) else text.text
    var out = ""
    for (i in trimmed.indices) {
        out += trimmed[i]
        if (i % 2 == 1 && i < 4) out += "/"
    }

    val numberOffsetTranslator = object : OffsetMapping {
        override fun originalToTransformed(offset: Int): Int {
            if (offset <= 1) return offset
            if (offset <= 3) return offset + 1
            if (offset <= 8) return offset + 2
            return 10
        }

        override fun transformedToOriginal(offset: Int): Int {
            if (offset <= 2) return offset
            if (offset <= 5) return offset - 1
            if (offset <= 10) return offset - 2
            return 8
        }
    }

    return TransformedText(AnnotatedString(out), numberOffsetTranslator)
}



