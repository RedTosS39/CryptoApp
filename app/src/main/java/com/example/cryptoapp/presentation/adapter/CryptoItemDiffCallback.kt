package com.example.cryptoapp.presentation.adapter

import androidx.recyclerview.widget.DiffUtil
import com.example.cryptoapp.data.model.Data
import com.example.cryptoapp.domain.model.DomainData

class CryptoItemDiffCallback : DiffUtil.ItemCallback<DomainData>() {
    override fun areItemsTheSame(oldItem: DomainData, newItem: DomainData): Boolean {
        return oldItem.domainCoinInfo.FullName == newItem.domainCoinInfo.FullName
    }

    override fun areContentsTheSame(oldItem: DomainData, newItem: DomainData): Boolean {
        return oldItem == newItem
    }

}