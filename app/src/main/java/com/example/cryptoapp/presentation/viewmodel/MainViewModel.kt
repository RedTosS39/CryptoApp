package com.example.cryptoapp.presentation.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.example.cryptoapp.data.repository.RepositoryImpl
import com.example.cryptoapp.domain.model.DomainData
import com.example.cryptoapp.domain.repository.Repository
import com.example.cryptoapp.domain.usecase.GetCurrentCoinUseCase
import kotlinx.coroutines.launch

class MainViewModel(application: Application) : AndroidViewModel(application) {

    private val repository: Repository = RepositoryImpl(application)
    private val getCurrentCoinUseCase = GetCurrentCoinUseCase(repository)

    private var _coinInfoList = MutableLiveData<List<DomainData>>()
    val coinInfoList: LiveData<List<DomainData>>
        get() = _coinInfoList

    init {
        viewModelScope.launch {
            _coinInfoList.value = getCurrentCoinUseCase.invoke().value
        }
    }
}