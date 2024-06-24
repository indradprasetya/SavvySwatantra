package com.example.savvyswantatra.Kalender

import android.app.DatePickerDialog
import androidx.activity.ComponentActivity
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.DropdownMenuItem
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material.icons.filled.KeyboardArrowUp
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
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
import androidx.compose.foundation.border
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.filled.DateRange
import androidx.compose.ui.draw.scale
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.savvyswantatra.R
import com.example.savvyswantatra.component.AkunData
import com.example.savvyswantatra.component.KategoriAnggaranData
import com.example.savvyswantatra.ui.theme.OrangeSavvy
import com.example.savvyswantatra.ui.theme.PurpleSavvy1
import com.example.savvyswantatra.ui.theme.PurpleSavvy2
import com.example.savvyswantatra.ui.theme.Typography
import com.example.savvyswantatra.ui.theme.WhiteSavvy
import androidx.compose.ui.platform.LocalContext
import java.util.Calendar


@Composable
fun TopBar(navController: NavController) {
    Row(
        modifier = Modifier.padding(16.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Icon(
            Icons.Filled.ArrowBack,
            contentDescription = "ke kalender",
            tint = PurpleSavvy1,
            modifier = Modifier.clickable { navController.navigate("kalender") }
        )
        Spacer(modifier = Modifier.width(15.dp))
        Text(
            text = "Transaksi",
            style = Typography.displayMedium,
            color = PurpleSavvy1
        )
    }
}

@Composable
fun CategoryButtons(
    navController: NavController,
    currentScreen: String
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 16.dp, start = 16.dp, end = 16.dp)
            .background(WhiteSavvy),
        horizontalArrangement = Arrangement.Center
    ) {
        Button(
            onClick = { navController.navigate("pemasukanKalender") },
            colors = ButtonDefaults.buttonColors(
                containerColor = if (currentScreen == "pemasukan") PurpleSavvy1 else Color.White
            ),
            shape = RoundedCornerShape(8.dp),
            border = BorderStroke(2.dp, color = PurpleSavvy1),
            modifier = Modifier.width(130.dp)
        ) {
            Text(
                text = "Pemasukan",
                style = Typography.bodyMedium,
                color = if (currentScreen == "pemasukan") WhiteSavvy else PurpleSavvy1
            )
        }
        Spacer(modifier = Modifier.width(8.dp))
        Button(
            onClick = { navController.navigate("pengeluaranKalender") },
            colors = ButtonDefaults.buttonColors(
                containerColor = if (currentScreen == "pengeluaran") PurpleSavvy1 else Color.White
            ),
            shape = RoundedCornerShape(8.dp),
            border = BorderStroke(2.dp, color = PurpleSavvy1),
            modifier = Modifier.width(130.dp)
        ) {
            Text(
                text = "Pengeluaran",
                style = Typography.bodyMedium,
                color = if (currentScreen == "pengeluaran") WhiteSavvy else PurpleSavvy1
            )
        }
    }
}

@Composable
fun FormFieldRow(
    label: String,
    paddingStart: Dp = 0.dp,
    dropdownItems: List<String>? = null, // Menambahkan opsi dropdown
    isDateField: Boolean = false, // Menandakan apakah ini adalah date pi
    isNumericField: Boolean = false,
    onDateSelected: (String) -> Unit = {},
    onValueChange: (String) -> Unit = {},
    onResetClick: () -> Unit = {} // Menambahkan callback untuk reset nilai
// Menambahkan callback untuk perubahan nilai

    //
    ){

    var textState by remember { mutableStateOf("") }
    val context = LocalContext.current


    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier.padding(start = paddingStart, top = 7.dp, bottom = 7.dp)
            .padding(horizontal = 15.dp)
    ) {
        Text(
            text = "$label :",
            style = Typography.bodyMedium,
            color = PurpleSavvy1,
            modifier = Modifier.weight(0.4f),
        )

        if (dropdownItems != null) {
            // Dropdown untuk akun atau kategori
            var expanded by remember { mutableStateOf(false) }
            var selectedItemIndex by remember { mutableStateOf(0) }

            Box(
                modifier = Modifier
                    .weight(1f)
                    .background(WhiteSavvy)
                    .height(48.dp)
                    .clickable { expanded = true }
                    .padding(horizontal = 16.dp)
            ) {
                Text(
                    text = dropdownItems[selectedItemIndex],
                    style = Typography.bodySmall,
                    color = PurpleSavvy2,
                    modifier = Modifier.align(Alignment.CenterStart)
                )
                Icon(
                    imageVector = Icons.Filled.KeyboardArrowDown,
                    contentDescription = null,
                    tint = PurpleSavvy2,
                    modifier = Modifier
                        .align(Alignment.CenterEnd)
                )
                DropdownMenu(
                    expanded = expanded,
                    onDismissRequest = { expanded = false },
                    modifier = Modifier
                        .width(Dp(225F))
                        .background(PurpleSavvy1)

                ) {
                    dropdownItems.forEachIndexed { index, item ->
                        DropdownMenuItem(onClick = {
                            selectedItemIndex = index
                            expanded = false
                        }) {
                            Text(
                                text = item,
                                style = Typography.bodyMedium,
                                color = WhiteSavvy

                            )
                        }
                    }
                }
            }
        } else if (isDateField) {
            // Date picker
            var selectedDate by remember { mutableStateOf("") }

            TextField(
                value = selectedDate,
                onValueChange ={ newText ->
                    selectedDate = newText
                },
                readOnly = true,
                modifier = Modifier
                    .weight(1f),
                textStyle = Typography.bodySmall,
                colors = TextFieldDefaults.colors(
                    unfocusedContainerColor = Color.Transparent,
                    focusedContainerColor = Color.Transparent,
                    cursorColor = PurpleSavvy2,
                    unfocusedTextColor = PurpleSavvy2,
                    focusedTextColor = PurpleSavvy2,
                    unfocusedPlaceholderColor = PurpleSavvy1),
                trailingIcon = {
                    IconButton(onClick = {
                        val calendar = Calendar.getInstance()
                        val year = calendar.get(Calendar.YEAR)
                        val month = calendar.get(Calendar.MONTH)
                        val day = calendar.get(Calendar.DAY_OF_MONTH)

                        DatePickerDialog(
                            context,
                            { _, year, month, dayOfMonth ->
                                val formattedDate = "$dayOfMonth/${month + 1}/$year"
                                selectedDate = formattedDate
                                onDateSelected(formattedDate)
                            },
                            year,
                            month,
                            day
                        ).show()
                    }) {
                        Icon(Icons.Filled.DateRange, contentDescription = "Select Date", tint = PurpleSavvy1)
                    }
                }
            )
        } else {
            // TextField biasa
            TextField(
                value = textState,
                onValueChange = { newText ->
                    textState = newText
                },
                modifier = Modifier
                    .background(WhiteSavvy)
                    .height(48.dp)
                    .weight(1f),
                textStyle = Typography.bodySmall,
                colors = TextFieldDefaults.colors(
                    unfocusedContainerColor = Color.Transparent,
                    focusedContainerColor = Color.Transparent,
                    cursorColor = PurpleSavvy2,
                    unfocusedTextColor = PurpleSavvy2,
                    focusedTextColor = PurpleSavvy2,
                    unfocusedPlaceholderColor = PurpleSavvy1
                ),
                keyboardOptions = if (isNumericField) {
                    KeyboardOptions.Default.copy(
                        keyboardType = KeyboardType.Number // Hanya menerima input angka
                    )
                } else {
                    KeyboardOptions.Default
                }
            )
        }
    }
}
@Composable
fun FormExpense(
    navController: NavController,
) {
    var selectedAccount by remember { mutableStateOf("") }
    var selectedCategory by remember { mutableStateOf("") }
    var totalAmount by remember { mutableStateOf("") }
    var note by remember { mutableStateOf("") }
    var dateSelected by remember { mutableStateOf("") }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(WhiteSavvy)
    ) {
        TopBar(navController)
        CategoryButtons(navController, currentScreen = "pengeluaran")

        Column(
            modifier = Modifier
                .padding(16.dp)
                .fillMaxWidth()
        ) {
            FormFieldRow(
                label = "Akun anda",
                dropdownItems = AkunData.akunList.map { it.nama },
                onValueChange = { newText ->
                    selectedAccount = newText
                },


            )
            FormFieldRow(
                label = "Kategori",
                dropdownItems = KategoriAnggaranData.kategoriList.map { it.nama },
                onValueChange = { newText ->
                    selectedCategory = newText
                }            )
            FormFieldRow(
                label = "Tanggal",
                isDateField = true,
                onValueChange = { newText ->
                    dateSelected= newText
                }
            )
            FormFieldRow(
                label = "Total",
                isNumericField = true,
                onValueChange = { newText ->
                    totalAmount= newText
                }
            )
            FormFieldRow(
                label = "Catatan",
                onValueChange = { newText ->
                    note= newText
                }
            )

            Row(
                modifier = Modifier
                    .padding(top = 28.dp)
                    .fillMaxWidth(),
                horizontalArrangement = Arrangement.Center
            ) {
                Button(
                    onClick = { /*TODO: Implementasi untuk menyimpan data*/ },
                    colors = ButtonDefaults.buttonColors(containerColor = OrangeSavvy),
                    shape = RoundedCornerShape(8.dp),
                    modifier = Modifier.width(150.dp)
                ) {
                    Text(
                        text = "Simpan",
                        style = Typography.displayMedium,
                        color = WhiteSavvy
                    )
                }
                Spacer(modifier = Modifier.width(16.dp))
                Button(
                    onClick = {
                        selectedAccount = ""
                        selectedCategory = ""
                        dateSelected = ""
                        totalAmount = ""
                        note = ""
                    },
                    colors = ButtonDefaults.buttonColors(containerColor = WhiteSavvy),
                    shape = RoundedCornerShape(8.dp),
                    border = BorderStroke(2.dp, color = OrangeSavvy),
                    modifier = Modifier.width(150.dp)
                ) {
                    Text(
                        text = "Pulihkan",
                        style = Typography.displayMedium,
                        color = OrangeSavvy
                    )
                }
            }
        }
    }
}

@Composable
fun FormIncome(navController: NavController) {
    var selectedAccount by remember { mutableStateOf("") }
    var dateSelected by remember { mutableStateOf("") }
    var totalAmount by remember { mutableStateOf("") }
    var note by remember { mutableStateOf("") }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(WhiteSavvy)
    ) {
        TopBar(navController)
        CategoryButtons(navController, currentScreen = "pemasukan")

        Column(
            modifier = Modifier
                .padding(16.dp)
                .fillMaxWidth()
        ) {
            FormFieldRow(
                label = "Akun anda",
                dropdownItems = AkunData.akunList.map { it.nama },
                onValueChange = { selectedAccount = it }
            )
            FormFieldRow(
                label = "Tanggal",
                isDateField = true,
                onValueChange = { dateSelected = it }
            )
            FormFieldRow(
                label = "Total",
                isNumericField = true,
                onValueChange = { totalAmount= it }
            )
            FormFieldRow(
                label = "Catatan",
                onValueChange = { note = it }
            )

            Row(
                modifier = Modifier
                    .padding(top = 24.dp)
                    .fillMaxWidth(),
                horizontalArrangement = Arrangement.Center
            ) {
                Button(
                    onClick = { /*TODO: Implementasi untuk menyimpan data*/ },
                    colors = ButtonDefaults.buttonColors(containerColor = OrangeSavvy),
                    shape = RoundedCornerShape(8.dp),
                    modifier = Modifier.width(150.dp)
                ) {
                    Text(
                        text = "Simpan",
                        style = Typography.displayMedium,
                        color = WhiteSavvy
                    )
                }
                Spacer(modifier = Modifier.width(16.dp))
                Button(
                    onClick = {

                    },
                    colors = ButtonDefaults.buttonColors(containerColor = WhiteSavvy),
                    shape = RoundedCornerShape(8.dp),
                    border = BorderStroke(2.dp, color = OrangeSavvy),
                    modifier = Modifier.width(150.dp)
                ) {
                    Text(
                        text = "Pulihkan",
                        style = Typography.displayMedium,
                        color = OrangeSavvy
                    )
                }
            }
        }
    }
}


@Preview(showBackground = true)
@Composable
fun FormExpensePreview() {
    FormExpense(navController = rememberNavController())
}

@Preview(showBackground = true)
@Composable
fun FormIncomePreview() {
    FormIncome(navController = rememberNavController())
}