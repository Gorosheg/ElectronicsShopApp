package com.gorosheg.electronicsshopapp.feature.productdetails.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.gorosheg.electronicsshopapp.feature.productdetails.domain.ProductDetailsRepository
import com.gorosheg.electronicsshopapp.feature.productdetails.presentation.model.CapacityItem
import com.gorosheg.electronicsshopapp.feature.productdetails.presentation.model.ColorItem
import com.gorosheg.electronicsshopapp.feature.productdetails.presentation.model.ImageItem
import com.gorosheg.electronicsshopapp.feature.productdetails.presentation.model.ProductDetailsViewState
import com.gorosheg.electronicsshopapp.network.model.ProductDetailsResponse
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch
import kotlin.math.roundToInt

internal class ProductDetailsViewModel(private val repository: ProductDetailsRepository) : ViewModel() {

    val state = MutableStateFlow(ProductDetailsViewState())

    init {
        viewModelScope.launch {
            state.value = getProductDetails()
        }
    }

    private suspend fun getProductDetails(): ProductDetailsViewState {
        return repository.getProductDetails().toUiDetails()
    }

    private fun ProductDetailsResponse.toUiDetails(): ProductDetailsViewState {
        return ProductDetailsViewState(
            title = title,
            rating = rating.roundToInt(),
            isFavorite = isFavorites,
            CPU = CPU,
            camera = camera,
            sd = sd,
            ssd = ssd,
            colors = getUiColors(color),
            capacity = getUiCapacity(capacity),
            images = getUiImage(images),
            price = price,
        )
    }

    private fun getUiColors(colors: List<String>): List<ColorItem> {
        return colors.mapIndexed { index, item ->
            ColorItem(colorValue = item, isSelected = index == 0)
        }
    }

    private fun getUiCapacity(capacity: List<String>): List<CapacityItem> {
        return capacity.mapIndexed { index, item ->
            CapacityItem(capacityValue = item, isSelected = index == 0)
        }
    }

    private fun getUiImage(images: List<String>): List<ImageItem> {
        return images.map { item ->
            ImageItem(image = item)
        }
    }
}