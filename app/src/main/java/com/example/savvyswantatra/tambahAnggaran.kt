package com.example.savvyswantatra

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.requiredHeight
import androidx.compose.foundation.layout.requiredWidth
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
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
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.savvyswantatra.component.BankList
import com.example.savvyswantatra.navigation.Screen
import com.example.savvyswantatra.ui.theme.OrangeSavvy
import com.example.savvyswantatra.ui.theme.PurpleSavvy1
import com.example.savvyswantatra.ui.theme.Typography
import com.example.savvyswantatra.ui.theme.WhiteSavvy

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AddAnggaranScreen(navController: NavController){
    Surface(
        modifier = Modifier.fillMaxSize(),
        color = WhiteSavvy
    ){
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
                ){
                    IconButton(onClick = { navController.popBackStack() }) {
                        Icon(Icons.Filled.ArrowBack, contentDescription = "Kembali", tint = Color.Black)
                    }
                    Text(
                        text = "TAMBAH ANGGARAN",
                        style = Typography.displayMedium,
                        color = PurpleSavvy1
                    )
                }
            }
            Column {
                var text by remember { mutableStateOf("") }
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    modifier = Modifier
                        .padding(horizontal = 30.dp)
                ) {
                    Text(
                        text = "Nama Anggaran   : ",
                        style = Typography.displayMedium,
                        color = PurpleSavvy1,
                        fontSize = 14.sp
                    )
                    Spacer(modifier = Modifier.width(4.dp))
                    TextField(
                        value = text,
                        onValueChange = { newText ->
                            text = newText
                        },
                        label = { Text(
                            "BCA",
                            style = Typography.displayMedium,
                            fontSize = 14.sp,
                            color = PurpleSavvy1,
                            fontWeight = FontWeight.Normal
                        ) },
                        modifier = Modifier
                            .fillMaxWidth(),
                        colors = TextFieldDefaults.textFieldColors(containerColor = WhiteSavvy)
                    )

                }
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    modifier = Modifier.padding(horizontal = 30.dp)
                ) {
                    Text(
                        text = "Jumlah Saldo(Rp): ",
                        style = Typography.displayMedium,
                        fontSize = 14.sp,
                        color = PurpleSavvy1
                    )
                    Spacer(modifier = Modifier.width(4.dp))
                    TextField(
                        value = text,
                        onValueChange = { newText ->
                            text = newText
                        },
                        label = { Text(
                            "3.000.000",
                            style = Typography.displayMedium,
                            fontSize = 14.sp,
                            color = PurpleSavvy1,
                            fontWeight = FontWeight.Normal

                        ) },
                        modifier = Modifier
                            .fillMaxWidth(),
                        colors = TextFieldDefaults.textFieldColors(containerColor = WhiteSavvy)
                    )

                }
                Text(
                    text = "Pilih Icon dibawah",
                    color = PurpleSavvy1,
                    style = Typography.bodyMedium,
                    fontWeight = FontWeight.Normal,
                    modifier = Modifier.padding(30.dp)

                )
                BankList()
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 50.dp)
                        .padding(top = 50.dp),
                    horizontalArrangement = Arrangement.spacedBy(8.dp)
                ) {
                    Button(
                        onClick = { },
                        shape = RoundedCornerShape(5.dp),
                        colors = ButtonDefaults.buttonColors(containerColor = Color(0xffeb7f63)),
                        modifier = Modifier
                            .requiredWidth(width = 140.dp)
                            .requiredHeight(height = 35.dp))
                    {
                        Text(
                            text = "Tambah",
                            style = Typography.bodyMedium
                        )
                    }
                    Button(
                        onClick = { },
                        shape = RoundedCornerShape(5.dp),
                        colors = ButtonDefaults.buttonColors(containerColor = Color(0xffEBE7E7)),
                        modifier = Modifier
                            .requiredWidth(width = 140.dp)
                            .requiredHeight(height = 35.dp))
                    {
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

