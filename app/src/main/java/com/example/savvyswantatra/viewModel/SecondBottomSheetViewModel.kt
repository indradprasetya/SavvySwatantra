//import androidx.lifecycle.ViewModel
//import androidx.lifecycle.ViewModelProvider
//import androidx.lifecycle.viewModelScope
//import com.example.savvyswantatra.dao.KategoriAnggaranDao
//import com.example.savvyswantatra.model.KategoriAnggaran
//import kotlinx.coroutines.flow.MutableStateFlow
//import kotlinx.coroutines.flow.StateFlow
//import kotlinx.coroutines.launch
//import android.content.Context
//import android.widget.Toast
//
//class SecondBottomSheetViewModelFactory(private val kategoriAnggaranDao: KategoriAnggaranDao) : ViewModelProvider.Factory {
//    override fun <T : ViewModel> create(modelClass: Class<T>): T {
//        if (modelClass.isAssignableFrom(SecondBottomSheetViewModel::class.java)) {
//            @Suppress("UNCHECKED_CAST")
//            return SecondBottomSheetViewModel(kategoriAnggaranDao) as T
//        }
//        throw IllegalArgumentException("Unknown ViewModel class")
//    }
//}
//
//class SecondBottomSheetViewModel(private val kategoriAnggaranDao: KategoriAnggaranDao) : ViewModel() {
//    private val _selectedCategory = MutableStateFlow<String>("")
//    val selectedCategory: StateFlow<String> = _selectedCategory
//
//    private val _textJumlah = MutableStateFlow<String>("")
//    val textJumlah: StateFlow<String> = _textJumlah
//
//    private val _categories = MutableStateFlow<List<KategoriAnggaran>>(emptyList())
//    val categories: StateFlow<List<KategoriAnggaran>> = _categories
//
//    init {
//        loadCategories()
//    }
//
//    fun updateSelectedCategory(category: String) {
//        viewModelScope.launch {
//            _selectedCategory.emit(category)
//        }
//    }
//
//    fun updateTextJumlah(jumlah: String) {
//        viewModelScope.launch {
//            _textJumlah.emit(jumlah)
//        }
//    }
//
//    fun resetTextJumlah() {
//        viewModelScope.launch {
//            _textJumlah.emit("")
//        }
//    }
//
//    private fun loadCategories() {
//        viewModelScope.launch {
//            _categories.value = kategoriAnggaranDao.getAll().value ?: emptyList()
//        }
//    }
//
//    fun addCategory(onAddCategory: (String, String, String) -> Unit, id: Int, imageResources: Int, anggaran: String, context: Context) {
//        viewModelScope.launch {
//            val rawValue = _textJumlah.value.replace(",", "")
//            if (rawValue.isEmpty()) {
//                Toast.makeText(context, "Jumlah saldo tidak boleh kosong", Toast.LENGTH_SHORT).show()
//            } else {
//                val jumlah = rawValue.toDoubleOrNull()
//                if (jumlah == null) {
//                    Toast.makeText(context, "Jumlah saldo harus berupa angka", Toast.LENGTH_SHORT).show()
//                } else {
//                    val selectedCategory = _selectedCategory.value
//                    onAddCategory(selectedCategory, jumlah.toString(), anggaran)
//
//                    // Create KategoriAnggaran object
//                    val kategori = KategoriAnggaran(
//                        id = id,
//                        nama = selectedCategory,
//                        imageResources = imageResources,
//                        batas_anggaran = jumlah,
//                        namaAnggaran = anggaran
//                    )
//
//                    // Insert KategoriAnggaran object into the database
//                    kategoriAnggaranDao.insert(kategori)
//
//                    _textJumlah.emit("")
//                }
//            }
//        }
//    }
//}
//
