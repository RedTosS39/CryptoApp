package com.example.cryptoapp.presentation.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.cryptoapp.domain.model.DomainData
import com.example.cryptoapp.domain.usecase.GetCurrentCoinUseCase
import kotlinx.coroutines.launch
import javax.inject.Inject


class MainViewModel @Inject constructor(
    private val getCurrentCoinUseCase: GetCurrentCoinUseCase,
) : ViewModel() {

    private var _coinInfoList = MutableLiveData<List<DomainData>>()
    val coinInfoList: LiveData<List<DomainData>>
        get() = _coinInfoList

    init {
        viewModelScope.launch {
            _coinInfoList.value = getCurrentCoinUseCase.invoke().value
        }
    }
}