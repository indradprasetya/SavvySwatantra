package com.example.savvyswantatra

import android.widget.ProgressBar
import android.widget.Toast
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.DatePicker
import androidx.compose.material3.DisplayMode
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Snackbar
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
import androidx.compose.ui.platform.LocalContext
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
import com.example.savvyswantatra.component.AnggaranData
import com.example.savvyswantatra.component.BankList
import com.example.savvyswantatra.component.Simpanan
import com.example.savvyswantatra.component.SimpananData
import com.example.savvyswantatra.component.simpananCard
import com.example.savvyswantatra.component.typeOption
import com.example.savvyswantatra.navigation.Screen
import com.example.savvyswantatra.ui.theme.GraySavvy1
import com.example.savvyswantatra.ui.theme.GraySavvy2
import com.example.savvyswantatra.ui.theme.GraySavvy3
import com.example.savvyswantatra.ui.theme.OrangeSavvy
import com.example.savvyswantatra.ui.theme.PurpleSavvy1
import com.example.savvyswantatra.ui.theme.PurpleSavvy2
import com.example.savvyswantatra.ui.theme.Typography
import com.example.savvyswantatra.ui.theme.WhiteSavvy
import androidx.compose.foundation.lazy.LazyRow as LazyRow

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
        Spacer(modifier = Modifier.height(20.dp))
        LazyColumn(
            modifier = Modifier.fillMaxHeight(),
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            if (SimpananData.simpananList.isEmpty()) {
                item {
                    Column(
                        modifier = Modifier
                            .fillMaxSize()
                            .offset(y = 200.dp),
                        verticalArrangement = Arrangement.Center,
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        Image(
                            painterResource(id = R.drawable.notfound),
                            contentDescription = "",
                            modifier = Modifier.size(200.dp)
                        )
                        Text(
                            text = "Tidak ada tabungan",
                            style = Typography.bodyMedium,
                            color = Color.LightGray,
                            modifier = Modifier.offset(y = (-20).dp)
                        )
                    }
                }
            } else {
                items(SimpananData.simpananList) { simpanan ->
                    val total = simpanan.total.toString()
                    val nominal = simpanan.nominal.toString()
                    simpananCard(
                        simpanan.type,
                        simpanan.tujuan,
                        simpanan.tanggalmulai,
                        simpanan.tanggalakhir,
                        simpanan.terkumpul,
                        nominal,
                        total,
                        navController
                    )
                }
            }
        }
    }
}

@Composable
fun tambahSimpanan(navController: NavController) {
    var selectedIndex by remember { mutableStateOf(0) }
    var totalState by remember { mutableStateOf("") }
    var tujuanState by remember { mutableStateOf("") }
    var kalenderState1 by remember { mutableStateOf("") }
    var kalenderState2 by remember { mutableStateOf("") }
    var nominalState by remember { mutableStateOf("") }
    val selectedImage = remember { mutableStateOf(0) }
    val context = LocalContext.current
    Column(
        verticalArrangement = Arrangement.Top,
        modifier = Modifier.padding(top = 20.dp)

    ) {
//        Title
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
                typeOption.forEachIndexed { index, item ->

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

                            typeOption.size - 1 -> RoundedCornerShape(
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
                            "Nominal " + typeOption[selectedIndex],
                            style = Typography.bodyMedium
                        )
                    }
                )
            }

//            Mau Nabung darimana
            Spacer(modifier = Modifier.height(20.dp))
            Text(
                text = "Mau nabung di mana nih",
                style = Typography.bodyMedium,
                color = PurpleSavvy2
            )
            Spacer(modifier = Modifier.height(20.dp))
            BankList(selectedImage, 0)
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
                    colors = ButtonDefaults.buttonColors(containerColor = OrangeSavvy),
                    shape = RoundedCornerShape(10.dp),
                    modifier = Modifier
                        .size(width = 140.dp, height = 46.dp),
                    onClick = {
                        if (totalState.isBlank()) {
                            Toast.makeText(
                                context,
                                "Kolom total tidak boleh kosong",
                                Toast.LENGTH_LONG
                            ).show()
                        } else if (tujuanState.isBlank()) {
                            Toast.makeText(
                                context,
                                "Kolom tujuan tidak boleh kosong",
                                Toast.LENGTH_LONG
                            ).show()
                        } else if (kalenderState1.isBlank()) {
                            Toast.makeText(
                                context,
                                "Kolom tanggal mulai tidak boleh kosong",
                                Toast.LENGTH_LONG
                            ).show()
                        } else if (kalenderState2.isBlank()) {
                            Toast.makeText(
                                context,
                                "Kolom tanggal akhir tidak boleh kosong",
                                Toast.LENGTH_LONG
                            ).show()
                        } else if (nominalState.isBlank()) {
                            Toast.makeText(
                                context,
                                "Kolom nominal tidak boleh kosong",
                                Toast.LENGTH_LONG
                            ).show()
                        } else {
                            val total = totalState.toInt()
                            val nominal = nominalState.toInt()
                            val imageResId =
                                com.example.savvyswantatra.component.Image.bankList.getOrNull(
                                    selectedImage.value
                                )
                                    ?: R.drawable.ic_launcher_background
                            SimpananData.simpananList.add(
                                Simpanan(
                                    type = selectedIndex,
                                    total = total,
                                    tujuan = tujuanState,
                                    tanggalmulai = kalenderState1,
                                    tanggalakhir = kalenderState2,
                                    nominal = nominal,
                                    terkumpul = 0,
                                    imageResources = imageResId
                                )
                            )
                            navController.popBackStack()
                        }
                    }
                ) {
                    Text(text = "Tambah", style = Typography.displayMedium, color = WhiteSavvy)
                }
                Button(
                    colors = ButtonDefaults.buttonColors(containerColor = GraySavvy3),
                    shape = RoundedCornerShape(10.dp),
                    modifier = Modifier
                        .size(width = 140.dp, height = 46.dp),
                    onClick = {
                        selectedIndex = 0
                        totalState = ""
                        tujuanState = ""
                        kalenderState1 = ""
                        nominalState = ""
                        selectedImage.value = 0
                    },
                ) {
                    Text(text = "Pulihkan", style = Typography.displayMedium, color = OrangeSavvy)
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



