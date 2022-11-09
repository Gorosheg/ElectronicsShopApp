package com.gorosheg.electronicsshopapp.feature.home.presentation.model

import com.gorosheg.electronicsshopapp.common.recycler.ListItem

data class Category(
    val name: String,
    val icon: Int,
    val isEnabled: Boolean,
) : ListItem