package com.example.cryptoapp.domain.repository


import androidx.lifecycle.LiveData
import com.example.cryptoapp.domain.model.DomainData

interface Repository {
    suspend fun getDomainData() : LiveData<List<DomainData>>
}