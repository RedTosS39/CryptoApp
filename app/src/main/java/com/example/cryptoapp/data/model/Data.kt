package com.example.cryptoapp.data.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Data(
    val CoinInfo: CoinInfo,
    val DISPLAY: DISPLAY,
) : Parcelable