package com.example.cryptoapp.data.workers

import android.content.Context
import androidx.work.ListenableWorker
import androidx.work.WorkerFactory
import androidx.work.WorkerParameters
import com.example.cryptoapp.data.model.CoinMapper
import com.example.cryptoapp.data.network.CryptoApiService
import com.example.cryptoapp.di.qualifiers.ReleaseQualifier
import javax.inject.Inject

class RefreshDataWorkerFactory @Inject constructor(
    @ReleaseQualifier private val apiService: CryptoApiService,
    private val mapper: CoinMapper
) : WorkerFactory() {
    override fun createWorker(
        appContext: Context,
        workerClassName: String,
        workerParameters: WorkerParameters,
    ): ListenableWorker? {
        return RefreshDataWorker(appContext, workerParameters, apiService, mapper)
    }
}