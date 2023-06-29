package com.example.cryptoapp.presentation.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.cryptoapp.domain.model.DomainData
import com.example.cryptoapp.domain.usecase.GetCurrentCoinUseCase
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch
import javax.inject.Inject


class MainViewModel @Inject constructor(
    private val getCurrentCoinUseCase: GetCurrentCoinUseCase,
) : ViewModel() {

    private var currentCoinList = listOf<DomainData>()
    private val _sharedFlow = MutableSharedFlow<List<DomainData>>(replay = 1)

    val sharedFlow = _sharedFlow.asSharedFlow()
        .onEach {
            currentCoinList = it
        }

    private fun setupFlow() {
        viewModelScope.launch {
            getCurrentCoinUseCase.getList()?.let { _sharedFlow.emit(it) }
        }
    }

    init {
        setupFlow()
    }
}