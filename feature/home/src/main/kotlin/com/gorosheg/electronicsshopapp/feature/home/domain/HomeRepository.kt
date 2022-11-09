package com.gorosheg.electronicsshopapp.feature.home.domain

import com.gorosheg.electronicsshopapp.core.model.HomeResponse

interface HomeRepository {
    suspend fun getProducts(): HomeResponse
}