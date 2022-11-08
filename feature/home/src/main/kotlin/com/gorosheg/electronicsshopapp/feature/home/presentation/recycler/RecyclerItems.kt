package com.gorosheg.electronicsshopapp.feature.home.presentation.recycler

import com.gorosheg.electronicsshopapp.feature.home.presentation.recycler.delegate.ListItem

internal sealed interface RecyclerItems : ListItem {

    object Search : RecyclerItems

    data class Header(
        val title: String,
        val subtitle: String,
    ) : RecyclerItems

    data class Categories(
        val categories: List<Category>,
    ) : RecyclerItems

    data class HotSales(
        val sales: List<HotSale>,
    ) : RecyclerItems

    data class BestSeller(
        val products: List<BestSellerProduct>,
    ) : RecyclerItems
}