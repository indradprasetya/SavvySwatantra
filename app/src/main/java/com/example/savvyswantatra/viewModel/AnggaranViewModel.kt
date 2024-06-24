package com.example.savvyswantatra.viewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import com.example.savvyswantatra.model.Anggaran
import com.example.savvyswantatra.dao.AnggaranDao
import com.example.savvyswantatra.dao.KategoriAnggaranDao
import com.example.savvyswantatra.model.KategoriAnggaran
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

//anggaran view model
class AnggaranViewModelFactory(private val anggaranDao: AnggaranDao, private val kategoriAnggaranDao: KategoriAnggaranDao) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(AnggaranViewModel::class.java)) {
            @Suppress("UNCHECKED_CAST")
            return AnggaranViewModel(anggaranDao,kategoriAnggaranDao) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}

class AnggaranViewModel(private val anggaranDao: AnggaranDao, private val kategoriAnggaranDao: KategoriAnggaranDao) : ViewModel() {

    val anggaranList: LiveData<List<Anggaran>> = anggaranDao.getAll()

    fun updateAnggaran(anggaran: Anggaran) {
        viewModelScope.launch {
            anggaranDao.update(anggaran)
        }
    }

    fun removeAnggaran(anggaran: Anggaran) {
        viewModelScope.launch {
            anggaranDao.delete(anggaran)
        }
    }
    private val _categories = MutableStateFlow<List<KategoriAnggaran>>(emptyList())
    val categories: StateFlow<List<KategoriAnggaran>> = _categories.asStateFlow()

    init {
        loadCategories()
    }

    private fun loadCategories() {
        kategoriAnggaranDao.getAll().observeForever { kategoriList ->
            _categories.value = kategoriList
        }
    }
}