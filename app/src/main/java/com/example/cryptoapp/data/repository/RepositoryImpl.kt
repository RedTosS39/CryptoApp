package com.example.cryptoapp.data.repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.cryptoapp.data.model.CoinMapper
import com.example.cryptoapp.data.network.CryptoApiService
import com.example.cryptoapp.domain.model.DomainData
import com.example.cryptoapp.domain.repository.Repository

class RepositoryImpl : Repository {

    private val mapper = CoinMapper()
    private val liveData = MutableLiveData<List<DomainData>>()

    override suspend fun getDomainData(): LiveData<List<DomainData>> {
        getApiResult()
        return liveData
    }

    private suspend fun getApiResult() {
        val list = CryptoApiService.create().getCoins()
        liveData.value = mapper.mapList(list.Data)
    }
}