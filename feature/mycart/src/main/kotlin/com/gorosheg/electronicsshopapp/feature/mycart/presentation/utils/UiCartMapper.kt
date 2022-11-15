package com.gorosheg.electronicsshopapp.feature.mycart.presentation.utils

import com.gorosheg.electronicsshopapp.common.recycler.utils.mapPriceToString
import com.gorosheg.electronicsshopapp.feature.mycart.presentation.model.CartBasketItem
import com.gorosheg.electronicsshopapp.feature.mycart.presentation.model.CartViewState
import com.gorosheg.electronicsshopapp.network.model.BasketResponse
import com.gorosheg.electronicsshopapp.network.model.CartResponse

internal fun CartResponse.toCartViewState() = CartViewState(
    basket = basket.toUiBasketItems(),
    delivery = delivery,
    total = countTotalPrice(basket.toUiBasketItems())
)

private fun List<BasketResponse>.toUiBasketItems(): List<CartBasketItem> {
    return map(BasketResponse::toUiBasketItem)
}

private fun BasketResponse.toUiBasketItem() = CartBasketItem(
    id = id,
    amountOfItems = 2,
    images = images,
    title = title,
    price = mapPriceToString(price)
)