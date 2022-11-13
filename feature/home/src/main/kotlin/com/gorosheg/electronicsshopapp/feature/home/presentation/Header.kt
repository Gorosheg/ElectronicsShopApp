package com.gorosheg.electronicsshopapp.feature.home.presentation

import androidx.annotation.StringRes
import com.gorosheg.mainscreen.R

enum class Header(@StringRes val title: Int, @StringRes val subtitle: Int) {

    CATEGORY(R.string.select_category, R.string.view_all),
    HOT_SALES(R.string.hot_sales, R.string.see_more),
    BEST_SELLER(R.string.best_seller, R.string.see_more)
}