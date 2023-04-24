package com.example.cryptoapp.presentation.adapter

import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import com.example.cryptoapp.data.model.CoinsModel
import com.example.cryptoapp.data.model.Data
import com.example.cryptoapp.data.repository.GetCoinsRepository
import com.example.cryptoapp.data.repository.GetCoinsRepositoryImpl
import com.example.cryptoapp.databinding.CryptoCardBinding
import kotlin.math.log

class CryptoAdapter() : ListAdapter<Data, CryptoViewHolder>(CryptoItemDiffCallback()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CryptoViewHolder {
        val itemBinding = CryptoCardBinding.inflate(LayoutInflater.from(parent.context))
        return CryptoViewHolder(binding = itemBinding)
    }

    override fun onBindViewHolder(holder: CryptoViewHolder, position: Int) {
        val bin = holder.binding
        val currentItem = getItem(position)

        with(bin) {
            cryptoLabel.text = currentItem.CoinInfo.FullName
            myLog(bin.tvCryptoTitle.text.toString())
            tvUsd.text = currentItem.DISPLAY.USD.PRICE
        }


    }

    private fun myLog(msg: String) {
        Log.d("myLog", "myLog: $msg")
    }
}