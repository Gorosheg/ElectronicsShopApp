package com.gorosheg.electronicsshopapp.feature.productdetails.presentation.model

internal data class ProductDetailsViewState(
    val title: String = "",
    val rating: Int = 5,
    val isFavorite: Boolean = false,

    val cpu: String = "",
    val camera: String = "",
    val sd: String = "",
    val ssd: String = "",

    val colors: List<ColorItem> = emptyList(),
    val capacity: List<CapacityItem> = emptyList(),
    val images: List<ImageItem> = emptyList(),

    val price: String = "",
)