package com.example.cryptoapp.data.workers

import android.content.Context
import androidx.work.ListenableWorker
import androidx.work.WorkerFactory
import androidx.work.WorkerParameters
import javax.inject.Inject
import javax.inject.Provider

class WorkerFactory @Inject constructor(

    private val workerProvider: @JvmSuppressWildcards
    Map<Class<out ListenableWorker>, Provider<ChildWorkerFactory>>,

    ) : WorkerFactory() {
    override fun createWorker(
        appContext: Context,
        workerClassName: String,
        workerParameters: WorkerParameters,
    ): ListenableWorker? {
        return when (workerClassName) {
            RefreshDataWorker::class.qualifiedName -> {
                val workerFactory = workerProvider[RefreshDataWorker::class.java]?.get()
                workerFactory?.create(context = appContext, workerParameters)
            }
            else -> {
                null
            }
        }
    }
}