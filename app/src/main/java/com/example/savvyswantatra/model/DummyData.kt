package com.example.savvyswantatra.model

import com.example.savvyswantatra.R
import com.example.savvyswantatra.model.KalenderData
import androidx.compose.runtime.mutableStateListOf
import java.time.LocalDate

object DummyData {
    val KalenderList = listOf(
        KalenderData(
            dateDataHarian = LocalDate.of(2024, 5, 16),
            image = R.drawable.makan,
            icon = R.drawable.pengeluaran,
            kategori = "Makanan dan Minuman",
            deskripsi = "Makan Warteg",
            harga = 10000
        ),
        KalenderData(
            dateDataHarian = LocalDate.of(2024, 5, 16),
            image = R.drawable.kesehatanicon,
            icon = R.drawable.pengeluaran,
            kategori = "Kesehatan",
            deskripsi = "Panadol",
            harga = 15000
        ),
        KalenderData(
            dateDataHarian = LocalDate.of(2024, 5, 16),
            image = R.drawable.income,
            icon = R.drawable.pemasukan,
            kategori = "Mandiri",
            deskripsi = "Transfer dari sepuh alfred",
            harga = 12000
        ),
        KalenderData(
            dateDataHarian = LocalDate.of(2024, 5, 16),
            image = R.drawable.income,
            icon = R.drawable.pemasukan,
            kategori = "Mandiri",
            deskripsi = "Thr dari paman",
            harga = 12000
        )
    )
}

object DummyDataMingguan {
    val TanggalList = listOf(
        mingguanData(
            dateDataMingguan = LocalDate.of(2024, 5, 16),
            image = R.drawable.makan,
            icon = R.drawable.pengeluaran,
            kategori = "Makanan dan Minuman",
            deskripsi = "Makan Warteg",
            harga = 10000
        ),
        mingguanData(
            dateDataMingguan = LocalDate.of(2024, 5, 16),
            image = R.drawable.income,
            icon = R.drawable.pemasukan,
            kategori = "Mandiri",
            deskripsi = "Transfer dari sepuh alfred",
            harga = 12000

        ),
        mingguanData(
            dateDataMingguan = LocalDate.of(2024, 5, 16),
            image = R.drawable.kesehatanicon,
            icon = R.drawable.pengeluaran,
            kategori = "Kesehatan",
            deskripsi = "Panadol",
            harga = 15000
        ),
        mingguanData(
            dateDataMingguan = LocalDate.of(2024, 5, 17),
            image = R.drawable.kesehatanicon,
            icon = R.drawable.pengeluaran,
            kategori = "Kesehatan",
            deskripsi = "Panadol",
            harga = 15000
        ),
        mingguanData(
            dateDataMingguan = LocalDate.of(2024, 5, 17),
            image = R.drawable.income,
            icon = R.drawable.pemasukan,
            kategori = "Mandiri",
            deskripsi = "Transfer dari sepuh indra",
            harga = 12000

        ),
        mingguanData(
            dateDataMingguan = LocalDate.of(2024, 5, 17),
            image = R.drawable.income,
            icon = R.drawable.pemasukan,
            kategori = "Mandiri",
            deskripsi = "Thr dari paman",
            harga = 12000

        ),
        mingguanData(
            dateDataMingguan = LocalDate.of(2024, 5, 17),
            image = R.drawable.income,
            icon = R.drawable.pemasukan,
            kategori = "Mandiri",
            deskripsi = "Thr dari paman",
            harga = 12000
        ),

    )
}


