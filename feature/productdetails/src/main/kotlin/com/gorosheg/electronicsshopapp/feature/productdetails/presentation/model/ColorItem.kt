package com.gorosheg.electronicsshopapp.feature.productdetails.presentation.model

import com.gorosheg.electronicsshopapp.common.recycler.ListItem

data class ColorItem(
    val id: Int,
    val colorValue: String,
    val isSelected: Boolean,
) : ListItem