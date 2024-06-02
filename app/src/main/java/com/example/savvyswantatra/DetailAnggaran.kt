package com.example.savvyswantatra

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AddCircle
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.BottomSheetScaffold
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.rememberBottomSheetScaffoldState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.savvyswantatra.component.Anggaran
import com.example.savvyswantatra.component.AnggaranData
import com.example.savvyswantatra.component.AnggaranData.anggaranList
import com.example.savvyswantatra.component.Detail_kategori_card
import com.example.savvyswantatra.component.KategoriAnggaran
import com.example.savvyswantatra.component.KategoriAnggaranData
import com.example.savvyswantatra.component.KategoriAnggaranData.kategoriList
import com.example.savvyswantatra.ui.theme.OrangeSavvy
import com.example.savvyswantatra.ui.theme.PurpleSavvy1
import com.example.savvyswantatra.ui.theme.PurpleSavvy2
import com.example.savvyswantatra.ui.theme.Typography
import com.example.savvyswantatra.ui.theme.WhiteSavvy

import kotlinx.coroutines.launch
import java.text.NumberFormat

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DetailScreen(navController: NavController, namaAnggaran: String){
    val anggaran = anggaranList.first { it.nama == namaAnggaran }
    val coroutineScope = rememberCoroutineScope()
    val bottomScaffoldState = rememberBottomSheetScaffoldState()
    BottomSheetScaffold(
        sheetContent = {
            Box(
                Modifier
                    .heightIn(max = 300.dp)
                    .background(Color.White)
                ){
                BottomSheetContent()
            }
        },
        scaffoldState = bottomScaffoldState,
        sheetPeekHeight = 0.dp,
        sheetShape = RoundedCornerShape(topStart = 16.dp, topEnd = 16.dp),
        sheetContainerColor = Color.White,
        sheetShadowElevation = 8.dp
    ) {
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = WhiteSavvy
        ){
            Column {
                Row {
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
                            IconButton(onClick = {
                                navController.popBackStack()

                            }) {
                                Icon(Icons.Filled.ArrowBack, contentDescription = "Kembali", tint = Color.Black)
                            }
                            Text(
                                text = "DETAIL ANGGARAN",
                                style = Typography.displayMedium,
                                color = PurpleSavvy1
                            )
                        }
                    }
                }
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment =  Alignment.CenterVertically
                ) {
                    Row(
                        verticalAlignment = Alignment.CenterVertically,
                        modifier = Modifier
                            .padding(24.dp)
                            .padding(start = 10.dp),
                        horizontalArrangement = Arrangement.spacedBy(10.dp)
                    ) {
                        Image(
                            painterResource(id = anggaran.imageResources) ,
                            contentDescription = null,
                            modifier = Modifier
                                .clip(CircleShape)
                                .border(width = 2.dp, color = PurpleSavvy2, shape = CircleShape)
                                .size(50.dp),
                            contentScale = ContentScale.Crop
                        )
                        Column {
                            Text(text = anggaran.nama, style = Typography.displaySmall, color = PurpleSavvy1)
                            val formatter = NumberFormat.getNumberInstance()
                            val nominalFormatted = formatter.format(anggaran.jumlah)
                            Text(text = "Rp.$nominalFormatted",style = Typography.displayMedium,color = PurpleSavvy1)
                        }
                    }
                    Row (
                        verticalAlignment = Alignment.CenterVertically,
                        modifier = Modifier.offset(x= (-34).dp)
                    ){
                        IconButton(onClick = {
                            coroutineScope.launch { bottomScaffoldState.bottomSheetState.expand() }
                        }) {
                            Icon(
                                Icons.Default.AddCircle,
                                contentDescription = null,
                                tint = OrangeSavvy
                            )
                        }
                        Text(text = "Tambah Kategori", style = Typography.bodyMedium, color = PurpleSavvy1 , modifier = Modifier.offset(x = (-10).dp))
                    }
                }
                Detail_kategori_card(imageResource = R.drawable.makan, keterangan = "makanan", jumlah_saldo = "1000/2000")
            }
        }
    }
}
@Composable
fun BottomSheetContent() {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp)
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Box(
                modifier = Modifier
                    .size(50.dp)
                    .shadow(elevation = 4.dp, shape = RoundedCornerShape(10.dp), clip = false)
                    .background(Color.White, shape = RoundedCornerShape(10.dp))
                    .border(
                        width = 1.dp,
                        color = Color.Transparent,
                        shape = RoundedCornerShape(10.dp)
                    )
                    .padding(5.dp)
            ) {
                Image(
                    painterResource(id = kategoriList[0].imageResources),
                    contentDescription = "",
                    modifier = Modifier.size(50.dp)
                )
            }
            Text(
                text = kategoriList[0].nama,
                style = Typography.displayMedium,
                color = PurpleSavvy1,
                modifier = Modifier
                    .weight(1f)
                    .padding(start = 12.dp)
            )
            IconButton(onClick = { /*TODO*/ }) {
                Icon(Icons.Default.AddCircle, contentDescription = "", tint = OrangeSavvy)
            }
        }
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Box(
                modifier = Modifier
                    .size(50.dp)
                    .shadow(elevation = 4.dp, shape = RoundedCornerShape(10.dp), clip = false)
                    .background(Color.White, shape = RoundedCornerShape(10.dp))
                    .border(
                        width = 1.dp,
                        color = Color.Transparent,
                        shape = RoundedCornerShape(10.dp)
                    )
                    .padding(5.dp)
            ) {
                Image(
                    painterResource(id = kategoriList[1].imageResources),
                    contentDescription = "",
                    modifier = Modifier.size(50.dp)
                )
            }
            Text(
                text = kategoriList[1].nama,
                style = Typography.displayMedium,
                color = PurpleSavvy1,
                modifier = Modifier
                    .weight(1f)
                    .padding(start = 12.dp)
            )
            IconButton(onClick = { /*TODO*/ }) {
                Icon(Icons.Default.AddCircle, contentDescription = "", tint = OrangeSavvy)
            }
        }
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Box(
                modifier = Modifier
                    .size(50.dp)
                    .shadow(elevation = 4.dp, shape = RoundedCornerShape(10.dp), clip = false)
                    .background(Color.White, shape = RoundedCornerShape(10.dp))
                    .border(
                        width = 1.dp,
                        color = Color.Transparent,
                        shape = RoundedCornerShape(10.dp)
                    )
                    .padding(5.dp)
            ) {
                Image(
                    painterResource(id = kategoriList[2].imageResources),
                    contentDescription = "",
                    modifier = Modifier.size(50.dp)
                )
            }
            Text(
                text = kategoriList[2].nama,
                style = Typography.displayMedium,
                color = PurpleSavvy1,
                modifier = Modifier
                    .weight(1f)
                    .padding(start = 12.dp)
            )
            IconButton(onClick = { /*TODO*/ }) {
                Icon(Icons.Default.AddCircle, contentDescription = "", tint = OrangeSavvy)
            }
        }
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Box(
                modifier = Modifier
                    .size(50.dp)
                    .shadow(elevation = 4.dp, shape = RoundedCornerShape(10.dp), clip = false)
                    .background(Color.White, shape = RoundedCornerShape(10.dp))
                    .border(
                        width = 1.dp,
                        color = Color.Transparent,
                        shape = RoundedCornerShape(10.dp)
                    )
                    .padding(5.dp)
            ) {
                Image(
                    painterResource(id = kategoriList[3].imageResources),
                    contentDescription = "",
                    modifier = Modifier.size(50.dp)
                )
            }
            Text(
                text = kategoriList[3].nama,
                style = Typography.displayMedium,
                color = PurpleSavvy1,
                modifier = Modifier
                    .weight(1f)
                    .padding(start = 12.dp)
            )
            IconButton(onClick = { /*TODO*/ }) {
                Icon(Icons.Default.AddCircle, contentDescription = "", tint = OrangeSavvy)
            }
        }
    }
}
