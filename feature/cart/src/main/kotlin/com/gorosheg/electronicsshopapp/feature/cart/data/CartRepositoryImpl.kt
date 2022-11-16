package com.gorosheg.electronicsshopapp.feature.cart.data

import com.gorosheg.electronicsshopapp.feature.cart.domain.CartRepository
import com.gorosheg.electronicsshopapp.network.ElectronicsShopApi
import com.gorosheg.electronicsshopapp.network.model.CartResponse

class CartRepositoryImpl(private val api: ElectronicsShopApi) : CartRepository {

    override suspend fun getCart(): CartResponse {
        return api.getCart()
    }
}