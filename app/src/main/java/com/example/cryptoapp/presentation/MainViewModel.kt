package com.example.cryptoapp.presentation

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.cryptoapp.data.model.Data
import com.example.cryptoapp.data.repository.GetCoinsRepository
import com.example.cryptoapp.data.repository.GetCoinsRepositoryImpl
import kotlinx.coroutines.launch

class MainViewModel : ViewModel() {

    private val getCoinsRepository: GetCoinsRepository = GetCoinsRepositoryImpl()

    private val _liveData = MutableLiveData<List<Data>>()
    val liveData: LiveData<List<Data>>
        get() = _liveData

    init {
        getCoinModel()
    }

    private fun getCoinModel() {
        viewModelScope.launch {
            val coins = getCoinsRepository.getCoins()
            _liveData.postValue(getCoinsRepository.getCurrentCoin(coins))
        }
    }
}