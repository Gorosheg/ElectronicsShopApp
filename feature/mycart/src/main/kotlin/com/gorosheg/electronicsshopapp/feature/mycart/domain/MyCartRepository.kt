package com.gorosheg.electronicsshopapp.feature.mycart.domain

import com.gorosheg.electronicsshopapp.network.model.CartResponse

interface MyCartRepository {
    suspend fun getMyCart(): CartResponse
}