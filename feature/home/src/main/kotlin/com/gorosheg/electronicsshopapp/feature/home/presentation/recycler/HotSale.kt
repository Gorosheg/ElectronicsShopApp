package com.gorosheg.electronicsshopapp.feature.home.presentation.recycler

import com.gorosheg.electronicsshopapp.feature.home.presentation.recycler.delegate.ListItem

data class HotSale(
    val name: String,
    val description: String,
    val isNew: Boolean,
    //val image: String,
) : ListItem