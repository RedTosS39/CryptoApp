package com.example.cryptoapp.di.components

import android.app.Application
import com.example.cryptoapp.di.modules.DataModule
import com.example.cryptoapp.di.modules.DomainModule
import com.example.cryptoapp.di.qualifiers.AppScope
import dagger.BindsInstance
import dagger.Component


@AppScope
@Component(modules = [
    DataModule::class,
    DomainModule::class
])
interface AppComponent {

    fun activityComponentFactory() : ActivityComponent.Factory

    @Component.Factory
    interface AppComponentFactory {

        fun create(
            @BindsInstance application: Application
        ) : AppComponent
    }
}