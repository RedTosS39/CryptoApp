package com.example.cryptoapp.data.model


import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class CoinInfo(
    val Algorithm: String,
    val AssetLaunchDate: String,
    val BlockNumber: Int,
    val BlockReward: Double,
    val BlockTime: Double,
    val DocumentType: String,
    val FullName: String,
    val Id: String,
    val ImageUrl: String,
    val Internal: String,
    val Name: String,
    val ProofType: String,
    val Type: Int,
    val Url: String
) : Parcelable