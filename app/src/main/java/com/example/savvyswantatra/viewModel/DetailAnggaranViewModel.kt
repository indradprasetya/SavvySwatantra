package com.example.savvyswantatra.viewModel

import android.content.Context
import android.util.Log
import android.widget.Toast
import androidx.lifecycle.*
import com.example.savvyswantatra.component.KategoriAnggaranData
import com.example.savvyswantatra.dao.AnggaranDao
import com.example.savvyswantatra.dao.KategoriAnggaranDao
import com.example.savvyswantatra.dao.TransaksiDao
import com.example.savvyswantatra.model.KategoriAnggaran
import com.example.savvyswantatra.model.Transaksi
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class DetailScreenViewModelFactory(
    private val kategoriAnggaranDao: KategoriAnggaranDao,
    private val transaksiDao: TransaksiDao
) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(DetailScreenViewModel::class.java)) {
            @Suppress("UNCHECKED_CAST")
            return DetailScreenViewModel(kategoriAnggaranDao, transaksiDao) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}

class DetailScreenViewModel(
    private val kategoriAnggaranDao: KategoriAnggaranDao,
    private val transaksiDao: TransaksiDao
) : ViewModel() {

    private val _showBottomSheetContent = MutableStateFlow(false)
    val showBottomSheetContent: StateFlow<Boolean> = _showBottomSheetContent

    private val _showSecondBottomSheet = MutableStateFlow(false)
    val showSecondBottomSheet: StateFlow<Boolean> = _showSecondBottomSheet

    private val _selectedCategory = MutableStateFlow("")
    val selectedCategory: StateFlow<String> = _selectedCategory

    private val _showTransactionSheet = MutableStateFlow(false)
    val showTransactionSheet: StateFlow<Boolean> = _showTransactionSheet

    private val _categories = MutableStateFlow<List<KategoriAnggaran>>(emptyList())
    val categories: StateFlow<List<KategoriAnggaran>> = _categories

    // Use LiveData for transactions
    val transactions: LiveData<List<Transaksi>> = transaksiDao.getAll()
    private val _filteredTransactions = MutableStateFlow<List<Transaksi>>(emptyList())
    val filteredTransactions: StateFlow<List<Transaksi>> = _filteredTransactions

    private val _textNama = MutableStateFlow("")
    val textNama: StateFlow<String> = _textNama

    private val _textJumlah = MutableStateFlow("")
    val textJumlah: StateFlow<String> = _textJumlah

    private val _selectedDate = MutableStateFlow("")
    val selectedDate: StateFlow<String> = _selectedDate

    init {
        loadCategories()
    }

    private fun loadCategories() {
        kategoriAnggaranDao.getAll().observeForever { kategoriList ->
            _categories.value = kategoriList
        }
    }

    fun setShowBottomSheetContent(value: Boolean) {
        viewModelScope.launch {
            _showBottomSheetContent.emit(value)
        }
    }

    fun setShowSecondBottomSheet(value: Boolean) {
        viewModelScope.launch {
            _showSecondBottomSheet.emit(value)
        }
    }

    fun setSelectedCategory(value: String) {
        viewModelScope.launch {
            _selectedCategory.emit(value)
        }
    }

    fun setShowTransactionSheet(value: Boolean) {
        viewModelScope.launch {
            _showTransactionSheet.emit(value)
        }
    }

    fun updateSelectedCategory(category: String) {
        viewModelScope.launch {
            _selectedCategory.emit(category)
        }
    }

    private val _addedCategories = MutableStateFlow<List<KategoriAnggaran>>(emptyList())
    val addedCategories: StateFlow<List<KategoriAnggaran>> = _addedCategories

    // Function to add category
    fun addCategory(category: KategoriAnggaran) {
        _addedCategories.value += category
    }

    fun removeCategory(category: KategoriAnggaran, transactions: List<Transaksi>) {
        viewModelScope.launch {
            kategoriAnggaranDao.delete(category)
            transactions.forEach { transaksi ->
                transaksiDao.delete(transaksi)
            }
            _categories.value = _categories.value.filter { it.id != category.id }
        }
    }

    fun updateTextJumlah(jumlah: String) {
        viewModelScope.launch {
            _textJumlah.emit(jumlah)
        }
    }

    fun resetTextJumlah() {
        viewModelScope.launch {
            _textJumlah.emit("")
        }
    }

    fun addCategory(
        onAddCategory: (String, String, String) -> Unit,
        id: Int,
        imageResources: Int,
        anggaran: String,
        context: Context
    ) {
        viewModelScope.launch {
            try {
                val rawValue = _textJumlah.value.replace(",", "")
                if (rawValue.isEmpty()) {
                    Toast.makeText(context, "Jumlah saldo tidak boleh kosong", Toast.LENGTH_SHORT).show()
                    return@launch
                }

                val jumlah = rawValue.toDoubleOrNull()
                if (jumlah == null) {
                    Toast.makeText(context, "Jumlah saldo harus berupa angka", Toast.LENGTH_SHORT).show()
                    return@launch
                }

                val selectedCategoryName = _selectedCategory.value
                if (selectedCategoryName == null) {
                    Log.d("DetailScreenViewModel", "Selected category name is null")
                    Toast.makeText(context, "Kategori tidak ditemukan", Toast.LENGTH_SHORT).show()
                    return@launch
                }

                Log.d("DetailScreenViewModel", "Selected category name: $selectedCategoryName")
                Log.d("DetailScreenViewModel", "Jumlah: $jumlah, Anggaran: $anggaran")

                val selectedKategori = KategoriAnggaranData.kategoriList.firstOrNull { it.nama == selectedCategoryName }
                if (selectedKategori == null) {
                    Log.d("DetailScreenViewModel", "Selected category not found in kategoriList")
                    Toast.makeText(context, "Kategori tidak ditemukan", Toast.LENGTH_SHORT).show()
                    return@launch
                }

                Log.d("DetailScreenViewModel", "Selected Kategori: $selectedKategori")

                onAddCategory(selectedCategoryName, jumlah.toString(), anggaran)

                val kategori = KategoriAnggaran(
                    nama = selectedCategoryName,
                    imageResources = imageResources,
                    batas_anggaran = jumlah,
                    namaAnggaran = anggaran
                )

                Log.d("DetailScreenViewModel", "Kategori to insert: $kategori")

                // Insert the category into the database
                kategoriAnggaranDao.insert(kategori)

                // Clear the text field after insertion
                _textJumlah.emit("")

                Log.d("DetailScreenViewModel", "Category added successfully")
            } catch (e: Exception) {
                Log.e("DetailScreenViewModel", "Error adding category: ${e.message}", e)
                Toast.makeText(context, "Terjadi kesalahan saat menambah kategori", Toast.LENGTH_SHORT).show()
            }
        }
    }

    fun updateTextNama(nama: String) {
        viewModelScope.launch {
            _textNama.emit(nama)
        }
    }

    fun updateSelectedDate(date: String) {
        viewModelScope.launch {
            _selectedDate.emit(date)
        }
    }

    fun resetFields() {
        viewModelScope.launch {
            _textNama.emit("")
            _textJumlah.emit("")
            _selectedDate.emit("")
        }
    }

    fun addTransaction(
        onAddTransaction: (String, Double, String, String, String) -> Unit,
        namaKategori: String,
        namaAnggaran: String,
        updateAnggaran: (Double) -> Unit,
        context: Context
    ) {
        viewModelScope.launch {
            val rawValue = _textJumlah.value.replace(",", "")
            if (_textNama.value.isBlank()) {
                Toast.makeText(context, "Nama anggaran tidak boleh kosong", Toast.LENGTH_SHORT).show()
            } else if (_selectedDate.value.isBlank()) {
                Toast.makeText(context, "Tanggal harus diisi", Toast.LENGTH_SHORT).show()
            } else {
                val jumlah = rawValue.toDoubleOrNull()
                if (jumlah == null) {
                    Toast.makeText(context, "Jumlah saldo harus berupa angka", Toast.LENGTH_SHORT).show()
                } else {
                    val transaksi = Transaksi(
                        nama = _textNama.value,
                        jumlah = jumlah,
                        tanggal = _selectedDate.value,
                        namaKategori = namaKategori,
                        namaAnggaran = namaAnggaran
                    )

                    transaksiDao.insert(transaksi)
                    println("Transaction inserted: $transaksi")

                    onAddTransaction(_textNama.value, jumlah, _selectedDate.value, namaKategori, namaAnggaran)
                    updateAnggaran(jumlah)
                    // No need to call fetchTransactions because we are using LiveData
                    resetFields()
                }
            }
        }
    }
}

