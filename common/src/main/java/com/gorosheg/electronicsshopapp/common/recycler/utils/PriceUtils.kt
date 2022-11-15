package com.gorosheg.electronicsshopapp.common.recycler.utils

fun mapPriceToString(price: Int): String {
    val priceInString = price.toString()

    return if (priceInString.length > THOUSAND_LENGTH) {
        StringBuilder(priceInString)
            .insert(priceInString.length - THOUSAND_SEPARATOR_PLACE, ",")
            .toString()
    } else {
        priceInString
    }
}

private const val THOUSAND_LENGTH = 2
private const val THOUSAND_SEPARATOR_PLACE = 3