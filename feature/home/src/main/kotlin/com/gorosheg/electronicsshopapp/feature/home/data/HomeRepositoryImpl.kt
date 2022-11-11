package com.gorosheg.electronicsshopapp.feature.home.data

import com.gorosheg.electronicsshopapp.feature.home.domain.HomeRepository
import com.gorosheg.electronicsshopapp.network.ElectronicsShopApi
import com.gorosheg.electronicsshopapp.network.model.HomeResponse

class HomeRepositoryImpl(private val api: ElectronicsShopApi) : HomeRepository {

    override suspend fun getProducts(): HomeResponse {
        return api.getProducts()
    }
}