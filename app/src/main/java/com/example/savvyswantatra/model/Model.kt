package com.example.savvyswantatra.model

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.savvyswantatra.component.KategoriAnggaran
import kotlinx.coroutines.launch

class DetailViewModel(private val savedStateHandle: SavedStateHandle) : ViewModel() {
    companion object {
        private const val KEY_CATEGORIES = "addedCategories"
    }

    private val _addedCategories = savedStateHandle.getLiveData(KEY_CATEGORIES, mutableListOf<KategoriAnggaran>())
    val addedCategories: MutableLiveData<MutableList<KategoriAnggaran>> = _addedCategories

    fun addCategory(category: KategoriAnggaran) {
        val currentList = _addedCategories.value ?: mutableListOf()
        currentList.add(category)
        _addedCategories.value = currentList
        savedStateHandle.set(KEY_CATEGORIES, currentList)
    }

    fun removeCategory(category: KategoriAnggaran) {
        val currentList = _addedCategories.value ?: mutableListOf()
        currentList.remove(category)
        _addedCategories.value = currentList
        savedStateHandle.set(KEY_CATEGORIES, currentList)
    }
}
