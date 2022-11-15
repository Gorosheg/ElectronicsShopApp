package com.gorosheg.electronicsshopapp.network.model

import androidx.annotation.Keep

typealias ProductId = Int

@Keep
data class BasketResponse(
    val id: ProductId,
    val images: String,
    val price: Int,
    val title: String,
)