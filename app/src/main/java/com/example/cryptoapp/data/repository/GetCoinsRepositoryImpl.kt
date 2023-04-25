package com.example.cryptoapp.data.repository

import com.example.cryptoapp.data.model.*
import com.example.cryptoapp.data.network.CryptoApiService
import com.example.cryptoapp.domain.model.*
import com.example.cryptoapp.domain.repository.GetCoinsRepository

class GetCoinsRepositoryImpl : GetCoinsRepository {

    private val mapper = CoinMapper()
    override suspend fun getCoins(): DomainCoinModel {
        return mapper.mapToDomainModel(getApiResult())
    }

    override suspend fun getDomainData(): List<DomainData> {
        return mapper.mapList(getApiResult().Data)
    }

    private suspend fun getApiResult(): CoinsModel {
        return CryptoApiService.create().getCoins()
    }
}