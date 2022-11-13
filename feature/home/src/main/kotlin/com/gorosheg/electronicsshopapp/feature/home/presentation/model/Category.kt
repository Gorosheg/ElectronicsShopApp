package com.gorosheg.electronicsshopapp.feature.home.presentation.model

import com.gorosheg.electronicsshopapp.common.recycler.ListItem

internal class Category(
    val id: Int,
    val name: String,
    val icon: Int,
    val isSelected: Boolean,
) : ListItem