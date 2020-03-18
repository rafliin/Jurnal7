package com.mobprodasar.nim6706180044.dataTracker

import android.app.Application
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import com.mobprodasar.nim6706180044.database.DataDAO
import java.lang.IllegalArgumentException

class DataTrackerViewModelFactory(
    private val dataSource: DataDAO,
    private val application: Application): ViewModelProvider.Factory {
        @Suppress("unchecked_cast")
        override fun <T: ViewModel?> create(modelClass: Class<T>): T {
            if (modelClass.isAssignableFrom(DataTrackerViewModel::class.java)) {
                return DataTrackerViewModel(dataSource, application) as T
            }
        throw IllegalArgumentException("Unknown View Model Class")
        }
    }