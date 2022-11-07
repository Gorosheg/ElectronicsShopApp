package com.gorosheg.electronicsshopapp.feature.home.presentation.recycler

import com.gorosheg.electronicsshopapp.feature.home.presentation.recycler.delegate.ListItem
import org.w3c.dom.Text

internal sealed interface RecyclerItems : ListItem {

    object Search : RecyclerItems

    data class Header(
        val title: String,
        val subtitle: String,
    ) : RecyclerItems

    data class Categories(
        val categories: List<Category>
    ) : RecyclerItems

    data class HotSales(
        val sales: List<HotSale>,
    ) : RecyclerItems

    data class BestSeller(
        val image: String,
        val price: String,
        val priceWithoutSale: String,
        val description: String,
        val isLiked: Boolean,
    ) : RecyclerItems
}