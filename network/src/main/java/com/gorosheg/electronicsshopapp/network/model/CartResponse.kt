package com.gorosheg.electronicsshopapp.network.model

import androidx.annotation.Keep

@Keep
data class CartResponse(
    val basket: List<Basket>,
    val delivery: String,
    val id: String,
    val total: Int
)