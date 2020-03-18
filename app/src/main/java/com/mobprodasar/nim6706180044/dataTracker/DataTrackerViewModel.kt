package com.mobprodasar.nim6706180044.dataTracker

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import com.mobprodasar.nim6706180044.database.DataDAO
import com.mobprodasar.nim6706180044.database.DataMasukan
import kotlinx.coroutines.*

class DataTrackerViewModel(val database: DataDAO, application: Application): AndroidViewModel(application) {
    private var viewModelJob = Job()
    private val dataData = MutableLiveData<DataMasukan?>()
    private val uiScope = CoroutineScope(Dispatchers.Main + viewModelJob)

    override fun onCleared() {
        super.onCleared()
        viewModelJob.cancel()
    }

    fun onSaved() {
        uiScope.launch {
            insert(alldata = DataMasukan())
        }
    }

    private suspend fun insert(alldata: DataMasukan){
        withContext(Dispatchers.IO){
            database.insert(alldata)
        }
    }

    private suspend fun update(alldata: DataMasukan){
        withContext(Dispatchers.IO){
            database.update(alldata)
        }
    }

    fun onDelete(){
        uiScope.launch {
            delete()
            dataData.value = null
        }
    }

    private suspend fun delete(){
        withContext(Dispatchers.IO){
            database.delete()
        }
    }

    suspend fun clear() {
        withContext(Dispatchers.IO) {
            database.delete()
        }
    }
}