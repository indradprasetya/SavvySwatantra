package com.example.savvyswantatra.data

import com.example.savvyswantatra.R
import com.example.savvyswantatra.model.TransaksiKalender

object DummyData {
    val Transaksi = listOf(
        TransaksiKalender(
            id = 1,
            picture = R.drawable.makan,
            name = "Makanan & Minuman",
            category = "Makan Warteg",
            price = "Rp10,000"
        ),
        TransaksiKalender(
            id = 2,
            picture = R.drawable.mandiri,
            name = "Mandiri",
            category = "Transfer dari Alfred",
            price = "Rp15,000"
        )
    )
}