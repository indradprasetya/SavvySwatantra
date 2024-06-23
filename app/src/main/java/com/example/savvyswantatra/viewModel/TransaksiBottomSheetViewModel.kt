//package com.example.savvyswantatra.viewModel
//
//import android.content.Context
//import android.widget.Toast
//import androidx.lifecycle.LiveData
//import androidx.lifecycle.ViewModel
//import androidx.lifecycle.ViewModelProvider
//import androidx.lifecycle.viewModelScope
//import com.example.savvyswantatra.dao.KategoriAnggaranDao
//import com.example.savvyswantatra.dao.TransaksiDao
//import com.example.savvyswantatra.model.Transaksi
//import kotlinx.coroutines.flow.MutableStateFlow
//import kotlinx.coroutines.flow.StateFlow
//import kotlinx.coroutines.launch
//
//class TransaksiBottomSheetViewModelFactory(private val TransaksiDao: TransaksiDao) : ViewModelProvider.Factory {
//    override fun <T : ViewModel> create(modelClass: Class<T>): T {
//        if (modelClass.isAssignableFrom(TransaksiBottomSheetViewModel::class.java)) {
//            @Suppress("UNCHECKED_CAST")
//            return TransaksiBottomSheetViewModel(TransaksiDao) as T
//        }
//        throw IllegalArgumentException("Unknown ViewModel class")
//    }
//}
//class TransaksiBottomSheetViewModel(private val transaksiDao: TransaksiDao) : ViewModel() {
//    private val _textNama = MutableStateFlow("")
//    val textNama: StateFlow<String> = _textNama
//
//    private val _textJumlah = MutableStateFlow("")
//    val textJumlah: StateFlow<String> = _textJumlah
//
//    private val _selectedDate = MutableStateFlow("")
//    val selectedDate: StateFlow<String> = _selectedDate
//
//    val transactions: LiveData<List<Transaksi>> = transaksiDao.getAll()
//
//    fun updateTextNama(nama: String) {
//        viewModelScope.launch {
//            _textNama.emit(nama)
//        }
//    }
//
//    fun updateTextJumlah(jumlah: String) {
//        viewModelScope.launch {
//            _textJumlah.emit(jumlah)
//        }
//    }
//
//    fun updateSelectedDate(date: String) {
//        viewModelScope.launch {
//            _selectedDate.emit(date)
//        }
//    }
//
//    fun resetFields() {
//        viewModelScope.launch {
//            _textNama.emit("")
//            _textJumlah.emit("")
//            _selectedDate.emit("")
//        }
//    }
//
//    fun addTransaction(
//        onAddTransaction: (String, Double, String, String, String) -> Unit,
//        namaKategori: String,
//        namaAnggaran: String,
//        updateAnggaran: (Double) -> Unit,
//        context: Context
//    ) {
//        viewModelScope.launch {
//            val rawValue = _textJumlah.value.replace(",", "")
//            if (_textNama.value.isBlank()) {
//                Toast.makeText(context, "Nama anggaran tidak boleh kosong", Toast.LENGTH_SHORT).show()
//            } else if (_selectedDate.value.isBlank()) {
//                Toast.makeText(context, "Tanggal harus diisi", Toast.LENGTH_SHORT).show()
//            } else {
//                val jumlah = rawValue.toDoubleOrNull()
//                if (jumlah == null) {
//                    Toast.makeText(context, "Jumlah saldo harus berupa angka", Toast.LENGTH_SHORT).show()
//                } else {
//                    val transaksi = Transaksi(
//                        nama = _textNama.value,
//                        jumlah = jumlah,
//                        tanggal = _selectedDate.value,
//                        namaKategori = namaKategori,
//                        namaAnggaran = namaAnggaran
//                    )
//
//                    transaksiDao.insert(transaksi)
//
//                    onAddTransaction(_textNama.value, jumlah, _selectedDate.value, namaKategori, namaAnggaran)
//                    updateAnggaran(jumlah)
//                    resetFields()
//                }
//            }
//        }
//    }
//}
