package com.example.cryptoapp.data.model


import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class CoinInfo(
    val FullName: String,
    val Id: String,
    val ImageUrl: String,
    val Name: String,
    val Url: String
) : Parcelable