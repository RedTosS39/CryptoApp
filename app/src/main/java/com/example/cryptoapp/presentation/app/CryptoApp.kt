package com.example.cryptoapp.presentation.app

import android.app.Application
import androidx.work.Configuration
import com.example.cryptoapp.data.model.CoinMapper
import com.example.cryptoapp.data.network.CryptoApiService
import com.example.cryptoapp.data.workers.RefreshDataWorker
import com.example.cryptoapp.data.workers.RefreshDataWorkerFactory
import com.example.cryptoapp.di.components.DaggerAppComponent
import com.example.cryptoapp.di.qualifiers.ReleaseQualifier
import javax.inject.Inject

class CryptoApp : Application(), Configuration.Provider {

    @Inject
    lateinit var getWorkerFactory: RefreshDataWorkerFactory

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