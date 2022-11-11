package com.gorosheg.electronicsshopapp.network.model

import androidx.annotation.Keep

@Keep
data class BasketResponse(
    val id: Int,
    val images: String,
    val price: Int,
    val title: String,
)