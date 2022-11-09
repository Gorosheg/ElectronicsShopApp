package com.gorosheg.electronicsshopapp.feature.home.domain

import com.gorosheg.electronicsshopapp.feature.home.presentation.recycler.HomeItem

interface HomeInteractor {

    suspend fun getHotSales(): HomeItem.HotSales

    suspend fun getBestSellers(): HomeItem.BestSeller
}