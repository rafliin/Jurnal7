package com.mobprodasar.nim6706180044.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [DataMasukan::class], version = 1, exportSchema = false)
abstract class DataDatabase: RoomDatabase() {
    abstract val dataDAO : DataDAO

    companion object{
        @Volatile
        private var INSTANCE: DataDatabase? = null

        fun getInstance(context: Context) : DataDatabase {
            synchronized(this) {
                var instance = INSTANCE

                if (instance == null){
                    instance = Room.databaseBuilder(
                        context.applicationContext,
                        DataDatabase::class.java,
                        "data_history_database"
                    ).fallbackToDestructiveMigration()
                        .build()
                    INSTANCE = instance
                }
            return instance}
        }
    }
}

