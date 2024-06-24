package com.example.savvyswantatra

import android.widget.Toast
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.BoxWithConstraints
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.requiredHeight
import androidx.compose.foundation.layout.requiredWidth
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableIntState
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableDoubleStateOf
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.unit.times
import androidx.navigation.NavController
import com.example.savvyswantatra.component.Anggaran
import com.example.savvyswantatra.component.AnggaranData
import com.example.savvyswantatra.component.BankList
import com.example.savvyswantatra.component.Image
import com.example.savvyswantatra.navigation.Screen
import com.example.savvyswantatra.ui.theme.OrangeSavvy
import com.example.savvyswantatra.ui.theme.PurpleSavvy1
import com.example.savvyswantatra.ui.theme.Typography
import com.example.savvyswantatra.ui.theme.WhiteSavvy
import com.example.savvyswantatra.ui.theme.poppinsFontFamily
import com.example.savvyswantatra.viewModel.AddAnggaranViewModel
import java.text.NumberFormat
import java.util.Locale
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.compose.runtime.collectAsState
import com.example.savvyswantatra.database.AppDatabase
import com.example.savvyswantatra.viewModel.AddAnggaranViewModelFactory

fun formatNumberWithCommas(input: String): String {
    val number = input.replace(",", "").toDoubleOrNull()
    return if (number != null) {
        val format = NumberFormat.getNumberInstance(Locale.US)
        format.format(number)
    } else {
        input
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AddAnggaranScreen(
    navController: NavController
) {
    val context = LocalContext.current
    val anggaranDao = AppDatabase.getInstance(context).anggaranDao()
    val viewModel: AddAnggaranViewModel = viewModel(
        factory = AddAnggaranViewModelFactory(anggaranDao)
    )

    val textNama by viewModel.textNama
    val textJumlah by viewModel.textJumlah
    val selectedImage = viewModel.selectedImage

    BoxWithConstraints {
        val screenWidth = constraints.maxWidth.toFloat()
        val screenHeight = constraints.maxHeight.toFloat()

        Surface(
            modifier = Modifier.fillMaxSize(),
            color = WhiteSavvy
        ) {
            Column(modifier = Modifier.background(color = WhiteSavvy)) {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(end = 20.dp),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Row(
                        modifier = Modifier.padding(16.dp),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        IconButton(onClick = { navController.popBackStack() }) {
                            Icon(
                                Icons.Filled.ArrowBack,
                                contentDescription = "Kembali",
                                tint = Color.Black
                            )
                        }
                        Text(
                            text = "TAMBAH ANGGARAN",
                            style = Typography.displayMedium,
                            color = PurpleSavvy1
                        )
                    }
                }
                Column {
                    Row(
                        verticalAlignment = Alignment.CenterVertically,
                        modifier = Modifier
                            .padding(horizontal = screenWidth * 0.04.dp)  // Ubah ini menjadi persentase dari lebar layar
                    ) {
                        Text(
                            text = "Nama Anggaran   : ",
                            style = Typography.displaySmall,
                            color = PurpleSavvy1,
                            fontSize = 14.sp
                        )
                        Spacer(modifier = Modifier.width(4.dp))
                        TextField(
                            value = textNama,
                            onValueChange = viewModel::onNamaChange,
                            label = {
                                Text(
                                    text = "",
                                )
                            },
                            modifier = Modifier
                                .fillMaxWidth()
                                .offset(y = (-8).dp),
                            colors = TextFieldDefaults.textFieldColors(containerColor = WhiteSavvy),
                            textStyle = TextStyle(color = PurpleSavvy1, fontFamily = poppinsFontFamily,),
                            keyboardOptions = KeyboardOptions.Default.copy(imeAction = ImeAction.Done)
                        )
                    }
                    Row(
                        verticalAlignment = Alignment.CenterVertically,
                        modifier = Modifier.padding(horizontal = screenWidth * 0.04.dp)  // Ubah ini menjadi persentase dari lebar layar
                    ) {
                        Text(
                            text = "Jumlah Saldo(Rp): ",
                            style = Typography.displayMedium,
                            fontSize = 14.sp,
                            color = PurpleSavvy1
                        )
                        Spacer(modifier = Modifier.width(4.dp))
                        TextField(
                            value = textJumlah,
                            onValueChange = viewModel::onJumlahChange,
                            label = {
                                Text(
                                    text = "",  // Ubah ini menjadi String kosong
                                )
                            },
                            modifier = Modifier
                                .fillMaxWidth()
                                .offset(y = (-8).dp),
                            colors = TextFieldDefaults.textFieldColors(containerColor = WhiteSavvy),
                            textStyle = TextStyle(
                                color = PurpleSavvy1,
                                fontFamily = poppinsFontFamily
                            ),
                            keyboardOptions = KeyboardOptions.Default.copy(imeAction = ImeAction.Done, keyboardType = KeyboardType.Number) // Membatasi input hanya untuk angka
                        )
                    }
                    Text(
                        text = "Pilih Icon dibawah",
                        color = PurpleSavvy1,
                        style = Typography.bodyMedium,
                        fontWeight = FontWeight.Normal,
                        modifier = Modifier
                            .padding(horizontal = screenWidth * 0.04.dp)
                            .padding(top = screenWidth * 0.03.dp)// Ubah ini menjadi persentase dari lebar layar
                    )
                    BankList(selectedImage, 30)
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(horizontal = screenWidth * 0.045.dp)  // Ubah ini menjadi persentase dari lebar layar
                            .padding(top = screenWidth * 0.03.dp),  // Ubah ini menjadi persentase dari lebar layar
                        horizontalArrangement = Arrangement.spacedBy(20.dp)
                    ) {
                        Button(
                            onClick = {
                                if (viewModel.tambahAnggaran()) {
                                    navController.popBackStack()
                                } else {
                                    Toast.makeText(
                                        context,
                                        "Nama anggaran tidak boleh kosong atau jumlah saldo harus berupa angka",
                                        Toast.LENGTH_SHORT
                                    ).show()
                                }
                            },
                            shape = RoundedCornerShape(5.dp),
                            colors = ButtonDefaults.buttonColors(containerColor = Color(0xffeb7f63)),
                            modifier = Modifier
                                .size(width = 140.dp, height = 46.dp)
                        ) {
                            Text(
                                text = "Tambah",
                                style = Typography.bodyMedium,
                                color = WhiteSavvy
                            )
                        }

                        Button(
                            onClick = viewModel::pulihkan,
                            shape = RoundedCornerShape(5.dp),
                            colors = ButtonDefaults.buttonColors(containerColor = Color(0xffEBE7E7)),
                            modifier = Modifier
                                .size(width = 140.dp, height = 46.dp)
                        ) {
                            Text(
                                text = "Pulihkan",
                                style = Typography.bodyMedium,
                                color = OrangeSavvy
                            )
                        }
                    }
                }
            }
        }
    }
}
