package com.example.savvyswantatra.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Delete
import androidx.room.OnConflictStrategy
import androidx.room.Update
import com.example.savvyswantatra.model.Anggaran
import com.example.savvyswantatra.model.KategoriAnggaran
import com.example.savvyswantatra.model.Transaksi

@Dao
interface AnggaranDao {
    @Query("SELECT * FROM tb_anggaran")
    fun getAll(): LiveData<List<Anggaran>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(anggaran: Anggaran)

    @Delete
    suspend fun delete(anggaran: Anggaran)

    @Update
    suspend fun update(anggaran: Anggaran)
}

@Dao
interface KategoriAnggaranDao {
    @Query("SELECT * FROM tb_kategori_anggaran")
    fun getAll(): LiveData<List<KategoriAnggaran>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(kategoriAnggaran: KategoriAnggaran)

    @Delete
    suspend fun delete(kategoriAnggaran: KategoriAnggaran)

    @Query("SELECT COUNT(*) FROM tb_kategori_anggaran")
    suspend fun count(): Int

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAll(vararg kategori: KategoriAnggaran)
}


@Dao
interface TransaksiDao {
    @Query("SELECT * FROM tb_transaksi")
    fun getAll(): LiveData<List<Transaksi>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(transaksi: Transaksi)

    @Delete
    suspend fun delete(transaksi: Transaksi)

}
