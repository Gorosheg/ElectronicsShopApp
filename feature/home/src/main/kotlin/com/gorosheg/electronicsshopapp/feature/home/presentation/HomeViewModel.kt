package com.gorosheg.electronicsshopapp.feature.home.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.gorosheg.electronicsshopapp.feature.home.domain.HomeInteractor
import com.gorosheg.electronicsshopapp.feature.home.presentation.recycler.Category
import com.gorosheg.electronicsshopapp.feature.home.presentation.recycler.HomeItem
import com.gorosheg.mainscreen.R
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch

internal class HomeViewModel(private val interactor: HomeInteractor) : ViewModel() {

    val state = MutableStateFlow(HomeViewState())

    init {
        viewModelScope.launch {
            val hotSales = interactor.getHotSales()
            val bestSellers = interactor.getBestSellers()

            val adapterItems: List<HomeItem> = listOf(
                HomeItem.Header(/*R.string.select_category*/"Select Category", "view all"),

                HomeItem.Categories(listOf(
                    Category("Phones", R.drawable.ic_phones, true),
                    Category("Computer", R.drawable.ic_computer, false),
                    Category("Health", R.drawable.ic_health, false),
                    Category("Books", R.drawable.ic_books, false),
                )),

                HomeItem.Search,
                HomeItem.Header("Hot sales", "see more"),

                /*HomeItem.HotSales(listOf(
                    HotSale("Iphone 12", "Súper. Mega. Rápido.", true),
                    HotSale("Iphone 45", "qwerty", false)
                )),*/
                hotSales,

                HomeItem.Header("Best Seller", "see more"),
                /*HomeItem.BestSeller(listOf(
                    BestSellerProduct("", "300", "600", "asd", true),
                    BestSellerProduct("", "567", "600", "hfd", false),
                    BestSellerProduct("", "300", "874", "asd", true),
                ))*/
                bestSellers
            )

            state.value = HomeViewState(adapterItems)
        }
    }
}