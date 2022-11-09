package com.gorosheg.electronicsshopapp.feature.home.domain

import com.gorosheg.electronicsshopapp.network.model.HomeResponse

interface HomeRepository {
    suspend fun getProducts(): HomeResponse
}