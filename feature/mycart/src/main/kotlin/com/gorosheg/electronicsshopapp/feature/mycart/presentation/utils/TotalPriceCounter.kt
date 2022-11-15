package com.gorosheg.electronicsshopapp.feature.mycart.presentation.utils

import com.gorosheg.electronicsshopapp.common.recycler.utils.mapPriceToString
import com.gorosheg.electronicsshopapp.feature.mycart.presentation.model.CartBasketItem

internal fun countTotalPrice(baskets: List<CartBasketItem>): String {
    val listPrices: List<Int> = baskets.map(CartBasketItem::getItemPrice)
    return mapPriceToString(listPrices.sum())
}

private fun CartBasketItem.getItemPrice(): Int {
    return price
        .replace(",", "")
        .toInt() * amountOfItems
}