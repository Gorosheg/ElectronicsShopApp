package com.gorosheg.electronicsshopapp.feature.home.presentation.recycler

import com.gorosheg.electronicsshopapp.feature.home.presentation.recycler.delegate.ListItem

data class Category(
    val name: String,
    val icon: Int,
    val isEnabled: Boolean,
) : ListItem