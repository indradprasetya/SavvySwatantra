package com.example.savvyswantatra.model
import java.time.LocalDate
data class KalenderData(
    val id : Int,
    val kategori : String,
    val image : Int,
    val icon : Int,
    val harga : String,
    val deskripsi : String
)

data class mingguanData(
    val date: LocalDate,
    val id : Int,
    val kategori : String,
    val image : Int,
    val icon : Int,
    val harga : Int,
    val deskripsi : String,
    val total: String
)

data class ListItemData(
    val date: LocalDate,
    val name: String
)


