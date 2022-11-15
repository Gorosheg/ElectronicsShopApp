package com.gorosheg.electronicsshopapp.feature.mycart.presentation.utils

import com.gorosheg.electronicsshopapp.common.recycler.utils.mapPriceToString
import com.gorosheg.electronicsshopapp.feature.mycart.presentation.model.BasketItem

internal fun countTotalPrice(baskets: List<BasketItem>): String {
    val listPrices: List<Int> = baskets.map { it.getItemPrice() }
    return mapPriceToString(listPrices.sum())
}

private fun BasketItem.getItemPrice(): Int {
    return price
        .dropLast(CENT_CHARS)
        .replace(",", "")
        .toInt() * amountOfItems
}

private const val CENT_CHARS = 3