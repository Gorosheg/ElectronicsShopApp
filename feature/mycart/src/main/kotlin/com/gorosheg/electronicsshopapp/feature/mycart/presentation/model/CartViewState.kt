package com.gorosheg.electronicsshopapp.feature.mycart.presentation.model

internal data class CartViewState(
    val id: String = "",
    val basket: List<BasketItem> = emptyList(),
    val delivery: String = "",
    val total: String = "",
)