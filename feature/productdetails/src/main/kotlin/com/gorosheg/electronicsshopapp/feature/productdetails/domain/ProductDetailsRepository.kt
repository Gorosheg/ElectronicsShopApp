package com.gorosheg.electronicsshopapp.feature.productdetails.domain

import com.gorosheg.electronicsshopapp.network.model.ProductDetailsResponse

interface ProductDetailsRepository {
    suspend fun getProductDetails(): ProductDetailsResponse
}