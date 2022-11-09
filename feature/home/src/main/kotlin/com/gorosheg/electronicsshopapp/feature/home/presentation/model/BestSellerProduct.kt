package com.gorosheg.electronicsshopapp.feature.home.presentation.model

import com.gorosheg.electronicsshopapp.common.recycler.ListItem

data class BestSellerProduct(
    val name: String,
    val price: String,
    val priceWithoutSale: String,
    val isLiked: Boolean,
    val image: String,
) : ListItem