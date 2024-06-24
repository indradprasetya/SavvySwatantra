package com.example.savvyswantatra.model
import java.time.LocalDate
data class KalenderData(
    val dateDataHarian: LocalDate,
    val kategori : String,
    val image : Int,
    val icon : Int,
    val harga : Int,
    val deskripsi : String
)

data class mingguanData(
    val dateDataMingguan: LocalDate,
    val kategori : String,
    val image : Int,
    val icon : Int,
    val harga : Int,
    val deskripsi : String,
)

data class ListItemData(
    val date: LocalDate,
    val name: String
)


