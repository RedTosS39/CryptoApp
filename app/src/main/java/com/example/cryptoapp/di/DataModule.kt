package com.example.cryptoapp.di

import com.example.cryptoapp.data.network.CryptoApiService
import com.example.cryptoapp.data.repository.RepositoryImpl
import com.example.cryptoapp.domain.repository.Repository
import dagger.Binds
import dagger.Module

@Module
interface DataModule {

    @AppScope
    @Binds
    fun bindsRepository(repositoryImpl: RepositoryImpl): Repository
}