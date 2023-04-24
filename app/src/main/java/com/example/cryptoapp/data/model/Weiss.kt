package com.example.cryptoapp.data.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Weiss(
    val MarketPerformanceRating: String,
    val Rating: String,
    val TechnologyAdoptionRating: String
) : Parcelable