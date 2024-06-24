//import androidx.lifecycle.*
//import com.example.savvyswantatra.model.KategoriAnggaran
//import com.example.savvyswantatra.dao.KategoriAnggaranDao
//import kotlinx.coroutines.flow.MutableStateFlow
//import kotlinx.coroutines.flow.StateFlow
//import kotlinx.coroutines.flow.asStateFlow
//
//class BottomSheetViewModelFactory(private val kategoriAnggaranDao: KategoriAnggaranDao) : ViewModelProvider.Factory {
//    override fun <T : ViewModel> create(modelClass: Class<T>): T {
//        if (modelClass.isAssignableFrom(BottomSheetViewModel::class.java)) {
//            @Suppress("UNCHECKED_CAST")
//            return BottomSheetViewModel(kategoriAnggaranDao) as T
//        }
//        throw IllegalArgumentException("Unknown ViewModel class")
//    }
//}
//
//class BottomSheetViewModel(private val kategoriAnggaranDao: KategoriAnggaranDao) : ViewModel() {
//    private val _categories = MutableStateFlow<List<KategoriAnggaran>>(emptyList())
//    val categories: StateFlow<List<KategoriAnggaran>> = _categories.asStateFlow()
//
//    init {
//        loadCategories()
//    }
//
//    private fun loadCategories() {
//        kategoriAnggaranDao.getAll().observeForever { kategoriList ->
//            _categories.value = kategoriList
//        }
//    }
//}
