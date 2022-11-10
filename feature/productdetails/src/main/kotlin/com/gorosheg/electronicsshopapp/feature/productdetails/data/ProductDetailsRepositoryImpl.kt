package com.gorosheg.electronicsshopapp.feature.productdetails.data

import com.gorosheg.electronicsshopapp.feature.productdetails.domain.ProductDetailsRepository
import com.gorosheg.electronicsshopapp.network.ElectronicsShopApi
import com.gorosheg.electronicsshopapp.network.model.ProductDetailsResponse

class ProductDetailsRepositoryImpl(private val api: ElectronicsShopApi) : ProductDetailsRepository {
    override suspend fun getProductDetails(): ProductDetailsResponse {
        return api.getProductDetails()
    }
}