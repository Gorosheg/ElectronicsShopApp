package com.gorosheg.electronicsshopapp.feature.home.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.gorosheg.electronicsshopapp.feature.home.domain.HomeRepository
import com.gorosheg.electronicsshopapp.feature.home.presentation.model.*
import com.gorosheg.electronicsshopapp.network.model.BestSellerResponse
import com.gorosheg.electronicsshopapp.network.model.HomeResponse
import com.gorosheg.electronicsshopapp.network.model.HotSaleResponse
import com.gorosheg.mainscreen.R
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
            val adapterItems: List<HomeItem> = listOf(
                buildHeader(Header.CATEGORY),
                buildCategories(selectedCategoryId),
                buildSearch(),
                buildHeader(Header.HOT_SALES),
                buildHotSales(),
                buildHeader(Header.BEST_SELLER),
                buildBestSeller()
            )

            state.value = HomeViewState(adapterItems)
        }
    }

    private fun buildHeader(header: Header): HomeItem.Header {
        return HomeItem.Header(header.title, header.subtitle)
    }

    private fun buildCategories(selectedCategoryId: Int): HomeItem.Categories {
        return HomeItem.Categories(listOf(
            Category(0, "Phones", R.drawable.ic_phones, selectedCategoryId == 0),
            Category(1, "Computer", R.drawable.ic_computer, selectedCategoryId == 1),
            Category(2, "Health", R.drawable.ic_health, selectedCategoryId == 2),
            Category(3, "Books", R.drawable.ic_books, selectedCategoryId == 3),
            Category(4, "Books", R.drawable.ic_books, selectedCategoryId == 4),
        ))
    }

    private fun buildSearch(): HomeItem.Search {
        return HomeItem.Search
    }

    private suspend fun buildHotSales(): HomeItem.HotSales {
        return getAllProducts().toUiHotSales()
    }

    private suspend fun buildBestSeller(): HomeItem.BestSeller {
        return getAllProducts().toUiBestSellers()
    }

    private suspend fun getAllProducts(): HomeResponse {
        return repository.getProducts()
    }

    private fun HomeResponse.toUiHotSales(): HomeItem.HotSales {
        return HomeItem.HotSales(
            sales = hotSales.map {
                it.toHotSale()
            }
        )
    }

    private fun HotSaleResponse.toHotSale(): HotSale = HotSale(
        name = title,
        description = subtitle,
        isNew = isNew,
        image = picture
    )

    private fun HomeResponse.toUiBestSellers(): HomeItem.BestSeller {
        return HomeItem.BestSeller(
            products = bestSellers.map {
                it.toBestSeller()
            }
        )
    }

    private fun BestSellerResponse.toBestSeller(): BestSellerProduct = BestSellerProduct(
        name = title,
        price = discountPrice.toString(),
        priceWithoutSale = priceWithoutDiscount.toString(),
        isLiked = isFavorites,
        image = picture
    )
}