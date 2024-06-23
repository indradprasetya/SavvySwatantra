package com.example.savvyswantatra.component

import androidx.compose.runtime.mutableStateListOf
import com.example.savvyswantatra.R
import com.example.savvyswantatra.model.KalenderData


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
data class KategoriAnggaran(val id: Int, val nama: String, val imageResources: Int, val batas_anggaran: Double?)
object KategoriAnggaranData{
    val kategoriList = mutableListOf(
        KategoriAnggaran(
            id = 1,
            nama = "Makanan dan Minuman",
            imageResources = R.drawable.makan,
            batas_anggaran = null
        ),
        KategoriAnggaran(
            id = 2,
            nama = "Belanja",
            imageResources = R.drawable.belanja,
            batas_anggaran = null
        ),
        KategoriAnggaran(
            id = 3,
            nama = "Kesehatan",
            imageResources = R.drawable.kesehatan,
            batas_anggaran = null
        ),
        KategoriAnggaran(
            id = 4,
            nama = "Travel",
           imageResources = R.drawable.travel,
            batas_anggaran = null
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
    val tanggal: String
)
object TransaksiData{
    val transaksiList = mutableStateListOf<Transaksi>()
}

object DummyData {
    val KalenderList = listOf(
        KalenderData(
            id = 1,
            image = R.drawable.makan,
            icon = R.drawable.pengeluaran,
            kategori = "Makanan dan Minuman",
            deskripsi = "Makan Warteg",
            harga = "Rp10,000"
        ),
        KalenderData(
            id = 2,
            image = R.drawable.kesehatanicon,
            icon = R.drawable.pengeluaran,
            kategori = "Kesehatan",
            deskripsi = "Panadol",
            harga = "Rp15,000"
        ),
        KalenderData(
            id = 3,
            image = R.drawable.income,
            icon = R.drawable.pemasukan,
            kategori = "Mandiri",
            deskripsi = "Transfer dari sepuh alfred",
            harga = "Rp12,000"
        ),
        KalenderData(
            id = 4,
            image = R.drawable.income,
            icon = R.drawable.pemasukan,
            kategori = "Mandiri",
            deskripsi = "Thr dari paman",
            harga = "Rp12,000"
        ),
        KalenderData(
            id = 5,
            image = R.drawable.income,
            icon = R.drawable.pemasukan,
            kategori = "Mandiri",
            deskripsi = "Thr dari paman",
            harga = "Rp12,000"
        ),
        KalenderData(
            id = 6,
            image = R.drawable.income,
            icon = R.drawable.pemasukan,
            kategori = "Mandiri",
            deskripsi = "Thr dari paman",
            harga = "Rp12,000"
        ),
        KalenderData(
            id = 7,
            image = R.drawable.income,
            icon = R.drawable.pemasukan,
            kategori = "Mandiri",
            deskripsi = "Thr dari paman",
            harga = "Rp12,000"
        )
    )
}

