package com.gorosheg.electronicsshopapp.feature.productdetails.presentation.recycler

import com.bumptech.glide.Glide
import com.gorosheg.electronicsshopapp.common.recycler.adapter
import com.gorosheg.electronicsshopapp.feature.productdetails.presentation.model.ImageItem
import com.gorosheg.productdetales.databinding.ProductImageBinding

internal fun imageDelegate() = adapter<ImageItem, ProductImageBinding>(ProductImageBinding::inflate) {
    bind {
        Glide.with(root)
            .load(item.image)
            .into(productImage)
    }
}