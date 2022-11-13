package com.gorosheg.electronicsshopapp.feature.home.presentation.recycler

import androidx.core.view.isVisible
import com.bumptech.glide.Glide
import com.gorosheg.electronicsshopapp.common.recycler.adapter
import com.gorosheg.electronicsshopapp.common.recycler.adapterDelegate
import com.gorosheg.electronicsshopapp.feature.home.presentation.model.HotSale
import com.gorosheg.electronicsshopapp.feature.home.presentation.model.HomeItem.HotSales
import com.gorosheg.mainscreen.databinding.HotSaleBinding
import com.gorosheg.mainscreen.databinding.ListOfHotSalesBinding

internal fun hotSalesDelegate() = adapterDelegate<HotSales, ListOfHotSalesBinding>(ListOfHotSalesBinding::inflate) {
    val hotSalesAdapter = hotSaleAdapter()
    salesCarousel.adapter = hotSalesAdapter

    bind {
        hotSalesAdapter.items = item.sales
        hotSalesAdapter.notifyDataSetChanged()
    }
}

private fun hotSaleAdapter() = adapter<HotSale, HotSaleBinding>(HotSaleBinding::inflate) {
    bind {
        productName.text = item.name
        productDescription.text = item.description
        newBackground.isVisible = item.isNew
        newText.isVisible = item.isNew

        Glide.with(root)
            .load(item.image)
            .into(productImage)
    }
}