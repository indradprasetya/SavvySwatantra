package com.example.savvyswantatra.component

import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
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


object AkunData {
    data class Akun(val id: Int, val nama: String, val imageResources: Int)

    val akunList = mutableListOf(
        Akun(
            id = 1,
            nama = "Tunai",
            imageResources = R.drawable.cash
        ),
        Akun(
            id = 2,
            nama = "BCA",
            imageResources = R.drawable.bca
        ),
        Akun(
            id = 3,
            nama = "Bank Mandiri",
            imageResources = R.drawable.mandiri
        ),
        Akun(
            id = 4,
            nama = "BNI",
            imageResources = R.drawable.bni
        ),
        Akun(
            id = 5,
            nama = "BRI",
            imageResources = R.drawable.bri
        ),
        Akun(
            id = 6,
            nama = "OVO",
            imageResources = R.drawable.ovo
        ),
        Akun(
            id = 7,
            nama = "GoPay",
            imageResources = R.drawable.gopay
        ),
        Akun(
            id = 8,
            nama = "ShopeePay",
            imageResources = R.drawable.shopee
        ),
        Akun(
            id = 9,
            nama = "DANA",
            imageResources = R.drawable.dana
        )
    )
}

object KeterangaTransaksi  {
    data class ket(val id: Int, val nama: String, val imageResources: Int)

    val ketlist = mutableStateOf(
        listOf(
            ket(
                id = 1,
                nama = "Pengeluaran",
                imageResources = R.drawable.panahatas,

            ),
            ket(
                id = 2,
                nama = "Pemasukan",
                imageResources = R.drawable.panahbawah

            )

        )

    )
}

// Data class untuk representasi transaksi
// Data class untuk representasi transaksi
//MONTHLY KALENDER BARU
data class TransaksiBulanan(
    val bulan: String,
    val tanggal: String,
    val kategori: String,
    val catatan: String,
    val jumlah: Int,
    //val image : int,
    //val
)

// List bulan-bulan dalam satu tahun
val monthNames = listOf(
    "Januari", "Februari", "Maret", "April", "Mei", "Juni",
    "Juli", "Agustus", "September", "Oktober", "November", "Desember"
)

// Contoh data transaksi untuk setiap bulan (dummy data)
val TransaksibulananData = mapOf(
    "Juni" to listOf(
        TransaksiBulanan("Juni", "01", "Makanan & Minuman", "Nasi Ayam", 22000),
        TransaksiBulanan("Juni", "02", "Mandiri", "Transfer dari Alfred", 10000),
        // tambahkan transaksi untuk bulan Juni sesuai kebutuhan
    ),
    "Juli" to listOf(
        TransaksiBulanan("$monthNames", "01", "Kesehatan", "Panadol", 10000),
        TransaksiBulanan("$monthNames", "02", "Mandiri", "THR dari paman", 12000),
        // tambahkan transaksi untuk bulan Juli sesuai kebutuhan
    ),
    "Agustus" to listOf(
        TransaksiBulanan("$monthNames", "01", "Makanan & Minuman", "Bakso", 15000),
        TransaksiBulanan("$monthNames", "02", "Transportasi", "Bensin", 50000),
        // tambahkan transaksi untuk bulan Agustus sesuai kebutuhan
    ),
    // tambahkan data untuk bulan-bulan lainnya seperti September, Oktober, November, dst.
)


fun getEndDateOfMonth(month: String): String {
    return when (month) {
        "Januari", "Maret", "Mei", "Juli", "Agustus", "Oktober", "Desember" -> "31"
        "Februari" -> "28" // Assuming non-leap year for simplicity
        "April", "Juni", "September", "November" -> "30"
        else -> "" // Handle other cases if needed
    }
}
fun getMonthIndex(month: String): String {
    return when (month) {
        "Januari" -> "01"
        "Februari" -> "02"
        "Maret" -> "03"
        "April" -> "04"
        "Mei" -> "05"
        "Juni" -> "06"
        "Juli" -> "07"
        "Agustus" -> "08"
        "September" -> "09"
        "Oktober" -> "10"
        "November" -> "11"
        "Desember" -> "12"
        else -> ""
    }
}
