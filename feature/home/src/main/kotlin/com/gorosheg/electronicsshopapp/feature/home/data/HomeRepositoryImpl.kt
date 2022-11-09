package com.gorosheg.electronicsshopapp.feature.home.data

import com.gorosheg.electronicsshopapp.network.ElectronicsShopApi
import com.gorosheg.electronicsshopapp.network.model.HomeResponse
import com.gorosheg.electronicsshopapp.feature.home.domain.HomeRepository

class HomeRepositoryImpl(private val api: ElectronicsShopApi) : HomeRepository {

    override suspend fun getProducts(): HomeResponse {
        return api.getProducts()
    }
}