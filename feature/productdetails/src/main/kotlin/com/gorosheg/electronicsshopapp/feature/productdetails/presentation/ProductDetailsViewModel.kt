package com.gorosheg.electronicsshopapp.feature.productdetails.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.gorosheg.electronicsshopapp.feature.productdetails.domain.ProductDetailsRepository
import com.gorosheg.electronicsshopapp.feature.productdetails.presentation.model.ProductDetailsViewState
import com.gorosheg.electronicsshopapp.feature.productdetails.presentation.utils.toUiDetails
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch

internal class ProductDetailsViewModel(private val repository: ProductDetailsRepository) : ViewModel() {

    val state = MutableStateFlow(ProductDetailsViewState())

    init {
        viewModelScope.launch {
            state.value = getProductDetails()
        }
    }

    fun changeSelectedColor(itemId: Int) {
        val newColors = state.value.colors.mapIndexed { index, item ->
            item.copy(isSelected = itemId == index)
        }

        val newState = state.value.copy(colors = newColors)
        state.value = newState
    }

    fun changeSelectedCapacity(itemId: Int) {
        val newCapacity = state.value.capacity.mapIndexed { index, item ->
            item.copy(isSelected = itemId == index)
        }

        val newState = state.value.copy(capacity = newCapacity)
        state.value = newState
    }

    private suspend fun getProductDetails(): ProductDetailsViewState {
        return repository.getProductDetails().toUiDetails()
    }
}