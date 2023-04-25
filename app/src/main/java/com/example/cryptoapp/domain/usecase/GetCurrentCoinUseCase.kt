package com.example.cryptoapp.domain.usecase


import com.example.cryptoapp.domain.model.DomainData
import com.example.cryptoapp.domain.repository.GetCoinsRepository

class GetCurrentCoinUseCase(private val repository: GetCoinsRepository) {

    suspend operator fun invoke() : List<DomainData> {
      return repository.getCoins().Data
    }
}
