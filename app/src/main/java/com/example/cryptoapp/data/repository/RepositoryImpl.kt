package com.example.cryptoapp.data.repository

import android.app.Application
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.work.ExistingWorkPolicy
import androidx.work.WorkManager
import com.example.cryptoapp.data.workers.RefreshDataWorker
import com.example.cryptoapp.domain.model.DomainData
import com.example.cryptoapp.domain.repository.Repository

class RepositoryImpl(private val application: Application) : Repository {


    private val liveData = MutableLiveData<List<DomainData>>()

    override fun getDomainData(): LiveData<List<DomainData>> {
        getApiResult()
        return liveData
    }

    private fun getApiResult() {
        val worker = WorkManager.getInstance(application)

        worker.enqueueUniqueWork(
            RefreshDataWorker.WORKER_NAME,
            ExistingWorkPolicy.REPLACE,
            RefreshDataWorker.makeRequest()
        )
    }
}