package com.gorosheg.electronicsshopapp.feature.home.data

import com.gorosheg.electronicsshopapp.core.ElectronicsShopApi
import com.gorosheg.electronicsshopapp.core.model.HomeResponse
import com.gorosheg.electronicsshopapp.feature.home.domain.HomeRepository

class HomeRepositoryImpl(private val api: ElectronicsShopApi) : HomeRepository {

    override suspend fun getProducts(): HomeResponse {
        return api.getProducts()
    }
}