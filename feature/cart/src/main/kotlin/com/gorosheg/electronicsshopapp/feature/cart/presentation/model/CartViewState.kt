package com.gorosheg.electronicsshopapp.feature.cart.presentation.model

internal data class CartViewState(
    val basket: List<CartBasketItem> = emptyList(),
    val delivery: String = "",
    val total: String = "",
)