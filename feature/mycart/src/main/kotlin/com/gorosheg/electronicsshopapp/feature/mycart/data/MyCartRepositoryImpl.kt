package com.gorosheg.electronicsshopapp.feature.mycart.data

import com.gorosheg.electronicsshopapp.feature.mycart.domain.MyCartRepository
import com.gorosheg.electronicsshopapp.network.ElectronicsShopApi

class MyCartRepositoryImpl(private val api: ElectronicsShopApi) : MyCartRepository {
}