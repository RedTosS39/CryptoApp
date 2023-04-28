package com.example.cryptoapp.domain.usecase


import android.util.Log
import androidx.lifecycle.LiveData
import com.example.cryptoapp.domain.model.DomainData
import com.example.cryptoapp.domain.repository.Repository

class GetCurrentCoinUseCase(private val repository: Repository) {

     operator fun invoke(): LiveData<List<DomainData>> {

        return repository.getDomainData()
    }
}
