package com.gorosheg.electronicsshopapp.core.model

data class CartResponse(
    val basket: List<Basket>,
    val delivery: String,
    val id: String,
    val total: Int
)