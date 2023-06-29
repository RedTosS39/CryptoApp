package com.example.cryptoapp.domain.usecase


import androidx.lifecycle.LiveData
import com.example.cryptoapp.domain.model.DomainData
import com.example.cryptoapp.domain.repository.Repository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class GetCurrentCoinUseCase @Inject constructor(private val repository: Repository) {

    suspend fun getList() : List<DomainData>? {
        return repository.getDomainData().value
    }
}
