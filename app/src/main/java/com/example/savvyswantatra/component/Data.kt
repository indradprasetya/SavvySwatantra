package com.example.savvyswantatra.component

import androidx.compose.runtime.mutableStateListOf
import com.example.savvyswantatra.R

object Image {
    val bankList = listOf(
        R.drawable.cash,
        R.drawable.bca,
        R.drawable.mandiri,
        R.drawable.bni,
        R.drawable.bri,
        R.drawable.ovo,
        R.drawable.gopay,
        R.drawable.shopee,
        R.drawable.dana
    )

}
data class Anggaran(val nama: String, val jumlah: Double, val imageResources: Int)
object AnggaranData {
    val anggaranList = mutableStateListOf<Anggaran>()
}

data class KategoriAnggaran(val id: Int, val nama: String,val imageResources: Int)
object KategoriAnggaranData{
    val kategoriList = listOf(
        KategoriAnggaran(
            id = 1,
            nama = "Makanan dan Minuman",
            imageResources = R.drawable.makan,
        ),
        KategoriAnggaran(
            id = 2,
            nama = "Belanja",
            imageResources = R.drawable.belanja,
        ),
        KategoriAnggaran(
            id = 3,
            nama = "Kesehatan",
            imageResources = R.drawable.kesehatan,
        ),
        KategoriAnggaran(
            id = 4,
            nama = "Travel",
           imageResources = R.drawable.travel
        ),
    )
}