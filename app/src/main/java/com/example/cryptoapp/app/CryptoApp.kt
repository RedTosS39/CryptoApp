package com.example.cryptoapp.app

import android.app.Application
import com.example.cryptoapp.di.components.DaggerAppComponent

class CryptoApp : Application() {

    val component by lazy {
        DaggerAppComponent.factory().create(this)
    }
}