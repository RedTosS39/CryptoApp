package com.example.cryptoapp.data.model

import com.example.cryptoapp.domain.model.*

class CoinMapper {

    private fun mapData(data: Data) =
        DomainData(mapCoinInfo(data.CoinInfo), mapDisplay(data.DISPLAY))

    fun mapToDomainModel(coinsModel: CoinsModel) = DomainCoinModel(
        mapList(coinsModel.Data)
    )

    private fun mapUsd(usd: USD) = DomainUSD(usd.PRICE)
    private fun mapDisplay(display: DISPLAY) = DomainDisplay(mapUsd(display.USD))
    private fun mapCoinInfo(coinInfo: CoinInfo) = DomainCoinInfo(
        coinInfo.FullName,
        coinInfo.Id,
        coinInfo.ImageUrl,
        coinInfo.Name,
        coinInfo.Url
    )

    fun mapList(list: List<Data>): List<DomainData> = list.map { mapData(it) }
}