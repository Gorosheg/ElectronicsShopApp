package com.gorosheg.electronicsshopapp.feature.cart.domain

import com.gorosheg.electronicsshopapp.network.model.CartResponse

interface CartRepository {
    suspend fun getCart(): CartResponse
}