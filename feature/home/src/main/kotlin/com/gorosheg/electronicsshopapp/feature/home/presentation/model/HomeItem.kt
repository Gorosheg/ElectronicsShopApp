package com.gorosheg.electronicsshopapp.feature.home.presentation.model

import com.gorosheg.electronicsshopapp.common.recycler.ListItem

internal sealed interface HomeItem : ListItem {

    object Search : HomeItem

    class Header(
        val title: String,
        val subtitle: String,
    ) : HomeItem

    class Categories(
        val categories: List<Category>,
    ) : HomeItem

    class HotSales(
        val sales: List<HotSale>,
    ) : HomeItem

    class BestSeller(
        val products: List<BestSellerProduct>,
    ) : HomeItem
}