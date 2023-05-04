package com.example.cryptoapp

import android.app.Application
import com.example.cryptoapp.di.DaggerAppComponent

class CryptoApp : Application() {

    val component by lazy {
        DaggerAppComponent.factory().create(this)
    }
}