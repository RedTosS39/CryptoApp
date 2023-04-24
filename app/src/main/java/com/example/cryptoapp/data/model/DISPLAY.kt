package com.example.cryptoapp.data.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class DISPLAY(
    val USD: USD
) : Parcelable