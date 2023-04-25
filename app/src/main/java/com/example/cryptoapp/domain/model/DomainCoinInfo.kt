package com.example.cryptoapp.domain.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class DomainCoinInfo(
    val FullName: String,
    val Id: String,
    val ImageUrl: String,
    val Name: String,
    val Url: String,
) : Parcelable
