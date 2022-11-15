package com.gorosheg.electronicsshopapp.feature.productdetails.presentation.model

import com.gorosheg.electronicsshopapp.common.recycler.ListItem

class CapacityItem(
    val id: Int,
    val capacityValue: String,
    var isSelected: Boolean,
) : ListItem