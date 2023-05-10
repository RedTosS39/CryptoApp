package com.example.cryptoapp.presentation.app

import android.app.Application
import androidx.work.Configuration
import com.example.cryptoapp.data.workers.WorkerFactory
import com.example.cryptoapp.di.components.DaggerAppComponent
import javax.inject.Inject

class CryptoApp : Application(), Configuration.Provider {

    @Inject
    lateinit var getWorkerFactory: WorkerFactory

    val component by lazy {
        DaggerAppComponent.factory().create(this)
    }

    override fun onCreate() {
        component.inject(this)
        super.onCreate()
    }

    override fun getWorkManagerConfiguration(): Configuration {
        return Configuration.Builder().setWorkerFactory(
            getWorkerFactory
        ).build()
    }
}