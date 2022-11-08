package com.gorosheg.electronicsshopapp.feature.home.presentation.recycler

import com.gorosheg.electronicsshopapp.feature.home.presentation.recycler.delegate.ListItem

data class BestSellerProduct(
    val image: String,
    val price: String,
    val priceWithoutSale: String,
    val name: String,
    val isLiked: Boolean,
) : ListItem