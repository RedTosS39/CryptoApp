package com.example.cryptoapp.data.workers

import android.content.Context
import androidx.work.*
import com.example.cryptoapp.data.model.CoinMapper
import com.example.cryptoapp.data.network.CryptoApiService
import com.example.cryptoapp.di.qualifiers.ReleaseQualifier
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import javax.inject.Inject

class RefreshDataWorker(
    context: Context,
    workerParams: WorkerParameters,
    private val apiService: CryptoApiService,
    private val mapper: CoinMapper,
) : CoroutineWorker(context, workerParams) {

    override suspend fun doWork(): Result {
        while (true) {
            try {
                val list = apiService.getCoins().Data
                mapper.mapList(list)
            } catch (_: Exception) {
            }
            delay(1000)
        }
    }

    class Factory @Inject constructor(
        @ReleaseQualifier
        private val apiService: CryptoApiService,
        private val mapper: CoinMapper,
    ) : ChildWorkerFactory {
        override fun create(context: Context, workerParams: WorkerParameters): ListenableWorker {
            return RefreshDataWorker(context, workerParams, apiService, mapper)
        }
    }

    companion object {
        const val WORKER_NAME = "RefreshDataWorker"

        fun makeRequest(): OneTimeWorkRequest {
            val constraints =
                Constraints.Builder().setRequiredNetworkType(NetworkType.CONNECTED).build()

            return OneTimeWorkRequestBuilder<RefreshDataWorker>().setConstraints(constraints)
                .build()
        }
    }
}