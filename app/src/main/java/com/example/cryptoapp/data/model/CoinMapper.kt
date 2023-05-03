package com.example.cryptoapp.data.model

import com.example.cryptoapp.domain.model.DomainCoinInfo
import com.example.cryptoapp.domain.model.DomainData
import com.example.cryptoapp.domain.model.DomainDisplay
import com.example.cryptoapp.domain.model.DomainUSD

class CoinMapper {
    private fun mapToDomainUSD(usd: USD) = DomainUSD(usd.PRICE)
    private fun mapToDomainDisplay(display: DISPLAY) = DomainDisplay(mapToDomainUSD(display.USD))
    private fun mapToDomainCoinInfo(coinInfo: CoinInfo) =
        DomainCoinInfo(
            coinInfo.FullName,
            coinInfo.Id,
            ImageUrl = IMG_URL + coinInfo.ImageUrl,
            coinInfo.Name,
            coinInfo.Url
        )

    private fun mapToDomainData(data: Data) =
        DomainData(
            mapToDomainCoinInfo(data.CoinInfo),
            mapToDomainDisplay(data.DISPLAY)
        )

    fun mapList(dataList: List<Data>): List<DomainData> = dataList.map { mapToDomainData(it) }


    companion object {
        private const val IMG_URL = "https://www.cryptocompare.com/"
    }
}