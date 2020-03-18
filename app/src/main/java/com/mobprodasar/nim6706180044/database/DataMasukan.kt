package com.mobprodasar.nim6706180044.database

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "teks_orang")
data class DataMasukan (
    @PrimaryKey(autoGenerate = true)

    @ColumnInfo(name = "teks_id")
    var teksId: Long = 0L,
    @ColumnInfo(name = "teks_nama")
    var teks: String = ""
)