package com.example.cryptoapp.data.workers

import android.content.Context
import androidx.work.*
import com.example.cryptoapp.data.model.CoinMapper
import com.example.cryptoapp.data.network.CryptoApiService
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import javax.inject.Inject

class RefreshDataWorker @Inject constructor(
    context: Context,
    workerParams: WorkerParameters,
    private val apiService: CryptoApiService
) : CoroutineWorker(context, workerParams) {

    private val mapper = CoinMapper()
//    private val apiService = CryptoApiService.create()

    override suspend fun doWork(): Result {
        while (true) {
            try {
                val list = apiService.getCoins().Data
                mapper.mapList(list)
            } catch (_: Exception) { }
            delay(10000)
        }
    }

    companion object {
        const val WORKER_NAME = "RefreshDataWorker"

        fun makeRequest(): OneTimeWorkRequest {
            val constraints = Constraints.Builder()
                .setRequiredNetworkType(NetworkType.CONNECTED)
                .build()

            return OneTimeWorkRequestBuilder<RefreshDataWorker>()
                .setConstraints(constraints)
                .build()
        }
    }
}