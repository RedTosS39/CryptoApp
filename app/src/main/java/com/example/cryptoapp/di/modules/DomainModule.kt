package com.example.cryptoapp.di.modules

import com.example.cryptoapp.di.qualifiers.AppScope
import com.example.cryptoapp.domain.repository.Repository
import com.example.cryptoapp.domain.usecase.GetCurrentCoinUseCase
import dagger.Module
import dagger.Provides

@Module
class DomainModule {

    @AppScope
    @Provides
    fun provideUseCase(repository: Repository): GetCurrentCoinUseCase {
        return GetCurrentCoinUseCase(repository)
    }
}