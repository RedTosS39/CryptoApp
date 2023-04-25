package com.example.cryptoapp.domain.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class DomainDisplay(
    val usd: DomainUSD
) :Parcelable