package com.example.cryptoapp.presentation.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.ListAdapter
import com.example.cryptoapp.databinding.CryptoCardBinding
import com.example.cryptoapp.domain.model.DomainData
import com.squareup.picasso.Picasso

class CryptoAdapter : ListAdapter<DomainData, CryptoViewHolder>(CryptoItemDiffCallback) {

    var onItemClickListener: ((DomainData) -> Unit)? = null


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CryptoViewHolder {
        val itemBinding = CryptoCardBinding.inflate(LayoutInflater.from(parent.context))
        return CryptoViewHolder(binding = itemBinding)
    }

    override fun onBindViewHolder(holder: CryptoViewHolder, position: Int) {
        val bin = holder.binding
        val currentItem = getItem(position)

        with(bin) {
            cryptoLabel.text = currentItem.domainCoinInfo.FullName
            tvUsd.text = currentItem.domainDISPLAY.usd.PRICE
            invoke(imgCryptoLogo, currentItem.domainCoinInfo.ImageUrl)

            root.setOnClickListener {
                onItemClickListener?.invoke(currentItem)
            }
        }
    }

    companion object {

        operator fun invoke(imageView: ImageView, imageUrl: String) {
            Picasso.get().load(imageUrl).into(imageView)
        }
    }
}