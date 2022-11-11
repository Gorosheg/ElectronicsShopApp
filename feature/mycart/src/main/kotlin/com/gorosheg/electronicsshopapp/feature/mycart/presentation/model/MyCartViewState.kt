package com.gorosheg.electronicsshopapp.feature.mycart.presentation.model

internal class MyCartViewState(
    val basket: List<BasketItem> = emptyList(),
    val delivery: String = "",
    val id: String = "",
    val total: Int = 0,
)