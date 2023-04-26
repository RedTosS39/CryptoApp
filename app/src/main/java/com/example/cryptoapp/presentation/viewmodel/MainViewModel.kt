package com.example.cryptoapp.presentation.viewmodel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.cryptoapp.domain.repository.Repository
import com.example.cryptoapp.data.repository.RepositoryImpl
import com.example.cryptoapp.domain.model.DomainData
import com.example.cryptoapp.domain.usecase.GetCurrentCoinUseCase
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class MainViewModel : ViewModel() {

    private val repository: Repository = RepositoryImpl()
    private val getCurrentCoinUseCase = GetCurrentCoinUseCase(repository)

    private var _coinInfoList = MutableLiveData<List<DomainData>>()
    val coinInfoList: LiveData<List<DomainData>>
        get() = _coinInfoList

    init {
        viewModelScope.launch {
            while (true) {
                _coinInfoList.value = getCurrentCoinUseCase.invoke().value
                delay(10000)
            }
        }
    }
}