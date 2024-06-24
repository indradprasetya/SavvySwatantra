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
data class Anggaran( val nama: String, var jumlah: Double, val imageResources: Int)
object AnggaranData {
    val anggaranList = mutableStateListOf<Anggaran>()
}
data class KategoriAnggaran(val id: Int, val nama: String, val imageResources: Int, val batas_anggaran: Double?, val namaAnggaran: String?)
object KategoriAnggaranData{
    val kategoriList = mutableListOf(
        KategoriAnggaran(
            id = 1,
            nama = "Makanan dan Minuman",
            imageResources = R.drawable.makan,
            batas_anggaran = null,
            namaAnggaran = null
        ),
        KategoriAnggaran(
            id = 2,
            nama = "Belanja",
            imageResources = R.drawable.belanja,
            batas_anggaran = null,
            namaAnggaran = null
        ),
        KategoriAnggaran(
            id = 3,
            nama = "Kesehatan",
            imageResources = R.drawable.kesehatan,
            batas_anggaran = null,
            namaAnggaran = null
        ),
        KategoriAnggaran(
            id = 4,
            nama = "Travel",
            imageResources = R.drawable.travel,
            batas_anggaran = null,
            namaAnggaran = null
        ),
    )
}
val months = listOf(
    "Januari",
    "Februari", "Maret"
    , "April", "Mei"
    , "Juni", "Juli"
    , "Agustus"
    , "September", "Oktober"
    , "November", "Desember"
)

data class Transaksi(
    val nama: String,
    val jumlah: Double,
    val tanggal: String,
    val namaKategori: String,
    val namaAnggaran: String?
)
object TransaksiData{
    val transaksiList = mutableStateListOf<Transaksi>()
}