package com.gorosheg.electronicsshopapp.feature.productdetails.presentation.model

import com.gorosheg.electronicsshopapp.common.recycler.ListItem

data class CapacityItem(
    val id: Int,
    val capacityValue: String,
    val isSelected: Boolean,
) : ListItem