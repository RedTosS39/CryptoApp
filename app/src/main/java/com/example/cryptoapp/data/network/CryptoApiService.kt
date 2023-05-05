package com.example.cryptoapp.data.network

import com.example.cryptoapp.constants.Constants.API_CRYPTO_KEY
import com.example.cryptoapp.data.model.CoinsModel
import com.example.cryptoapp.di.qualifiers.ReleaseQualifier
import com.example.cryptoapp.di.qualifiers.TestQualifier
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query
import javax.inject.Inject


interface CryptoApiService {

    @ReleaseQualifier
    @GET("data/top/mktcapfull")
    suspend fun getCoins(
        @Query("limit") limit: Int = 20,
        @Query("tsym") usd: String = "USD",
        @Query("api_key") api_key: String = API_CRYPTO_KEY) : CoinsModel
}