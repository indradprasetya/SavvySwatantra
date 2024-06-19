package com.example.savvyswantatra.model

data class KalenderData(
    val id : Int,
    val kategori : String,
    val image : Int,
    val icon : Int,
    val harga : String,
    val deskripsi : String
)

data class TanggalitemData(
    val date: String,
    val id : Int,
    val kategori : String,
    val image : Int,
    val icon : Int,
    val harga : String,
    val deskripsi : String
)