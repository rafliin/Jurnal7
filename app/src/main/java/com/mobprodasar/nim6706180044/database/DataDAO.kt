package com.mobprodasar.nim6706180044.database

import androidx.lifecycle.LiveData
import androidx.room.*

interface DataDAO {

    @Insert
    fun insert(allData: DataMasukan)

    @Update
    fun update(allData: DataMasukan)

    @Query("SELECT * FROM teks_orang WHERE teks_id = :key")
    fun get(key: Long): DataMasukan

    @Query("DELETE FROM teks_orang")
    fun delete()

    @Query("SELECT * FROM teks_orang ORDER BY teks_id DESC")
    fun getData(): LiveData<List<DataMasukan>>

    @Query("SELECT * FROM teks_orang ORDER BY teks_id DESC LIMIT 1")
    fun getAA(): DataMasukan?
}