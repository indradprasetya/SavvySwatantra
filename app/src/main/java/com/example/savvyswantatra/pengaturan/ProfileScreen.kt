package com.example.savvyswantatra.pengaturan

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AddCircle
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.savvyswantatra.R

@Composable
fun ProfileScreen(navController: NavController) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFF392467))
    ) {
        // Card di bagian bawah
        Card(
            shape = RoundedCornerShape(16.dp),
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight()
                .padding(top = 250.dp) // Memberi ruang untuk gambar di atas
        ) {
            val textState = remember { mutableStateOf("") }

            Spacer(modifier = Modifier.height(90.dp))
            TextField(
                value = textState.value,
                onValueChange = { textState.value = it },
                label = { Text("Nama Pengguna") },
                trailingIcon = {
                    Icon(
                        imageVector = Icons.Default.Edit,
                        contentDescription = "Edit Icon",
                        tint = Color(0xFF392467))
                },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp)

            )
            Spacer(modifier = Modifier.height(1.dp))
            TextField(
                value = textState.value,
                onValueChange = { textState.value = it },
                label = { Text("Nama Lengkap") },
                trailingIcon = {
                    Icon(
                        imageVector = Icons.Default.Edit,
                        contentDescription = "Edit Icon",
                        tint = Color(0xFF392467))
                },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp)
            )
            Spacer(modifier = Modifier.height(1.dp))
            TextField(
                value = textState.value,
                onValueChange = { textState.value = it },
                label = { Text("Email") },
                trailingIcon = {
                       Icon(
                           imageVector = Icons.Default.Edit,
                           contentDescription = "Edit Icon",
                           tint = Color(0xFF392467))
                },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp)
            )
            Spacer(modifier = Modifier.height(50.dp))
            Button(onClick = { /*TODO*/
            },
                modifier = Modifier
                    .fillMaxWidth()
//                    .height(56.dp)
                    .size(height = 56.dp, width = 10.dp)
                    .padding(horizontal = 32.dp)
                    .align(Alignment.CenterHorizontally),
                colors = ButtonDefaults.buttonColors(Color(0xFFEB7F63))
            ) {
                Text("Simpan")
            }
        }
        // Box yang berisi gambar dan ikon di depan Card
        Box(
            modifier = Modifier
                .align(Alignment.TopCenter)
                .offset(y = 180.dp) // Mengatur offset untuk menimpa Card
                .background(Color.Transparent) // Ganti dengan warna atau konten yang sesuai
        ) {
            Image(
                painter = painterResource(id = R.drawable.zhaolusi),
                contentDescription = "profile",
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .align(Alignment.Center)
                    .size(130.dp)
                    .clip(CircleShape)
                    .border(4.dp, Color.White, CircleShape)
            )
            Icon(
                imageVector = Icons.Default.AddCircle,
                contentDescription = "Tambah Icon",
                tint = Color(0xFFEB7F63),
                modifier = Modifier
                    .align(Alignment.BottomEnd)
                    .offset(x = 7.dp, y = 5.dp)
                    .size(45.dp)
            )
        }
    }
}
