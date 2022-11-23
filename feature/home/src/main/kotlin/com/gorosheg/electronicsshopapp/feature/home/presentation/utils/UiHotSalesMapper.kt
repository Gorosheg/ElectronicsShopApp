package com.gorosheg.electronicsshopapp.feature.home.presentation.utils

import com.gorosheg.electronicsshopapp.feature.home.presentation.model.BestSellerProduct
import com.gorosheg.electronicsshopapp.feature.home.presentation.model.HomeItem
import com.gorosheg.electronicsshopapp.feature.home.presentation.model.HotSale
import com.gorosheg.electronicsshopapp.network.model.BestSellerResponse
import com.gorosheg.electronicsshopapp.network.model.HomeResponse
import com.gorosheg.electronicsshopapp.network.model.HotSaleResponse

internal fun HomeResponse.toUiHotSales(): HomeItem.HotSales {
    return HomeItem.HotSales(
        sales = hotSales.map(HotSaleResponse::toHotSale)
    )
}

internal fun HomeResponse.toUiBestSellers(): HomeItem.BestSeller {
    return HomeItem.BestSeller(
        products = bestSellers.map(BestSellerResponse::toBestSeller)
    )
}

private fun HotSaleResponse.toHotSale() = HotSale(
    name = title,
    description = subtitle,
    isNew = isNew,
    image = picture
)

private fun BestSellerResponse.toBestSeller() = BestSellerProduct(
    name = title,
    price = discountPrice.toString(),
    priceWithoutSale = priceWithoutDiscount.toString(),
    isLiked = isFavorites,
    image = picture
)