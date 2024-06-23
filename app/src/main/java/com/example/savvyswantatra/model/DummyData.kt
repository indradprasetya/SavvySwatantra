package com.example.savvyswantatra.model

import com.example.savvyswantatra.R
import com.example.savvyswantatra.model.KalenderData
import androidx.compose.runtime.mutableStateListOf
import java.time.LocalDate

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

object DummyDataMingguan {
    val TanggalList = listOf(
        mingguanData(
            date = LocalDate.of(2024, 5, 16),
            id = 1,
            image = R.drawable.makan,
            icon = R.drawable.pengeluaran,
            kategori = "Makanan dan Minuman",
            deskripsi = "Makan Warteg",
            harga = 10000,
            total = "99.000"
        ),
        mingguanData(
            date = LocalDate.of(2024, 5, 16),
            id = 2,
            image = R.drawable.kesehatanicon,
            icon = R.drawable.pengeluaran,
            kategori = "Kesehatan",
            deskripsi = "Panadol",
            harga = 15000,
            total = "99.000"
        ),
        mingguanData(
            date = LocalDate.of(2024, 5, 17),
            id = 3,
            image = R.drawable.income,
            icon = R.drawable.pemasukan,
            kategori = "Mandiri",
            deskripsi = "Transfer dari sepuh alfred",
            harga = 12000,
            total = "99.000"

        ),
        mingguanData(
            date = LocalDate.of(2024, 5, 17),
            id = 4,
            image = R.drawable.income,
            icon = R.drawable.pemasukan,
            kategori = "Mandiri",
            deskripsi = "Thr dari paman",
            harga = 12000,
            total = "99.000"

        ),
        mingguanData(
            date = LocalDate.of(2024, 5, 17),
            id = 5,
            image = R.drawable.income,
            icon = R.drawable.pemasukan,
            kategori = "Mandiri",
            deskripsi = "Thr dari paman",
            harga = 12000,
            total = "99.000"
        ),

    )
}


