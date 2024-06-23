package com.example.savvyswantatra.database

import android.content.Context
import android.util.Log
import androidx.annotation.RestrictTo
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.sqlite.db.SupportSQLiteDatabase
import com.example.savvyswantatra.R
import com.example.savvyswantatra.model.Anggaran
import com.example.savvyswantatra.dao.AnggaranDao
import com.example.savvyswantatra.dao.KategoriAnggaranDao
import com.example.savvyswantatra.dao.TransaksiDao
import com.example.savvyswantatra.model.KategoriAnggaran
import com.example.savvyswantatra.model.Transaksi
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import org.json.JSONArray
import org.json.JSONException
import org.json.JSONObject
import java.io.BufferedReader
import java.io.IOException
import java.io.InputStreamReader


@Database(entities =[Anggaran::class,KategoriAnggaran::class,Transaksi::class], version = 5)
abstract class AppDatabase : RoomDatabase() {
    abstract fun anggaranDao(): AnggaranDao
    abstract fun kategoriAnggaranDao(): KategoriAnggaranDao
    abstract fun transaksiDao(): TransaksiDao

    companion object {
        @Volatile
        private var INSTANCE: AppDatabase? = null

        fun getInstance(context: Context): AppDatabase {
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    AppDatabase::class.java,
                    "tb_kategori_anggaran"
                ) .addCallback(object : RoomDatabase.Callback() {
                    override fun onCreate(db: SupportSQLiteDatabase) {
                        super.onCreate(db)
                        CoroutineScope(Dispatchers.IO).launch {
                            Log.d("Database", "running fillWithStartingData")
                            fillWithStartingData(context, getInstance(context).kategoriAnggaranDao())
                        }
                    }
                }).fallbackToDestructiveMigration()
                    .build()
                INSTANCE = instance
                instance
            }
        }


        private fun loadJsonArray(context: Context): JSONArray? {
            val builder = StringBuilder()
            val `in` = context.resources.openRawResource(R.raw.kategori_anggaran)
            val reader = BufferedReader(InputStreamReader(`in`))
            var line: String?
            try {
                while (reader.readLine().also { line = it } != null) {
                    builder.append(line)
                }
                val json = JSONObject(builder.toString())
                return json.getJSONArray("kategori_anggaran")
            } catch (exception: IOException) {
                exception.printStackTrace()
                Log.d("Database", "Error reading JSON file")
            } catch (exception: JSONException) {
                exception.printStackTrace()
                Log.d("Database", "Error parsing JSON file")
            }
            return null
        }

        private fun fillWithStartingData(context: Context, dao: KategoriAnggaranDao) {
            val kategoriAnggaran = loadJsonArray(context)
            try {
                Log.d("Database", "Inserting starting data")
                if (kategoriAnggaran != null) {
                    for (i in 0 until kategoriAnggaran.length()) {
                        val item = kategoriAnggaran.getJSONObject(i)
                        val resourceName = item.getString("drawableResource").substringAfter("R.drawable.")
                        val drawableResourceId = context.resources.getIdentifier(resourceName, "drawable", context.packageName)
                        dao.insertAll(
                            KategoriAnggaran(
                                id = item.getInt("id"),
                                nama = item.getString("nama"),
                                imageResources = drawableResourceId,
                                batas_anggaran = item.optDouble("batas_anggaran", 0.0),
                                namaAnggaran = item.optString("namaAnggaran", null)
                            )
                        )
                    }
                }
                else{
                    Log.d("Database", "Data null")
                }
            } catch (exception: JSONException) {
                exception.printStackTrace()
                Log.d("Database", "Error parsing JSON file")
            }
        }
    }
}
