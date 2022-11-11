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
        viewModelScope.launch {
            val adapterItems: List<HomeItem> = listOf(
                buildHeader(),
                buildCategories(),
                buildSearch(),
                buildHeader(),
                buildHotSales(),
                buildHeader(),
                buildBestSeller()
            )

            state.value = HomeViewState(adapterItems)
        }
    }

    private fun buildHeader(): HomeItem.Header {
        return HomeItem.Header(/*R.string.select_category*/"Select Category", "view all")
        // HomeItem.Header("Hot sales", "see more"),
        // HomeItem.Header("Best Seller", "see more"),

    }

    private fun buildCategories(): HomeItem.Categories {
        return HomeItem.Categories(listOf(
            Category("Phones", R.drawable.ic_phones, true),
            Category("Computer", R.drawable.ic_computer, false),
            Category("Health", R.drawable.ic_health, false),
            Category("Books", R.drawable.ic_books, false),
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
        price = "$discountPrice",
        priceWithoutSale = "$priceWithoutDiscount",
        isLiked = isFavorites,
        image = picture
    )
}