    package com.example.savvyswantatra

    import android.app.DatePickerDialog
    import android.util.Log
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
    import androidx.compose.foundation.text.KeyboardOptions
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
    import androidx.compose.runtime.LaunchedEffect
    import androidx.compose.runtime.collectAsState
    import androidx.compose.runtime.getValue
    import androidx.compose.runtime.livedata.observeAsState
    import androidx.compose.runtime.mutableStateOf
    import androidx.compose.runtime.remember
    import androidx.compose.runtime.rememberCoroutineScope
    import androidx.compose.ui.Alignment
    import androidx.compose.ui.Modifier
    import androidx.compose.ui.draw.clip
    import androidx.compose.ui.draw.shadow
    import androidx.compose.ui.graphics.Color
    import androidx.compose.ui.layout.ContentScale
    import androidx.compose.ui.platform.LocalContext
    import androidx.compose.ui.res.painterResource
    import androidx.compose.ui.text.TextStyle
    import androidx.compose.ui.text.input.ImeAction
    import androidx.compose.ui.text.input.KeyboardType
    import androidx.compose.ui.unit.dp
    import androidx.compose.ui.unit.sp
    import androidx.lifecycle.viewmodel.compose.viewModel
    import androidx.navigation.NavController
    import com.example.savvyswantatra.component.Detail_kategori_card
    import com.example.savvyswantatra.component.KategoriAnggaranData
    import com.example.savvyswantatra.component.Transaksi
    import com.example.savvyswantatra.component.TransaksiData
    import com.example.savvyswantatra.component.TransaksiData.transaksiList
    import com.example.savvyswantatra.database.AppDatabase
    import com.example.savvyswantatra.model.KategoriAnggaran
    import com.example.savvyswantatra.navigation.Screen
    import com.example.savvyswantatra.ui.theme.OrangeSavvy
    import com.example.savvyswantatra.ui.theme.PurpleSavvy1
    import com.example.savvyswantatra.ui.theme.PurpleSavvy2
    import com.example.savvyswantatra.ui.theme.Typography
    import com.example.savvyswantatra.ui.theme.WhiteSavvy
    import com.example.savvyswantatra.ui.theme.poppinsFontFamily
    import com.example.savvyswantatra.viewModel.AnggaranViewModel
    import com.example.savvyswantatra.viewModel.AnggaranViewModelFactory
    import com.example.savvyswantatra.viewModel.DetailScreenViewModel
    import com.example.savvyswantatra.viewModel.DetailScreenViewModelFactory
    import kotlinx.coroutines.launch
    import java.text.NumberFormat
    import java.util.Calendar

    @OptIn(ExperimentalMaterial3Api::class)
    @Composable
    fun DetailScreen(
        navController: NavController,
        namaAnggaran: String,
    ) {
        val context = LocalContext.current
        val anggaranDao = AppDatabase.getInstance(context).anggaranDao()
        val kategoriAnggaranDao = AppDatabase.getInstance(context).kategoriAnggaranDao()
        val transaksiDao = AppDatabase.getInstance(context).transaksiDao()

        val viewModel: DetailScreenViewModel = viewModel(
            factory = DetailScreenViewModelFactory(kategoriAnggaranDao, transaksiDao)
        )
        val anggaranViewModel: AnggaranViewModel = viewModel(
            factory = AnggaranViewModelFactory(anggaranDao, kategoriAnggaranDao)
        )
        val anggaranList by anggaranViewModel.anggaranList.observeAsState(emptyList())
        val anggaran = anggaranList.find { it.nama == namaAnggaran }
        Log.d("anggaran", "anggaran list: $anggaran ")

        val kategoriAnggaranList by anggaranViewModel.categories.collectAsState(emptyList())
        val addedCategories by viewModel.categories.collectAsState(emptyList())

        val coroutineScope = rememberCoroutineScope()
        val bottomScaffoldState = rememberBottomSheetScaffoldState()
        val showSecondBottomSheet by viewModel.showSecondBottomSheet.collectAsState()
        val selectedCategory by viewModel.selectedCategory.collectAsState()
        val showTransactionSheet by viewModel.showTransactionSheet.collectAsState()
        val transaksiList by viewModel.transactions.observeAsState(emptyList())
        Log.d("DetailScreen", "Full transaction list: $transaksiList")

        if (anggaran != null) {
            BottomSheetScaffold(
                sheetContent = {
                    Box(
                        Modifier
                            .heightIn(max = 300.dp)
                            .background(Color.White)
                    ) {
                        if (showSecondBottomSheet) {
                            Log.d("DetailScreen", "Selected category: $selectedCategory")
                            // Log all categories for debugging purposes
                            Log.d("DetailScreen", "Available categories: ${KategoriAnggaranData.kategoriList.joinToString { it.nama }}")

                            val selectedKategori = KategoriAnggaranData.kategoriList.firstOrNull { it.nama.equals(selectedCategory, ignoreCase = true) }

                            SecondBottomSheetContent(
                                selectedCategory = selectedCategory,
                                anggaran = anggaran.nama,
                                imageResources = selectedKategori?.imageResources ?: 0, // Ganti dengan nilai default atau penanganan sesuai kebutuhan
                                onBackClick = {
                                    viewModel.setShowSecondBottomSheet(false)
                                    viewModel.setShowTransactionSheet(false)
                                },
                                onAddCategory = { category, saldo, namaAnggaran ->
                                    val selectedKategori = kategoriAnggaranList.firstOrNull { it.nama.equals(category, ignoreCase = true) }
                                    if (selectedKategori != null) {
                                        val newCategory = selectedKategori.copy(
                                            batas_anggaran = saldo.toDoubleOrNull(),
                                            namaAnggaran = anggaran.nama,
                                            nama = selectedKategori.nama
                                        )
                                        viewModel.addCategory(newCategory)
                                        viewModel.setShowSecondBottomSheet(false)
                                    } else {
                                        Log.e("DetailScreen", "Category not found: $category")
                                    }
                                }
                            )
                        } else if (showTransactionSheet) {
                            // Handle transaction sheet code here
                        } else {
                            BottomSheetContent(onAddClick = { category ->
                                viewModel.setSelectedCategory(category)
                                viewModel.setShowSecondBottomSheet(true)
                                viewModel.setShowBottomSheetContent(false)
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
                                        .border(
                                            width = 2.dp,
                                            color = PurpleSavvy2,
                                            shape = CircleShape
                                        )
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
                                    viewModel.setShowSecondBottomSheet(false)
                                    viewModel.setShowTransactionSheet(false)
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
                                val transaksiForThisKategori = transaksiList.filter { it.namaKategori == kategori.nama && it.namaAnggaran == anggaran.nama }
                                Log.d("DetailScreen", "Transactions for ${kategori.nama}: $transaksiForThisKategori")
                                val totalJumlahForThisKategori = transaksiForThisKategori.sumByDouble { it.jumlah }
                                Log.d("DetailScreen", "Total amount for ${kategori.nama}: $totalJumlahForThisKategori")
                                val scope = rememberCoroutineScope()
                                val showTransaksiBottomSheet = remember { mutableStateOf(false) }

                                if (kategori.namaAnggaran == anggaran.nama) {
                                    Detail_kategori_card(
                                        imageResource = kategori.imageResources,
                                        keterangan = kategori.nama,
                                        jumlah_saldo = totalJumlahForThisKategori.toString(),
                                        batas_anggaran = kategori.batas_anggaran ?: 0.0,
                                        onDelete = {
                                            val transaksiForThisKategori = transaksiList.filter { it.namaKategori == kategori.nama && it.namaAnggaran == anggaran.nama }
                                            viewModel.removeCategory(kategori, transaksiForThisKategori)
                                            anggaran.jumlah = (anggaran.jumlah ?: 0.0) + totalJumlahForThisKategori
                                            anggaranViewModel.updateAnggaran(anggaran)
                                        },
                                        onAddTransactionClick = {
                                            scope.launch {
                                                showTransaksiBottomSheet.value = true
                                            }
                                        },
                                        onCardClick = {
                                            navController.navigate("${Screen.riwayatAnggaran.route}/${kategori.nama}/${anggaran.nama}/${kategori.imageResources}/${totalJumlahForThisKategori}/${kategori.batas_anggaran ?: 0.0}")
                                        },
                                        jumlah = totalJumlahForThisKategori
                                    )
                                    if (showTransaksiBottomSheet.value) {
                                        TransaksiBottomSheet(
                                            onBackClick = {
                                                viewModel.setShowTransactionSheet(false)
                                                showTransaksiBottomSheet.value = false
                                            },
                                            navController = navController,
                                            namaAnggaran = anggaran.nama,
                                            namaKategori = kategori.nama,
                                            updateAnggaran = { updatedAmount ->
                                                anggaran.jumlah = (anggaran.jumlah ?: 0.0) - updatedAmount
                                                anggaranViewModel.updateAnggaran(anggaran)
                                            }
                                        )
                                    }
                                }
                            }
                        }
                    }
                }
            }
        } else {
            Text("Anggaran tidak ditemukan", color = Color.Red)
        }
    }

    @Composable
    fun BottomSheetContent(
        onAddClick: (String) -> Unit, // Ubah signature fungsi untuk hanya mengirimkan nama kategori
    ) {
        val context = LocalContext.current
        val kategoriAnggaranDao = AppDatabase.getInstance(context).kategoriAnggaranDao()

        val transaksiDao = AppDatabase.getInstance(context).transaksiDao()
        val viewModel: DetailScreenViewModel = viewModel(
            factory = DetailScreenViewModelFactory(kategoriAnggaranDao, transaksiDao)
        )
        val kategoriAnggaranList by viewModel.categories.collectAsState()

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
                            .shadow(
                                elevation = 4.dp,
                                shape = RoundedCornerShape(10.dp),
                                clip = false
                            )
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
                    IconButton(onClick = {
                        onAddClick(kategori.nama) // Hanya kirimkan nama kategori
                    }) {
                        Icon(Icons.Default.AddCircle, contentDescription = "", tint = OrangeSavvy)
                    }
                }
            }
        }
    }



    @OptIn(ExperimentalMaterial3Api::class)
    @Composable
    fun SecondBottomSheetContent(
        selectedCategory: String,
        anggaran: String,
        imageResources: Int,
        onBackClick: () -> Unit,
        onAddCategory: (String, String, String) -> Unit,
    ) {
        val context = LocalContext.current
        val kategoriAnggaranDao = AppDatabase.getInstance(context).kategoriAnggaranDao()
        val transaksiDao = AppDatabase.getInstance(context).transaksiDao()
        val viewModel: DetailScreenViewModel = viewModel(
            factory = DetailScreenViewModelFactory(kategoriAnggaranDao, transaksiDao)
        )
        val textJumlah by viewModel.textJumlah.collectAsState()

        val selectedKategori = KategoriAnggaranData.kategoriList.firstOrNull(){ it.nama == selectedCategory }
        Log.d("SecondBottomSheetContent", "SelectedKategori: $selectedKategori")

        LaunchedEffect(selectedCategory) {
            viewModel.updateSelectedCategory(selectedCategory)
        }

        Column {
            if (selectedKategori != null) {
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
                    Row(verticalAlignment = Alignment.CenterVertically) {
                        Box(
                            modifier = Modifier
                                .size(50.dp)
                                .shadow(
                                    elevation = 4.dp,
                                    shape = RoundedCornerShape(10.dp),
                                    clip = false
                                )
                                .background(Color.White, shape = RoundedCornerShape(10.dp))
                                .border(
                                    width = 1.dp,
                                    color = Color.Transparent,
                                    shape = RoundedCornerShape(10.dp)
                                )
                                .padding(5.dp)
                        ) {
                            Image(
                                painterResource(id = imageResources),
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
            } else {
                Text(
                    text = "Kategori tidak ditemukan",
                    color = Color.Red,
                    modifier = Modifier.padding(16.dp)
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
                    value = textJumlah,
                    onValueChange = { newText ->
                        val formattedText = formatNumberWithCommas(newText)
                        viewModel.updateTextJumlah(formattedText)
                    },
                    label = { Text(text = "") },
                    modifier = Modifier
                        .fillMaxWidth()
                        .offset(y = (-8).dp),
                    colors = TextFieldDefaults.textFieldColors(containerColor = Color.White),
                    textStyle = TextStyle(
                        color = PurpleSavvy1,
                        fontFamily = poppinsFontFamily
                    ),
                    keyboardOptions = KeyboardOptions.Default.copy(
                        imeAction = ImeAction.Done,
                        keyboardType = KeyboardType.Number
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
                        Log.d("DetailScreenViewModel", "Button clicked")
                        selectedKategori?.let { kategori ->
                            viewModel.addCategory(
                                onAddCategory,
                                kategori.id,
                                kategori.imageResources,
                                anggaran,
                                context
                            )
                        } ?: Log.d("DetailScreenViewModel", "selectedKategori is null")
                        Log.d("DetailScreenViewModel", "Log after null check")
                    },
                    shape = RoundedCornerShape(5.dp),
                    colors = ButtonDefaults.buttonColors(containerColor = Color(0xffeb7f63)),
                    modifier = Modifier
                        .requiredWidth(width = 140.dp)
                        .requiredHeight(height = 35.dp)
                ) {
                    Text(
                        text = "Tambah",
                        style = Typography.bodyMedium,
                        color = Color.White
                    )
                }
                Button(
                    onClick = { viewModel.resetTextJumlah() },
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
    @OptIn(ExperimentalMaterial3Api::class)
    @Composable
    fun TransaksiBottomSheet(
        onBackClick: () -> Unit,
        navController: NavController,
        namaAnggaran: String,
        namaKategori: String,
        updateAnggaran: (Double) -> Unit,
    ) {
        val context = LocalContext.current
        val kategoriAnggaranDao = AppDatabase.getInstance(context).kategoriAnggaranDao()
        val transaksiDao = AppDatabase.getInstance(context).transaksiDao()
        val viewModel: DetailScreenViewModel = viewModel(
            factory = DetailScreenViewModelFactory(kategoriAnggaranDao, transaksiDao)
        )
        val anggaranDao = AppDatabase.getInstance(context).anggaranDao()
        val anggaranViewModel: AnggaranViewModel = viewModel(
            factory = AnggaranViewModelFactory(anggaranDao, kategoriAnggaranDao)
        )
        val anggaranList by anggaranViewModel.anggaranList.observeAsState(emptyList())
        val anggaran = anggaranList.find { it.nama == namaAnggaran }
        val textNama by viewModel.textNama.collectAsState()
        val textJumlah by viewModel.textJumlah.collectAsState()
        val selectedDate by viewModel.selectedDate.collectAsState()

        // Observe transactions LiveData
        Log.d("anggran transaksi", "TransaksiBottomSheet anggarn:$anggaran ")

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
                        text = selectedDate,
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
                            viewModel.updateSelectedDate("$dayOfMonth/${month + 1}/$year")
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
                    value = textNama,
                    onValueChange = { newText ->
                        viewModel.updateTextNama(newText)
                    },
                    label = { Text(text = "") },
                    modifier = Modifier
                        .fillMaxWidth()
                        .offset(y = (-8).dp),
                    colors = TextFieldDefaults.textFieldColors(containerColor = WhiteSavvy),
                    textStyle = TextStyle(color = PurpleSavvy1, fontFamily = poppinsFontFamily),
                    keyboardOptions = KeyboardOptions.Default.copy(imeAction = ImeAction.Done)
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
                    value = textJumlah,
                    onValueChange = { newText ->
                        val formattedText = formatNumberWithCommas(newText)
                        viewModel.updateTextJumlah(formattedText)
                    },
                    label = { Text(text = "") },
                    modifier = Modifier
                        .fillMaxWidth()
                        .offset(y = (-8).dp),
                    colors = TextFieldDefaults.textFieldColors(containerColor = WhiteSavvy),
                    textStyle = TextStyle(
                        color = PurpleSavvy1,
                        fontFamily = poppinsFontFamily
                    ),
                    keyboardOptions = KeyboardOptions.Default.copy(
                        imeAction = ImeAction.Done,
                        keyboardType = KeyboardType.Number
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
                        viewModel.addTransaction(
                            { nama, jumlah, tanggal, kategori, anggaran ->
                                // Handle transaction addition callback if needed
                            },
                            namaKategori,
                            anggaran?.nama ?: "",
                            updateAnggaran,
                            context
                        )
                    },
                    shape = RoundedCornerShape(5.dp),
                    colors = ButtonDefaults.buttonColors(containerColor = Color(0xffeb7f63)),
                    modifier = Modifier
                        .requiredWidth(width = 140.dp)
                        .requiredHeight(height = 35.dp)
                ) {
                    Text(
                        text = "Tambah",
                        style = Typography.bodyMedium,
                        color = Color.White
                    )
                }
                Button(
                    onClick = { viewModel.resetFields() },
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