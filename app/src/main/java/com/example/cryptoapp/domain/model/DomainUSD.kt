package com.example.cryptoapp.domain.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class DomainUSD(
    val PRICE: String,
) : Parcelable