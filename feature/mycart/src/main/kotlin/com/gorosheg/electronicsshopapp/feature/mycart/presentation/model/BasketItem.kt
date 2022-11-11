package com.gorosheg.electronicsshopapp.feature.mycart.presentation.model

import com.gorosheg.electronicsshopapp.common.recycler.ListItem

class BasketItem(
    val id: Int,
    val images: String,
    val price: Int,
    val title: String,
) : ListItem