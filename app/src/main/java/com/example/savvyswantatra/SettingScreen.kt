package com.example.savvyswantatra

import androidx.compose.foundation.background
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
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowForward
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material.icons.filled.ExitToApp
import androidx.compose.material.icons.filled.Info
import androidx.compose.material.icons.filled.KeyboardArrowRight
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.Card
import androidx.compose.material3.CardColors
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.savvyswantatra.navigation.Screen
import com.example.savvyswantatra.ui.theme.WhiteSavvy

@Composable
fun SettingScreen(navController: NavController) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFF392467)),
        contentAlignment = Alignment.Center
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = "Pengaturan",
                fontSize = 24.sp,
                fontWeight = FontWeight.Bold,
                color = Color.White,
                modifier = Modifier
                    .padding(top = 90.dp)
            )
            // Card di bagian bawah
            Card(
                shape = RoundedCornerShape(16.dp),
                colors = CardDefaults.cardColors(containerColor = Color.White),
                modifier = Modifier
                    .fillMaxWidth()
                    .fillMaxHeight()
                    .padding(top = 100.dp) // Memberi ruang untuk gambar di atas
            ) {
                val textState = remember { mutableStateOf("") }

                Spacer(modifier = Modifier.height(40.dp))
                TextField(
                    value = textState.value,
                    onValueChange = { textState.value = it },
                    label = { Text("Akun") },
                    leadingIcon = {
                        Icon(
                            imageVector = Icons.Default.Person, // Menggunakan ikon default Person
                            contentDescription = "Akun"
                        )
                    },
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(16.dp)
                )
                Spacer(modifier = Modifier.height(10.dp))
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 16.dp)
                        .clickable(onClick = {
                            navController.navigate(Screen.profil.route)
                        }),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(
                        text = "Edit Profil",
                        fontSize = 18.sp,
                        fontWeight = FontWeight.Normal,
                        color = Color.Black
                    )
                    Icon(
                        imageVector = Icons.Default.KeyboardArrowRight, // Menggunakan ikon default ArrowForward
                        contentDescription = "Edit Profil"
                    )
                }
                Spacer(modifier = Modifier.height(20.dp))
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 16.dp),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(
                        text = "Ubah Kata Sandi",
                        fontSize = 18.sp,
                        fontWeight = FontWeight.Normal,
                        color = Color.Black
                    )
                    Icon(
                        imageVector = Icons.Default.KeyboardArrowRight,
                        contentDescription = "Ubah Sandi"
                    )
                }
                Spacer(modifier = Modifier.height(35.dp))
                TextField(
                    value = textState.value,
                    onValueChange = { textState.value = it },
                    label = { Text("Selengkapnya") },
                    leadingIcon = {
                        Icon(
                            imageVector = Icons.Default.Info, // Menggunakan ikon default Person
                            contentDescription = "Selengkapnya"
                        )
                    },
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(16.dp)
                )
                Spacer(modifier = Modifier.height(10.dp))
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 16.dp),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(
                        text = "Syarat dan Ketentuan",
                        fontSize = 18.sp,
                        fontWeight = FontWeight.Normal,
                        color = Color.Black
                    )
                    Icon(
                        imageVector = Icons.Default.KeyboardArrowRight,
                        contentDescription = "S&K"
                    )
                }
                Spacer(modifier = Modifier.height(20.dp))
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 16.dp),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(
                        text = "Keluar",
                        fontSize = 18.sp,
                        fontWeight = FontWeight.Normal,
                        color = Color.Black
                    )
                    Icon(
                        imageVector = Icons.Default.KeyboardArrowRight,
                        contentDescription = "Keluar"
                    )
                }
            }
        }
    }
}
