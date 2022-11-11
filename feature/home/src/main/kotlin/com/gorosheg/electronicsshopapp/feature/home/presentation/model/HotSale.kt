package com.gorosheg.electronicsshopapp.feature.home.presentation.model

import com.gorosheg.electronicsshopapp.common.recycler.ListItem

internal class HotSale(
    val name: String,
    val description: String,
    val isNew: Boolean,
    val image: String,
) : ListItem