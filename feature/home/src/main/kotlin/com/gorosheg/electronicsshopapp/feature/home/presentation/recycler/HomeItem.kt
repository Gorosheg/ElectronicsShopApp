package com.gorosheg.electronicsshopapp.feature.home.presentation.recycler

import com.gorosheg.electronicsshopapp.feature.home.presentation.recycler.delegate.ListItem

sealed interface HomeItem : ListItem {

    object Search : HomeItem

    data class Header(
        val title: String,
        val subtitle: String,
    ) : HomeItem

    data class Categories(
        val categories: List<Category>,
    ) : HomeItem

    data class HotSales(
        val sales: List<HotSale>,
    ) : HomeItem

    data class BestSeller(
        val products: List<BestSellerProduct>,
    ) : HomeItem
}