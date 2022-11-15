package com.gorosheg.electronicsshopapp.feature.home.presentation.model

import androidx.annotation.StringRes
import com.gorosheg.electronicsshopapp.common.ListItem

internal sealed interface HomeItem : ListItem {

    object Search : HomeItem

    class Header(
        @StringRes val title: Int,
        @StringRes val subtitle: Int,
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