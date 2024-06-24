package com.example.savvyswantatra.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "tb_anggaran")

data class Anggaran(
    @PrimaryKey(autoGenerate = true) val id: Long = 0L,
    @ColumnInfo(name = "nama") val nama: String,
    @ColumnInfo(name = "jumlah") var jumlah: Double,
    @ColumnInfo(name = "imageResources") var imageResources: Int
)

@Entity(tableName = "tb_kategori_anggaran")
data class KategoriAnggaran(
    @PrimaryKey (autoGenerate = true) val id: Int = 0,
    @ColumnInfo(name = "nama")val nama: String,
    @ColumnInfo(name = "imageResources")val imageResources: Int,
    @ColumnInfo(name = "batas_anggaran")val batas_anggaran: Double?,
    @ColumnInfo(name = "namaAnggaran")val namaAnggaran: String?
)


@Entity(tableName = "tb_transaksi")
data class Transaksi(
    @PrimaryKey(autoGenerate = true) val id: Long = 0L,
    @ColumnInfo(name = "nama")val nama: String,
    @ColumnInfo(name = "jumlah") val jumlah: Double,
    @ColumnInfo(name = "tanggal")val tanggal: String,
    @ColumnInfo(name = "namaKategori")val namaKategori: String,
    @ColumnInfo(name = "namaAnggaran")val namaAnggaran: String?
)
