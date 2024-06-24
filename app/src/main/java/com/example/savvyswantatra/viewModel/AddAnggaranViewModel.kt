package com.example.savvyswantatra.viewModel

import androidx.compose.runtime.MutableState
import androidx.lifecycle.ViewModel
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableIntStateOf
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import com.example.savvyswantatra.R
import com.example.savvyswantatra.model.Anggaran
import com.example.savvyswantatra.component.AnggaranData
import com.example.savvyswantatra.component.Image
import com.example.savvyswantatra.dao.AnggaranDao
import com.example.savvyswantatra.formatNumberWithCommas
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

//tambahAnggaran view model
class AddAnggaranViewModelFactory(
    private val anggaranDao: AnggaranDao
) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(AddAnggaranViewModel::class.java)) {
            @Suppress("UNCHECKED_CAST")
            return AddAnggaranViewModel(anggaranDao) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}
class AddAnggaranViewModel(private val anggaranDao: AnggaranDao) : ViewModel() {
    private val _textNama = mutableStateOf("")
    val textNama: State<String> = _textNama

    private val _textJumlah = mutableStateOf("")
    val textJumlah: State<String> = _textJumlah

    private val _selectedImage = mutableIntStateOf(0)
    val selectedImage: MutableState<Int> = _selectedImage

    fun onNamaChange(newText: String) {
        _textNama.value = newText
    }

    fun onJumlahChange(newText: String) {
        val formattedText = formatNumberWithCommas(newText)
        _textJumlah.value = formattedText
    }

    fun onSelectedImageChange(newImageIndex: Int) {
        _selectedImage.value = newImageIndex
    }

    fun tambahAnggaran(): Boolean {
        val jumlah = _textJumlah.value.replace(",", "").toDoubleOrNull()
        return if (_textNama.value.isBlank() || jumlah == null) {
            false
        } else {
            val imageResId = Image.bankList.getOrNull(_selectedImage.value) ?: R.drawable.ic_launcher_background
            val anggaran = Anggaran(
                nama = _textNama.value,
                jumlah = jumlah,
                imageResources = imageResId
            )
            viewModelScope.launch {
                anggaranDao.insert(anggaran)
            }
            true
        }
    }

    fun pulihkan() {
        _textNama.value = ""
        _textJumlah.value = ""
        _selectedImage.value = 0
    }
}

