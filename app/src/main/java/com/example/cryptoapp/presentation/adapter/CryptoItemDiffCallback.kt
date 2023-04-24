package com.example.cryptoapp.presentation.adapter

import androidx.recyclerview.widget.DiffUtil
import com.example.cryptoapp.data.model.CoinsModel
import com.example.cryptoapp.data.model.Data

class CryptoItemDiffCallback: DiffUtil.ItemCallback<Data>() {
    override fun areItemsTheSame(oldItem: Data, newItem: Data): Boolean {
        return oldItem.CoinInfo.FullName == newItem.CoinInfo.FullName
    }

    override fun areContentsTheSame(oldItem: Data, newItem: Data): Boolean {
       return oldItem == newItem
    }

}