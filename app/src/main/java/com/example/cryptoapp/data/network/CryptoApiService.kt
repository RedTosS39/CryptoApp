package com.example.cryptoapp.data.network

import com.example.cryptoapp.constants.Constants.API_CRYPTO_KEY
import com.example.cryptoapp.data.model.CoinsModel
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query


interface CryptoApiService {

    //Get cat list
    @GET("data/top/mktcapfull")
    suspend fun getCoins(
        @Query("limit") limit: Int = 20,
        @Query("tsym") usd: String = "USD",
        @Query("api_key") api_key: String = API_CRYPTO_KEY) : CoinsModel

    companion object  {

        private const val BASE_URL = "https://min-api.cryptocompare.com/"

        fun create() : CryptoApiService {

            val retrofit = Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl(BASE_URL)
                .build()
            return retrofit.create(CryptoApiService::class.java)

        }
    }
}