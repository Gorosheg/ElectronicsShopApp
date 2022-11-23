package com.gorosheg.electronicsshopapp.feature.productdetails.presentation.utils

import com.gorosheg.electronicsshopapp.common.recycler.utils.mapPriceToString
import com.gorosheg.electronicsshopapp.feature.productdetails.presentation.model.CapacityItem
import com.gorosheg.electronicsshopapp.feature.productdetails.presentation.model.ColorItem
import com.gorosheg.electronicsshopapp.feature.productdetails.presentation.model.ImageItem
import com.gorosheg.electronicsshopapp.feature.productdetails.presentation.model.ProductDetailsViewState
import com.gorosheg.electronicsshopapp.network.model.ProductDetailsResponse
import kotlin.math.roundToInt

internal fun ProductDetailsResponse.toUiDetailsState(): ProductDetailsViewState {
    return ProductDetailsViewState(
        title = title,
        rating = rating.roundToInt(),
        isFavorite = isFavorites,
        cpu = cpu,
        camera = camera,
        sd = sd,
        ssd = ssd,
        colors = color.toUiColors(),
        capacity = capacity.toUiCapacity(),
        images = images.toUiImage(),
        price = mapPriceToString(price),
    )
}

private fun List<String>.toUiColors(): List<ColorItem> {
    return mapIndexed { index, item ->
        ColorItem(colorValue = item, isSelected = index == 0, id = index)
    }
}

private fun List<String>.toUiCapacity(): List<CapacityItem> {
    return mapIndexed { index, item ->
        CapacityItem(capacityValue = item, isSelected = index == 0, id = index)
    }
}

private fun List<String>.toUiImage(): List<ImageItem> {
    return map { item ->
        ImageItem(image = item)
    }
}