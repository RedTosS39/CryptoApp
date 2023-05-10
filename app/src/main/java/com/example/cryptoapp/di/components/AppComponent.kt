package com.example.cryptoapp.di.components

import android.app.Application
import com.example.cryptoapp.di.modules.DataModule
import com.example.cryptoapp.di.modules.DomainModule
import com.example.cryptoapp.di.modules.ViewModelModule
import com.example.cryptoapp.di.modules.WorkerModule
import com.example.cryptoapp.di.qualifiers.AppScope
import com.example.cryptoapp.presentation.app.CryptoApp
import com.example.cryptoapp.presentation.view.CoinFragment
import com.example.cryptoapp.presentation.view.MainActivity
import dagger.BindsInstance
import dagger.Component


@AppScope
@Component(modules = [
    DataModule::class,
    DomainModule::class,
    WorkerModule::class,
    ViewModelModule::class
])
interface AppComponent {

    fun inject(activity: MainActivity)
    fun inject(coinFragment: CoinFragment)
    fun inject(application: CryptoApp)

    @Component.Factory
    interface AppComponentFactory {

        fun create(
            @BindsInstance application: Application,
        ): AppComponent
    }
}