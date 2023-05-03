package com.example.cryptoapp.presentation.di

import android.app.Application
import android.content.Context
import com.example.cryptoapp.data.model.CoinMapper
import dagger.Module
import dagger.Provides

@Module
class AppModule {

    @Provides
    fun provideApplication(application: Application) : Application {
        return application
    }

    @Provides
    fun provideMapper() : CoinMapper {
        return CoinMapper()
    }
}