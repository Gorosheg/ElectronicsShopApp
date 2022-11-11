package com.gorosheg.electronicsshopapp.feature.mycart.presentation.recycler

import com.bumptech.glide.Glide
import com.gorosheg.electronicsshopapp.common.recycler.adapter
import com.gorosheg.electronicsshopapp.feature.mycart.presentation.model.BasketItem
import com.gorosheg.mycart.databinding.ProductItemBinding

internal fun cartDelegate() = adapter<BasketItem, ProductItemBinding>(ProductItemBinding::inflate) {
    bind {
        productTitle.text = item.title
        productPrice.text = "\$ ${item.price}"
        //   amountOfProducts.text

        Glide.with(root)
            .load(item.images)
            .into(productImage)
    }
}
