package com.gorosheg.electronicsshopapp.feature.home.presentation

import com.gorosheg.electronicsshopapp.feature.home.presentation.model.Category
import com.gorosheg.electronicsshopapp.feature.home.presentation.model.HomeItem
import com.gorosheg.mainscreen.R

internal fun buildHeader(header: Header): HomeItem.Header {
    return HomeItem.Header(header.title, header.subtitle)
}

internal fun buildCategories(selectedCategoryId: Int): HomeItem.Categories {
    return HomeItem.Categories(listOf(
        Category(0, R.string.phones, R.drawable.ic_phones, selectedCategoryId == 0),
        Category(1, R.string.computer, R.drawable.ic_computer, selectedCategoryId == 1),
        Category(2, R.string.health, R.drawable.ic_health, selectedCategoryId == 2),
        Category(3, R.string.books, R.drawable.ic_books, selectedCategoryId == 3),
        Category(4, R.string.books, R.drawable.ic_books, selectedCategoryId == 4),
    ))
}

internal fun buildSearch(): HomeItem.Search {
    return HomeItem.Search
}