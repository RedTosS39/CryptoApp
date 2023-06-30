package com.example.cryptoapp.presentation.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.cryptoapp.domain.model.DomainData
import com.example.cryptoapp.domain.usecase.GetCurrentCoinUseCase
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch
import javax.inject.Inject


class MainViewModel @Inject constructor(
    private val getCurrentCoinUseCase: GetCurrentCoinUseCase,
) : ViewModel() {

    init {
        setupFlow()
    }

    private val _sharedFlow = MutableStateFlow(listOf<DomainData>())

    val sharedFlow = _sharedFlow.asStateFlow()
    private fun setupFlow() {
        viewModelScope.launch {
            getCurrentCoinUseCase.getList()?.let { _sharedFlow.emit(it) }
        }
    }
}