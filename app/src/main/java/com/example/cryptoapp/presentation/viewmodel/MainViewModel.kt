package com.example.cryptoapp.presentation.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.cryptoapp.data.model.Data
import com.example.cryptoapp.domain.repository.GetCoinsRepository
import com.example.cryptoapp.data.repository.GetCoinsRepositoryImpl
import com.example.cryptoapp.domain.model.DomainData
import com.example.cryptoapp.domain.usecase.GetCurrentCoinUseCase
import kotlinx.coroutines.launch

class MainViewModel : ViewModel() {

    private val getCoinsRepository: GetCoinsRepository = GetCoinsRepositoryImpl()
    private val getCurrentCoinUseCase = GetCurrentCoinUseCase(getCoinsRepository)
    private val _liveData = MutableLiveData<List<DomainData>>()
    val liveData: LiveData<List<DomainData>>
        get() = _liveData

    init {
        getCoinModel()
    }

    private fun getCoinModel() {
        viewModelScope.launch {
             val coins = getCurrentCoinUseCase.invoke()
            _liveData.postValue(coins)
        }
    }
}