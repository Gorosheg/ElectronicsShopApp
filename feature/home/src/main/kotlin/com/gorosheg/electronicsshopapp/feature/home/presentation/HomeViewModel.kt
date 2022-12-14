package com.gorosheg.electronicsshopapp.feature.home.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.gorosheg.electronicsshopapp.feature.home.domain.HomeRepository
import com.gorosheg.electronicsshopapp.feature.home.presentation.model.HomeItem
import com.gorosheg.electronicsshopapp.feature.home.presentation.model.HomeViewState
import com.gorosheg.electronicsshopapp.feature.home.presentation.utils.toUiBestSellers
import com.gorosheg.electronicsshopapp.feature.home.presentation.utils.toUiHotSales
import com.gorosheg.electronicsshopapp.network.model.HomeResponse
import kotlinx.coroutines.CancellationException
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch

internal class HomeViewModel(private val repository: HomeRepository) : ViewModel() {

    val state = MutableStateFlow(HomeViewState())

    init {
        setState(selectedCategoryId = 0)
    }

    fun changeCategory(selectedCategoryId: Int) {
        setState(selectedCategoryId)
    }

    private fun setState(selectedCategoryId: Int) {
        viewModelScope.launch {
            try {
                val adapterItems = buildState(selectedCategoryId)
                state.value = HomeViewState(adapterItems)
            } catch (e: Exception) {
                if (e is CancellationException) throw e
                e.printStackTrace()
            }
        }
    }

    private suspend fun buildState(selectedCategoryId: Int): List<HomeItem> {
        return listOf(
            buildHeader(Header.CATEGORY),
            buildCategories(selectedCategoryId),
            buildSearch(),
            buildHeader(Header.HOT_SALES),
            getAllProducts().toUiHotSales(),
            buildHeader(Header.BEST_SELLER),
            getAllProducts().toUiBestSellers()
        )
    }

    private suspend fun getAllProducts(): HomeResponse {
        return repository.getProducts()
    }
}