package com.gorosheg.electronicsshopapp.feature.productdetails.presentation.model

import com.gorosheg.electronicsshopapp.common.recycler.ListItem

sealed interface ProductDetailsItem : ListItem {

    data class Color(
        val colors: List<ColorItem>,
    ) : ProductDetailsItem

    data class Capacity(
        val capacity: List<CapacityItem>,
    ) : ProductDetailsItem
}