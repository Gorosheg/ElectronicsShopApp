package com.gorosheg.electronicsshopapp.feature.home.presentation.recycler.delegate

import androidx.core.view.isVisible
import com.gorosheg.electronicsshopapp.feature.home.presentation.recycler.HotSale
import com.gorosheg.electronicsshopapp.feature.home.presentation.recycler.HomeItem.HotSales
import com.gorosheg.mainscreen.databinding.HotSaleBinding
import com.gorosheg.mainscreen.databinding.ListOfHotSalesBinding

internal fun hotSalesDelegate() = adapterDelegate<HotSales, ListOfHotSalesBinding>(ListOfHotSalesBinding::inflate) {
    val hotSalesAdapter = CommonAdapter(hotSaleDelegate())
    salesCarousel.adapter = hotSalesAdapter

    bind {
        hotSalesAdapter.items = item.sales
    }
}

private fun hotSaleDelegate() = adapterDelegate<HotSale, HotSaleBinding>(HotSaleBinding::inflate) {
    bind {
        productName.text = item.name
        productDescription.text = item.description
        newBackground.isVisible = item.isNew
        newText.isVisible = item.isNew
    }
}