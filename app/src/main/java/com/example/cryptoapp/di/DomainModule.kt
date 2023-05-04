package com.example.cryptoapp.di

import com.example.cryptoapp.domain.repository.Repository
import com.example.cryptoapp.domain.usecase.GetCurrentCoinUseCase
import dagger.Module
import dagger.Provides

@Module
class DomainModule {


    @Provides
    fun provideUseCase(repository: Repository): GetCurrentCoinUseCase {
        return GetCurrentCoinUseCase(repository)
    }
}