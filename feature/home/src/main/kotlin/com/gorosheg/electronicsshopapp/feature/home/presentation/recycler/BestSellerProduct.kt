package com.gorosheg.electronicsshopapp.feature.home.presentation.recycler

import com.gorosheg.electronicsshopapp.feature.home.presentation.recycler.delegate.ListItem

data class BestSellerProduct(
    val name: String,
    val price: String,
    val priceWithoutSale: String,
    val isLiked: Boolean,
    val image: String,
) : ListItem