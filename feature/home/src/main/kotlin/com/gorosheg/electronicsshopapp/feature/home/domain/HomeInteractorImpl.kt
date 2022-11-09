package com.gorosheg.electronicsshopapp.feature.home.domain

import com.gorosheg.electronicsshopapp.core.model.BestSellerResponse
import com.gorosheg.electronicsshopapp.core.model.HomeResponse
import com.gorosheg.electronicsshopapp.core.model.HotSaleResponse
import com.gorosheg.electronicsshopapp.feature.home.presentation.recycler.BestSellerProduct
import com.gorosheg.electronicsshopapp.feature.home.presentation.recycler.HomeItem
import com.gorosheg.electronicsshopapp.feature.home.presentation.recycler.HotSale

class HomeInteractorImpl(private val repository: HomeRepository) : HomeInteractor {

    override suspend fun getHotSales(): HomeItem.HotSales {
        val allProducts = repository.getProducts()
        return allProducts.toUiHotSales()
    }

    override suspend fun getBestSellers(): HomeItem.BestSeller {
        val allProducts = repository.getProducts()
        return allProducts.toUiBestSellers()
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