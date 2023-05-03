package com.example.cryptoapp.data.repository

import android.app.Application
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.work.ExistingWorkPolicy
import androidx.work.WorkManager
import com.example.cryptoapp.data.model.CoinMapper
import com.example.cryptoapp.data.network.CryptoApiService
import com.example.cryptoapp.data.workers.RefreshDataWorker
import com.example.cryptoapp.domain.model.DomainData
import com.example.cryptoapp.domain.repository.Repository
import javax.inject.Inject

class RepositoryImpl @Inject constructor(
    private val application: Application,
    private val mapper: CoinMapper,
) : Repository {

    private val apiService = CryptoApiService.create()
    private val liveData = MutableLiveData<List<DomainData>>()


    override suspend fun getDomainData(): LiveData<List<DomainData>> {
        getApiResult()
        return liveData
    }

    private suspend fun getApiResult() {
        try {
            val result = apiService.getCoins()
            liveData.value = mapper.mapList(result.Data)
        } catch (_: Exception) {
        }
    }

    override fun loadData() {
        val worker = WorkManager.getInstance(application)
        worker.enqueueUniqueWork(
            RefreshDataWorker.WORKER_NAME,
            ExistingWorkPolicy.REPLACE,
            RefreshDataWorker.makeRequest()
        )
    }
}