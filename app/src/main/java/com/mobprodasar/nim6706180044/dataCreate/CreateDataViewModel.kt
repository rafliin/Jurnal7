package com.mobprodasar.nim6706180044.dataCreate

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import com.mobprodasar.nim6706180044.database.DataDAO
import com.mobprodasar.nim6706180044.database.DataMasukan
import kotlinx.coroutines.*

class CreateDataViewModel(val database: DataDAO, val data: DataMasukan, application: Application): AndroidViewModel(application){
    private var viewModelJob = Job()
    private var uiScope = CoroutineScope(Dispatchers.Main + viewModelJob)

    override fun onCleared() {
        super.onCleared()
        viewModelJob.cancel()
    }
    fun onSave(){
        uiScope.launch {
            insert(data)
        }
    }

    private suspend fun insert(data: DataMasukan) {
        withContext(Dispatchers.IO) {
            database.insert(data)
        }
    }
}