package com.gorosheg.electronicsshopapp.feature.productdetails.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.gorosheg.electronicsshopapp.feature.productdetails.domain.ProductDetailsRepository
import com.gorosheg.electronicsshopapp.feature.productdetails.presentation.model.CapacityItem
import com.gorosheg.electronicsshopapp.feature.productdetails.presentation.model.ColorItem
import com.gorosheg.electronicsshopapp.feature.productdetails.presentation.model.ProductDetailsItem
import com.gorosheg.electronicsshopapp.feature.productdetails.presentation.model.ProductDetailsViewState
import com.gorosheg.electronicsshopapp.network.model.ProductDetailsResponse
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch

internal class ProductDetailsViewModel(private val repository: ProductDetailsRepository) : ViewModel() {

    val state = MutableStateFlow(ProductDetailsViewState())

    init {
        viewModelScope.launch {
            val adapterItems: List<ProductDetailsItem> = listOf(
                buildColors(),
                buildCapacity()
            )
            state.value = ProductDetailsViewState(adapterItems)
        }
    }

    private suspend fun buildColors(): ProductDetailsItem.Color {
        return getProductDetails().toUiColors()
    }

    private suspend fun buildCapacity(): ProductDetailsItem.Capacity {
        return getProductDetails().toUiCapacity()
    }

    private suspend fun getProductDetails(): ProductDetailsResponse {
        return repository.getProductDetails()
    }

    private fun ProductDetailsResponse.toUiColors(): ProductDetailsItem.Color {
        return ProductDetailsItem.Color(
            colors = color.map {
                ColorItem(colorValue = it, isSelected = false)
            }
        )
    }

    private fun ProductDetailsResponse.toUiCapacity(): ProductDetailsItem.Capacity {
        return ProductDetailsItem.Capacity(
            capacity = capacity.map {
                CapacityItem(capacityValue = it, isSelected = false)
            }
        )
    }
}