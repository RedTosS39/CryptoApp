package com.example.cryptoapp.domain.repository


import com.example.cryptoapp.domain.model.DomainCoinModel
import com.example.cryptoapp.domain.model.DomainData

interface GetCoinsRepository {

    suspend fun getCoins(): DomainCoinModel

    suspend fun getDomainData() : List<DomainData>
}