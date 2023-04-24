package com.example.cryptoapp.data.repository

import com.example.cryptoapp.data.model.CoinsModel
import com.example.cryptoapp.data.model.Data
import com.example.cryptoapp.data.network.CryptoApiService

class GetCoinsRepositoryImpl : GetCoinsRepository {
    override suspend fun getCoins(): CoinsModel {
        return CryptoApiService.create().getCoins()
    }

    override suspend fun getCurrentCoin(coinsModel: CoinsModel) : List<Data> {
        return coinsModel.Data
    }

    override suspend fun getImgUrl(data: Data): String {
        return data.CoinInfo.ImageUrl
    }
}