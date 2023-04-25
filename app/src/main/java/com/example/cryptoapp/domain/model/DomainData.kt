package com.example.cryptoapp.domain.model

import android.os.Parcelable
import com.example.cryptoapp.data.model.CoinInfo
import com.example.cryptoapp.data.model.DISPLAY
import kotlinx.parcelize.Parcelize

@Parcelize
data class DomainData(
    val domainCoinInfo: DomainCoinInfo,
    val domainDISPLAY: DomainDisplay
): Parcelable