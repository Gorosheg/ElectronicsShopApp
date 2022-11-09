package com.gorosheg.electronicsshopapp.core

import com.gorosheg.electronicsshopapp.core.model.CartResponse
import com.gorosheg.electronicsshopapp.core.model.HomeResponse
import com.gorosheg.electronicsshopapp.core.model.ProductDetailsResponse
import retrofit2.http.GET

interface ElectronicsShopApi {

    @GET("654bd15e-b121-49ba-a588-960956b15175")
    suspend fun getProducts(): HomeResponse

    @GET("6c14c560-15c6-4248-b9d2-b4508df7d4f5")
    suspend fun getProductDetails(): ProductDetailsResponse

    @GET("53539a72-3c5f-4f30-bbb1-6ca10d42c149")
    suspend fun getCart(): CartResponse
}