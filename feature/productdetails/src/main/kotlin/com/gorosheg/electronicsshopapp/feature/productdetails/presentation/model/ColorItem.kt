package com.gorosheg.electronicsshopapp.feature.productdetails.presentation.model

import com.gorosheg.electronicsshopapp.common.recycler.ListItem

class ColorItem(
    val id: Int,
    val colorValue: String,
    var isSelected: Boolean,
) : ListItem