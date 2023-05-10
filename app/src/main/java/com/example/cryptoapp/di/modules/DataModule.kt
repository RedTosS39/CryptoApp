package com.example.cryptoapp.di.modules

import com.example.cryptoapp.constants.Constants
import com.example.cryptoapp.data.network.CryptoApiService
import com.example.cryptoapp.data.repository.RepositoryImpl
import com.example.cryptoapp.di.qualifiers.AppScope
import com.example.cryptoapp.di.qualifiers.ReleaseQualifier
import com.example.cryptoapp.di.qualifiers.TestQualifier
import com.example.cryptoapp.domain.repository.Repository
import dagger.Binds
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

@Module
interface DataModule {

    @AppScope
    @Binds
    fun bindsRepository(repositoryImpl: RepositoryImpl): Repository

    companion object {

        @AppScope
        @Provides
        @ReleaseQualifier
        fun provideApiService(): CryptoApiService {

            val retrofit = Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl(Constants.BASE_URL)
                .build()
            return retrofit.create(CryptoApiService::class.java)
        }

        @AppScope
        @TestQualifier
        @Provides
        fun provideTestApiService() : CryptoApiService {
            val retrofit = Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl("BASE_URL")
                .build()
            return retrofit.create(CryptoApiService::class.java)
        }
    }
}