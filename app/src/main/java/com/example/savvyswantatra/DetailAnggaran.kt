package com.example.savvyswantatra

import android.app.DatePickerDialog
import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.requiredHeight
import androidx.compose.foundation.layout.requiredWidth
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AddCircle
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.DateRange
import androidx.compose.material3.BottomSheetScaffold
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.material3.rememberBottomSheetScaffoldState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.snapshots.SnapshotStateList
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.example.savvyswantatra.component.Anggaran
import com.example.savvyswantatra.component.AnggaranData
import com.example.savvyswantatra.component.AnggaranData.anggaranList
import com.example.savvyswantatra.component.Detail_kategori_card
import com.example.savvyswantatra.component.KategoriAnggaran
import com.example.savvyswantatra.component.KategoriAnggaranData
import com.example.savvyswantatra.component.KategoriAnggaranData.kategoriList
import com.example.savvyswantatra.component.Transaksi
import com.example.savvyswantatra.component.TransaksiData
import com.example.savvyswantatra.navigation.Screen
import com.example.savvyswantatra.ui.theme.OrangeSavvy
import com.example.savvyswantatra.ui.theme.PurpleSavvy1
import com.example.savvyswantatra.ui.theme.PurpleSavvy2
import com.example.savvyswantatra.ui.theme.Typography
import com.example.savvyswantatra.ui.theme.WhiteSavvy
import com.example.savvyswantatra.ui.theme.poppinsFontFamily

import kotlinx.coroutines.launch
import java.text.NumberFormat
import java.util.Calendar

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DetailScreen(navController: NavController, namaAnggaran: String, addedCategories: MutableList<KategoriAnggaran>) {
    val anggaran = anggaranList.firstOrNull { it.nama == namaAnggaran }

    if (anggaran != null) {
        val coroutineScope = rememberCoroutineScope()
        val bottomScaffoldState = rememberBottomSheetScaffoldState()
        val (showSecondBottomSheet, setShowSecondBottomSheet) = remember { mutableStateOf(false) }
        val (selectedCategory, setSelectedCategory) = remember { mutableStateOf("") }
        val (showTransactionSheet, setShowTransactionSheet) = remember { mutableStateOf(false) }

        BottomSheetScaffold(
            sheetContent = {
                Box(
                    Modifier
                        .heightIn(max = 300.dp)
                        .background(Color.White)
                ) {
                    if (showSecondBottomSheet) {
                        SecondBottomSheetContent(selectedCategory, onBackClick = {
                            setShowSecondBottomSheet(false)
                            setShowTransactionSheet(false)
                        }) { category, saldo ->
                            val selectedKategori = KategoriAnggaranData.kategoriList.first { it.id.toString() == category }
                            val newCategory = selectedKategori.copy(batas_anggaran = saldo.toDoubleOrNull())
                            addedCategories.add(newCategory)
                            setShowSecondBottomSheet(false)
                        }
                    }else if (showTransactionSheet) {
                        TransaksiBottomSheet(onBackClick = {
                            setShowTransactionSheet(false)
                        }, navController = navController)
                        setShowSecondBottomSheet(false)
                    }
                    else {
                        BottomSheetContent(onAddClick = { category ->
                            setSelectedCategory(category)
                            setShowSecondBottomSheet(true)
                        })
                    }
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
            ) {
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
                            ) {
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
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Row(
                            verticalAlignment = Alignment.CenterVertically,
                            modifier = Modifier
                                .padding(24.dp)
                                .padding(start = 10.dp),
                            horizontalArrangement = Arrangement.spacedBy(10.dp)
                        ) {
                            Image(
                                painterResource(id = anggaran.imageResources),
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
                                Text(text = "Rp.$nominalFormatted", style = Typography.displayMedium, color = PurpleSavvy1)
                            }
                        }
                        Row(
                            verticalAlignment = Alignment.CenterVertically,
                            modifier = Modifier.offset(x = (-34).dp)
                        ) {
                            IconButton(onClick = {
                                coroutineScope.launch { bottomScaffoldState.bottomSheetState.expand() }
                                setShowSecondBottomSheet(false)
                                setShowTransactionSheet(false)
                            }) {
                                Icon(
                                    Icons.Default.AddCircle,
                                    contentDescription = null,
                                    tint = OrangeSavvy
                                )
                            }
                            Text(text = "Tambah Kategori", style = Typography.bodyMedium, color = PurpleSavvy1, modifier = Modifier.offset(x = (-10).dp))
                        }
                    }

                    LazyColumn(
                        modifier = Modifier.fillMaxSize(),
                        verticalArrangement = Arrangement.spacedBy(8.dp)
                    ) {
                        items(addedCategories) { kategori ->
                            Detail_kategori_card(
                                imageResource = kategori.imageResources,
                                keterangan = kategori.nama,
                                jumlah_saldo = "0",
                                batas_anggaran = kategori.batas_anggaran ?: 0.0,
                                onDelete = {addedCategories.remove(kategori)},
                                onAddTransactionClick = {
                                    coroutineScope.launch { bottomScaffoldState.bottomSheetState.expand() }
                                    setShowTransactionSheet(true)
                                    setShowSecondBottomSheet(false)
                                }
                            )
                        }
                    }
                }
            }
        }
    } else {
        // Handle kasus ketika anggaran tidak ditemukan
        Text("Anggaran tidak ditemukan", color = Color.Red)
    }
}


@Composable
fun BottomSheetContent(onAddClick: (String) -> Unit) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp)
    ) {
        KategoriAnggaranData.kategoriList.forEach { kategori ->
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
                        painterResource(id = kategori.imageResources),
                        contentDescription = "",
                        modifier = Modifier.size(50.dp)
                    )
                }
                Text(
                    text = kategori.nama,
                    style = Typography.displayMedium,
                    color = PurpleSavvy1,
                    modifier = Modifier
                        .weight(1f)
                        .padding(start = 12.dp)
                )
                IconButton(onClick = { onAddClick(kategori.id.toString()) }) {
                    Icon(Icons.Default.AddCircle, contentDescription = "", tint = OrangeSavvy)
                }
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SecondBottomSheetContent(selectedCategory: String, onBackClick: () -> Unit, onAddCategory: (String, String) -> Unit) {
    val selectedKategori = KategoriAnggaranData.kategoriList.first { it.id.toString() == selectedCategory }
    val context = LocalContext.current
    val textJumlah = remember { mutableStateOf("") }
    Column {
        Row(
            modifier = Modifier
                .padding(16.dp)
                .fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceAround
        ) {
            IconButton(onClick = onBackClick) {
                Icon(Icons.Filled.ArrowBack, contentDescription = "Kembali", tint = Color.Black)
            }
            Row(
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
                        painterResource(id = selectedKategori.imageResources),
                        contentDescription = "",
                        modifier = Modifier.size(50.dp)
                    )
                }
                Text(
                    text = selectedKategori.nama,
                    style = Typography.displayMedium,
                    color = PurpleSavvy1,
                    modifier = Modifier
                        .weight(1f)
                        .padding(start = 12.dp)
                )
            }
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
                value = textJumlah.value,
                onValueChange = { newText ->
                    textJumlah.value = newText
                },
                label = {
                    Text(
                        text = "",
                    )
                },
                modifier = Modifier
                    .fillMaxWidth()
                    .offset(y = (-8).dp),
                colors = TextFieldDefaults.textFieldColors(containerColor = Color.White),
                textStyle = TextStyle(
                    color = PurpleSavvy1,
                    fontFamily = poppinsFontFamily
                )
            )
        }
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(30.dp)
                .padding(start = 25.dp),
            horizontalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            Button(
                onClick = {
                    val jumlah = textJumlah.value.toDoubleOrNull()
                    if (jumlah == null) {
                        Toast.makeText(
                            context,
                            "Jumlah saldo harus berupa angka",
                            Toast.LENGTH_SHORT
                        ).show()
                    } else {
                        onAddCategory(selectedCategory, textJumlah.value)
                        textJumlah.value = ""
                    }
                },
                shape = RoundedCornerShape(5.dp),
                colors = ButtonDefaults.buttonColors(containerColor = Color(0xffeb7f63)),
                modifier = Modifier
                    .requiredWidth(width = 140.dp)
                    .requiredHeight(height = 35.dp)
            ) {
                Text(
                    text = "Tambah",
                    style = Typography.bodyMedium
                )
            }
            Button(
                onClick = {
                    textJumlah.value = ""  // Ubah ini menjadi String kosong
                },
                shape = RoundedCornerShape(5.dp),
                colors = ButtonDefaults.buttonColors(containerColor = Color(0xffEBE7E7)),
                modifier = Modifier
                    .requiredWidth(width = 140.dp)
                    .requiredHeight(height = 35.dp)
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
//class TransaksiViewModel : ViewModel() {
//    private val _transaksiList = mutableStateListOf<Transaksi>()
//    val transaksiList: SnapshotStateList<Transaksi> = _transaksiList
//    fun addTransaksi(transaksi: Transaksi) {
//        _transaksiList.add(transaksi)
//    }
//    fun deleteTransaksi(transaksi: Transaksi) {
//        _transaksiList.remove(transaksi)
//    }
//}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TransaksiBottomSheet(
    onBackClick: () -> Unit,
    navController: NavController,
//    transaksiViewModel: TransaksiViewModel = viewModel()
) {
    val textNama = remember { mutableStateOf("") }
    val textJumlah = remember { mutableStateOf("") }
    val context = LocalContext.current
    val selectedDate = remember { mutableStateOf("") }
    Column {
        Row(
            modifier = Modifier
                .padding(8.dp)
                .fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween,
        ) {
            Row(verticalAlignment = Alignment.CenterVertically) {
                IconButton(onClick = onBackClick) {
                    Icon(Icons.Filled.ArrowBack, contentDescription = "Kembali", tint = Color.Black)
                }
                Text(text = "Transaksi", style = Typography.displayMedium, color = PurpleSavvy1)
            }
            Row(
                modifier = Modifier.padding(end = 10.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Spacer(modifier = Modifier.width(4.dp))
                Text(
                    text = selectedDate.value,
                    style = Typography.displayMedium,
                    fontSize = 14.sp,
                    color = PurpleSavvy1
                )
                IconButton(onClick = {
                    val calendar = Calendar.getInstance()
                    val year = calendar.get(Calendar.YEAR)
                    val month = calendar.get(Calendar.MONTH)
                    val day = calendar.get(Calendar.DAY_OF_MONTH)
                    DatePickerDialog(context, { _, year, month, dayOfMonth ->
                        selectedDate.value = "$dayOfMonth/${month + 1}/$year"
                    }, year, month, day).show()
                }) {
                    Icon(Icons.Filled.DateRange, contentDescription = "Pilih Tanggal", tint = OrangeSavvy)
                }
            }
        }

        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .padding(horizontal = 30.dp)
        ) {
            Text(
                text = "Keterangan              : ",
                style = Typography.displaySmall,
                color = PurpleSavvy1,
                fontSize = 14.sp
            )
            Spacer(modifier = Modifier.width(4.dp))
            TextField(
                value = textNama.value,
                onValueChange = { newText ->
                    textNama.value = newText
                },
                label = {
                    Text(
                        text = "",
                    )
                },
                modifier = Modifier
                    .fillMaxWidth()
                    .offset(y = (-8).dp),
                colors = TextFieldDefaults.textFieldColors(containerColor = Color.White),
                textStyle = TextStyle(color = PurpleSavvy1, fontFamily = poppinsFontFamily,)
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
                value = textJumlah.value,
                onValueChange = { newText ->
                    textJumlah.value = newText
                },
                label = {
                    Text(
                        text = "",  // Ubah ini menjadi String kosong
                    )
                },
                modifier = Modifier
                    .fillMaxWidth()
                    .offset(y = (-8).dp),
                colors = TextFieldDefaults.textFieldColors(containerColor = Color.White),
                textStyle = TextStyle(
                    color = PurpleSavvy1,
                    fontFamily = poppinsFontFamily
                )
            )
        }
        Row(
            modifier = Modifier
                .padding(50.dp),
            horizontalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            Button(
                onClick = {
                    val jumlah = textJumlah.value.toDoubleOrNull()
                    if (textNama.value.isBlank()) {
                        Toast.makeText(
                            context,
                            "Nama anggaran tidak boleh kosong",
                            Toast.LENGTH_SHORT
                        ).show()
                    } else if (selectedDate.value.isBlank()) {
                        Toast.makeText(
                            context,
                            "Tanggal harus diisi",
                            Toast.LENGTH_SHORT
                        ).show()
                    } else if (jumlah == null) {
                        Toast.makeText(
                            context,
                            "Jumlah saldo harus berupa angka",
                            Toast.LENGTH_SHORT
                        ).show()
                    } else {
                        TransaksiData.transaksiList.add(
                            Transaksi(
                                nama = textNama.value,
                                jumlah = jumlah,
                                tanggal = selectedDate.value
                            )
                        )
                        navController.popBackStack()
                        navController.navigate(Screen.riwayatAnggaran.route)
                    }
                },
                shape = RoundedCornerShape(5.dp),
                colors = ButtonDefaults.buttonColors(containerColor = Color(0xffeb7f63)),
                modifier = Modifier
                    .requiredWidth(width = 140.dp)
                    .requiredHeight(height = 35.dp)
            ) {
                Text(
                    text = "Tambah",
                    style = Typography.bodyMedium
                )
            }
            Button(
                onClick = {
                    textNama.value = ""
                    textJumlah.value = ""
                    selectedDate.value = ""
                },
                shape = RoundedCornerShape(5.dp),
                colors = ButtonDefaults.buttonColors(containerColor = Color(0xffEBE7E7)),
                modifier = Modifier
                    .requiredWidth(width = 140.dp)
                    .requiredHeight(height = 35.dp)
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


