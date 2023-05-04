package com.example.cryptoapp.domain.usecase


import androidx.lifecycle.LiveData
import com.example.cryptoapp.domain.model.DomainData
import com.example.cryptoapp.domain.repository.Repository
import javax.inject.Inject

class GetCurrentCoinUseCase @Inject constructor(private val repository: Repository) {

    suspend operator fun invoke(): LiveData<List<DomainData>> {

        return repository.getDomainData()
    }
}
