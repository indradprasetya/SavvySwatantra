package com.example.savvyswantatra.viewModel


import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import com.example.savvyswantatra.component.months
import com.example.savvyswantatra.dao.AnggaranDao
import com.example.savvyswantatra.dao.KategoriAnggaranDao
import com.example.savvyswantatra.dao.TransaksiDao
import com.example.savvyswantatra.model.Anggaran
import com.example.savvyswantatra.model.KategoriAnggaran
import com.example.savvyswantatra.model.Transaksi
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch


class RiwayatAnggaranViewModelFactory(
    private val anggaranDao: AnggaranDao,
    private val kategoriAnggaranDao: KategoriAnggaranDao,
    private val transaksiDao: TransaksiDao
) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(RiwayatAnggaranViewModel::class.java)) {
            @Suppress("UNCHECKED_CAST")
            return RiwayatAnggaranViewModel(anggaranDao, kategoriAnggaranDao, transaksiDao) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}



class RiwayatAnggaranViewModel(
    private val anggaranDao: AnggaranDao,
    private val kategoriAnggaranDao: KategoriAnggaranDao,
    private val transaksiDao: TransaksiDao
) : ViewModel() {

    private val _year = MutableStateFlow(2024)
    val year: StateFlow<Int> = _year

    private val _selectedMonth = MutableStateFlow("")
    val selectedMonth: StateFlow<String> = _selectedMonth

    private val _filteredTransactions = MutableStateFlow<List<Transaksi>>(emptyList())
    val filteredTransactions: StateFlow<List<Transaksi>> = _filteredTransactions

    val transaksiList: LiveData<List<Transaksi>> = transaksiDao.getAll()
    val anggaranList: LiveData<List<Anggaran>> = anggaranDao.getAll()

    var selectedCategory: String = ""
    var selectedBudget: String = ""

    init {
        transaksiList.observeForever { transactions ->
            filterTransactions(transactions)
        }
    }

    fun setYear(newYear: Int) {
        _year.value = newYear
        transaksiList.value?.let { filterTransactions(it) }
    }

    fun setSelectedMonth(newMonth: String) {
        _selectedMonth.value = newMonth
        transaksiList.value?.let { filterTransactions(it) }
    }

    private fun filterTransactions(transactions: List<Transaksi>) {
        viewModelScope.launch {
            val yearStr = _year.value.toString()
            val monthIndex = months.indexOf(_selectedMonth.value) + 1
            val filtered = transactions.filter { transaksi ->
                val transaksiDateParts = transaksi.tanggal.split("/")
                val transaksiYear = transaksiDateParts[2].toInt()
                val transaksiMonth = transaksiDateParts[1].toInt()

                val isCategoryMatch = transaksi.namaKategori == selectedCategory
                val isBudgetMatch = transaksi.namaAnggaran == selectedBudget
                val isYearMatch = transaksiYear == yearStr.toInt()
                val isMonthMatch = transaksiMonth == monthIndex

                isCategoryMatch && isBudgetMatch && isYearMatch && isMonthMatch
            }
            _filteredTransactions.value = filtered
            println("Filtered Transactions: ${filtered.size}")
        }
    }

    fun deleteTransaction(transaksi: Transaksi) {
        viewModelScope.launch {
            transaksiDao.delete(transaksi)
        }
    }
}
