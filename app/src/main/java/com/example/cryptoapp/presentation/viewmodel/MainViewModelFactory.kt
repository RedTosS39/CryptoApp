package com.example.cryptoapp.presentation.viewmodel

import android.app.Application
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.cryptoapp.domain.usecase.GetCurrentCoinUseCase
import javax.inject.Inject

class MainViewModelFactory @Inject constructor(
    val application: Application,
    private val getCurrentCoinUseCase: GetCurrentCoinUseCase,
) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if(modelClass == MainViewModel::class.java) {
            return MainViewModel(application, getCurrentCoinUseCase) as T
        }
        else throw RuntimeException("Unknown ViewModel::class $modelClass")
    }
}