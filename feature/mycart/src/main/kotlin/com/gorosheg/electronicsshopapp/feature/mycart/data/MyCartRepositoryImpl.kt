package com.gorosheg.electronicsshopapp.feature.mycart.data

import com.gorosheg.electronicsshopapp.feature.mycart.domain.MyCartRepository
import com.gorosheg.electronicsshopapp.network.ElectronicsShopApi
import com.gorosheg.electronicsshopapp.network.model.CartResponse

class MyCartRepositoryImpl(private val api: ElectronicsShopApi) : MyCartRepository {

    override suspend fun getMyCart(): CartResponse {
        return api.getCart()
    }
}