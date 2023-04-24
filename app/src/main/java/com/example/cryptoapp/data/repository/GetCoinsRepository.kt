package com.example.cryptoapp.data.repository

import com.example.cryptoapp.data.model.CoinsModel
import com.example.cryptoapp.data.model.Data

interface GetCoinsRepository {

   suspend fun getCoins() : CoinsModel

   suspend fun getCurrentCoin(coinsModel: CoinsModel) : List<Data>
}