package com.gorosheg.electronicsshopapp.feature.mycart.presentation.model

import com.gorosheg.electronicsshopapp.common.recycler.ListItem

data class BasketItem(
    val id: Int,
    val amountOfItems: Int,
    val images: String,
    val price: String,
    val title: String,
) : ListItem