package com.gorosheg.electronicsshopapp.feature.productdetails.data

import com.gorosheg.electronicsshopapp.feature.productdetails.domain.ProductDetailsRepository
import com.gorosheg.electronicsshopapp.network.ElectronicsShopApi

class ProductDetailsRepositoryImpl(private val api: ElectronicsShopApi) : ProductDetailsRepository {
}