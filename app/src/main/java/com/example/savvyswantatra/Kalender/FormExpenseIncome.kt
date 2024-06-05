package com.example.savvyswantatra.Kalender

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.savvyswantatra.R
import com.example.savvyswantatra.ui.theme.OrangeSavvy
import com.example.savvyswantatra.ui.theme.PurpleSavvy1
import com.example.savvyswantatra.ui.theme.Typography
import com.example.savvyswantatra.ui.theme.WhiteSavvy


@Composable
fun FormExpense() {
    Row (modifier = Modifier
        .fillMaxSize()
        .padding(top = 100.dp)
        .padding(start = 55.dp)
        .background(WhiteSavvy)

    ){
        Button(
            onClick = { /*TODO*/ },
            colors = ButtonDefaults.buttonColors(containerColor = Color.White),
            shape = RoundedCornerShape(8.dp),
            border = BorderStroke(2.dp, color = PurpleSavvy1),
            modifier = Modifier
                .size(width = 130.dp, height = 35.dp)
        ){
            Text(
                text = "Pemasukan",
                style = Typography.bodyMedium,
                color = PurpleSavvy1
            )
        }
        Spacer(modifier = Modifier.width(5.dp))
        Button(
            onClick = { /*TODO*/ },
            colors = ButtonDefaults.buttonColors(containerColor = PurpleSavvy1),
            shape = RoundedCornerShape(8.dp),
            modifier = Modifier
                .size(width = 130.dp, height = 35.dp)
        ){
            Text(
                text = "Pengeluaran",
                style = Typography.bodyMedium,
                color = WhiteSavvy
            )

        }

    }

    Column (
        modifier= Modifier
            .padding(top = 170.dp)
            .padding(start = 20.dp)
    ){
        Row {
            Text(
                text = "Tanggal ",
                style = Typography.titleMedium,
                color = PurpleSavvy1
                )
            Spacer(modifier = Modifier.width(5.dp))
            val textState = remember { mutableStateOf("") }

            TextField(
                value =textState.value ,
                onValueChange ={},
                modifier = Modifier
                    .background(WhiteSavvy)
                    .height(15.dp) // Adjust the height as needed
                    .padding(start = 29.dp)
                    .width(250.dp),
                colors = TextFieldDefaults.colors(
                    unfocusedContainerColor = Color.Transparent,)

            )
        }
        Spacer(modifier = Modifier.height(20.dp))
        Row {
            Text(
                text = "Akun anda ",
                style = Typography.titleMedium,
                color = PurpleSavvy1
            )
            Spacer(modifier = Modifier.width(5.dp))
            val textState = remember { mutableStateOf("") }

            TextField(
                value =textState.value ,
                onValueChange ={},
                modifier = Modifier
                    .background(WhiteSavvy)
                    .height(15.dp) // Adjust the height as needed
                    .padding(start = 10.dp)
                    .width(250.dp),
                colors = TextFieldDefaults.colors(
                    unfocusedContainerColor = Color.Transparent,),
                trailingIcon = {
                    Icon(
                        imageVector = Icons.Default.KeyboardArrowDown,
                        contentDescription = "dropdown",
                        Modifier
                            .padding(start = 45.dp)
                            .scale(1.5f)
                    )
                }

            )
        }
        Spacer(modifier = Modifier.height(20.dp))
        Row {
            Text(
                text = "Kategori ",
                style = Typography.titleMedium,
                color = PurpleSavvy1
            )
            Spacer(modifier = Modifier.width(5.dp))
            val textState = remember { mutableStateOf("") }

            TextField(
                value =textState.value ,
                onValueChange ={},
                modifier = Modifier
                    .background(WhiteSavvy)
                    .height(15.dp) // Adjust the height as needed
                    .padding(start = 25.dp)
                    .width(250.dp),
                colors = TextFieldDefaults.colors(
                    unfocusedContainerColor = Color.Transparent,),
                trailingIcon = {
                    Icon(
                        imageVector = Icons.Default.KeyboardArrowDown,
                        contentDescription ="dropdown",
                        Modifier
                            .padding(start = 45.dp)
                            .scale(1.5f)
                    )
                }

            )
        }
        Spacer(modifier = Modifier.height(20.dp))
        Row {
            Text(
                text = "Total ",
                style = Typography.titleMedium,
                color = PurpleSavvy1
            )
            Spacer(modifier = Modifier.width(5.dp))
            val textState = remember { mutableStateOf("") }

            TextField(
                value =textState.value ,
                onValueChange ={},
                modifier = Modifier
                    .background(WhiteSavvy)
                    .height(15.dp) // Adjust the height as needed
                    .padding(start = 50.dp)
                    .width(250.dp),
                colors = TextFieldDefaults.colors(
                    unfocusedContainerColor = Color.Transparent,)

            )
        }
        Spacer(modifier = Modifier.height(20.dp))
        Row {
            Text(
                text = "Catatan ",
                style = Typography.titleMedium,
                color = PurpleSavvy1
            )
            Spacer(modifier = Modifier.width(5.dp))
            val textState = remember { mutableStateOf("") }

            TextField(
                value =textState.value ,
                onValueChange ={},
                modifier = Modifier
                    .background(WhiteSavvy)
                    .height(15.dp) // Adjust the height as needed
                    .padding(start = 29.dp)
                    .width(250.dp),
                colors = TextFieldDefaults.colors(
                    unfocusedContainerColor = Color.Transparent,)

            )
        }
        Spacer(modifier = Modifier.height(20.dp))
        Row {
            Text(
                text = "Deskripsi ",
                style = Typography.titleMedium,
                color = PurpleSavvy1
            )
            Spacer(modifier = Modifier.width(5.dp))
            val textState = remember { mutableStateOf("") }

            TextField(
                value =textState.value ,
                onValueChange ={},
                modifier = Modifier
                    .background(WhiteSavvy)
                    .height(15.dp) // Adjust the height as needed
                    .padding(start = 20.dp)
                    .width(250.dp),
                colors = TextFieldDefaults.colors(
                    unfocusedContainerColor = Color.Transparent,),
                trailingIcon = {
                    Icon(
                        painter = painterResource(id = R.drawable.cam),
                        contentDescription = "Edit Icon",
                        tint = Color(0xFF392467),
                        modifier = Modifier
                            .padding(start = 25.dp)
                            .size(20.dp)

                        )
                }

            )
        }
        Row(
            modifier = Modifier
                .padding(top=70.dp)
                .padding(start = 20.dp)
        ) {
            Button(
                onClick = { /*TODO*/ },
                colors = ButtonDefaults.buttonColors(containerColor = OrangeSavvy),
                shape = RoundedCornerShape(8.dp),
                modifier = Modifier
                    .size(width = 150.dp, height = 45.dp)
            ){
                Text(
                    text = "Simpan",
                    style = Typography.displayMedium,
                    color = WhiteSavvy
                )
            }
            Spacer(modifier = Modifier.width(10.dp))
            Button(
                onClick = { /*TODO*/ },
                colors = ButtonDefaults.buttonColors(containerColor = WhiteSavvy),
                shape = RoundedCornerShape(8.dp),
                border = BorderStroke(2.dp, color = OrangeSavvy),
                modifier = Modifier
                    .size(width = 150.dp, height = 45.dp)
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


@Composable
fun FormIncome() {
    Row (modifier = Modifier
        .fillMaxSize()
        .padding(top = 100.dp)
        .padding(start = 55.dp)
        .background(WhiteSavvy)

    ){
        Button(
            onClick = { /*TODO*/ },
            colors = ButtonDefaults.buttonColors(containerColor = PurpleSavvy1),
            shape = RoundedCornerShape(8.dp),
            modifier = Modifier
                .size(width = 130.dp, height = 35.dp)
        ){
            Text(
                text = "Pemasukan",
                style = Typography.bodyMedium,
                color = WhiteSavvy
            )
        }
        Spacer(modifier = Modifier.width(5.dp))
        Button(
            onClick = { /*TODO*/ },
            colors = ButtonDefaults.buttonColors(containerColor = WhiteSavvy),
            border = BorderStroke(2.dp, color = PurpleSavvy1),
            shape = RoundedCornerShape(8.dp),
            modifier = Modifier
                .size(width = 130.dp, height = 35.dp)
        ){
            Text(
                text = "Pengeluaran",
                style = Typography.bodyMedium,
                color = PurpleSavvy1
            )

        }

    }
    Column (
        modifier= Modifier
            .padding(top = 170.dp)
            .padding(start = 20.dp)
    ){
        Row {
            Text(
                text = "Tanggal ",
                style = Typography.titleMedium,
                color = PurpleSavvy1
            )
            Spacer(modifier = Modifier.width(5.dp))
            val textState = remember { mutableStateOf("") }

            TextField(
                value =textState.value ,
                onValueChange ={},
                modifier = Modifier
                    .background(WhiteSavvy)
                    .height(15.dp) // Adjust the height as needed
                    .padding(start = 29.dp)
                    .width(250.dp),
                colors = TextFieldDefaults.colors(
                    unfocusedContainerColor = Color.Transparent,)

            )
        }

        Spacer(modifier = Modifier.height(20.dp))
        Row {
            Text(
                text = "Kategori ",
                style = Typography.titleMedium,
                color = PurpleSavvy1
            )
            Spacer(modifier = Modifier.width(5.dp))
            val textState = remember { mutableStateOf("") }

            TextField(
                value =textState.value ,
                onValueChange ={},
                modifier = Modifier
                    .background(WhiteSavvy)
                    .height(15.dp) // Adjust the height as needed
                    .padding(start = 25.dp)
                    .width(250.dp),
                colors = TextFieldDefaults.colors(
                    unfocusedContainerColor = Color.Transparent,),
                trailingIcon = {
                    Icon(
                        imageVector = Icons.Default.KeyboardArrowDown,
                        contentDescription ="dropdown",
                        Modifier
                            .padding(start = 45.dp)
                            .scale(1.5f)
                    )
                }

            )
        }
        Spacer(modifier = Modifier.height(20.dp))
        Row {
            Text(
                text = "Total ",
                style = Typography.titleMedium,
                color = PurpleSavvy1
            )
            Spacer(modifier = Modifier.width(5.dp))
            val textState = remember { mutableStateOf("") }

            TextField(
                value =textState.value ,
                onValueChange ={},
                modifier = Modifier
                    .background(WhiteSavvy)
                    .height(15.dp) // Adjust the height as needed
                    .padding(start = 50.dp)
                    .width(250.dp),
                colors = TextFieldDefaults.colors(
                    unfocusedContainerColor = Color.Transparent,)

            )
        }
        Spacer(modifier = Modifier.height(20.dp))
        Row {
            Text(
                text = "Catatan ",
                style = Typography.titleMedium,
                color = PurpleSavvy1
            )
            Spacer(modifier = Modifier.width(5.dp))
            val textState = remember { mutableStateOf("") }

            TextField(
                value =textState.value ,
                onValueChange ={},
                modifier = Modifier
                    .background(WhiteSavvy)
                    .height(15.dp) // Adjust the height as needed
                    .padding(start = 29.dp)
                    .width(250.dp),
                colors = TextFieldDefaults.colors(
                    unfocusedContainerColor = Color.Transparent,)

            )
        }
        Spacer(modifier = Modifier.height(20.dp))
        Row {
            Text(
                text = "Deskripsi ",
                style = Typography.titleMedium,
                color = PurpleSavvy1
            )
            Spacer(modifier = Modifier.width(5.dp))
            val textState = remember { mutableStateOf("") }

            TextField(
                value =textState.value ,
                onValueChange ={},
                modifier = Modifier
                    .background(WhiteSavvy)
                    .height(15.dp) // Adjust the height as needed
                    .padding(start = 20.dp)
                    .width(250.dp),
                colors = TextFieldDefaults.colors(
                    unfocusedContainerColor = Color.Transparent,),
                trailingIcon = {
                    Icon(
                        painter = painterResource(id = R.drawable.cam),
                        contentDescription = "Edit Icon",
                        tint = Color(0xFF392467),
                        modifier = Modifier
                            .padding(start = 25.dp)
                            .size(20.dp)

                    )
                }

            )
        }
        Row(
            modifier = Modifier
                .padding(top=70.dp)
                .padding(start = 20.dp)
        ) {
            Button(
                onClick = { /*TODO*/ },
                colors = ButtonDefaults.buttonColors(containerColor = OrangeSavvy),
                shape = RoundedCornerShape(8.dp),
                modifier = Modifier
                    .size(width = 150.dp, height = 45.dp)
            ){
                Text(
                    text = "Simpan",
                    style = Typography.displayMedium,
                    color = WhiteSavvy
                )
            }
            Spacer(modifier = Modifier.width(10.dp))
            Button(
                onClick = { /*TODO*/ },
                colors = ButtonDefaults.buttonColors(containerColor = WhiteSavvy),
                shape = RoundedCornerShape(8.dp),
                border = BorderStroke(2.dp, color = OrangeSavvy),
                modifier = Modifier
                    .size(width = 150.dp, height = 45.dp)
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

/*
@Composable
fun AkunAndaDropdown() {
    // Daftar opsi untuk dropdown
    val akunOptions = listOf("Uang Tunai", "Bank BCA", "Bank Mandiri")

    // State untuk menyimpan opsi yang dipilih
    val selectedAkunOption = remember { mutableStateOf(akunOptions[0]) }

    // Dropdown
    Column(
        modifier = Modifier.padding(vertical = 8.dp)
    ) {
        Text(
            text = "Akun Anda",
            color = Color.Black
        )

        Spacer(modifier = Modifier.height(8.dp))
        DropdownMenu(
            expanded = expanded,
            onDismissRequest = {},
            label = {
                Text(text = selectedAkunOption.value)
            }
        ) {
            akunOptions.forEach { option ->
                DropdownMenuItem(
                    onClick = {
                        selectedAkunOption.value = option
                    }
                ) {
                    Text(text = option)
                }
            }
        }
    }
}
*/

@Preview(showBackground = true)
@Composable
fun FormIncomePreview() {
    FormIncome()
}
