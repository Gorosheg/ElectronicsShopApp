package com.gorosheg.electronicsshopapp.feature.mycart.presentation.model

import com.gorosheg.electronicsshopapp.common.ListItem
import com.gorosheg.electronicsshopapp.network.model.ProductId

data class CartBasketItem(
    val id: ProductId,
    val amountOfItems: Int,
    val images: String,
    val price: String,
    val title: String,
) : ListItem