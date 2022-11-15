package com.gorosheg.electronicsshopapp.feature.mycart.presentation.recycler

import com.bumptech.glide.Glide
import com.gorosheg.electronicsshopapp.common.recycler.adapter
import com.gorosheg.electronicsshopapp.feature.mycart.presentation.model.BasketItem
import com.gorosheg.mycart.databinding.ProductItemBinding

internal fun cartDelegate(onSubtractClick: (id: Int) -> Unit, onAddClick: (id: Int) -> Unit) =
    adapter<BasketItem, ProductItemBinding>(ProductItemBinding::inflate) {
        bind {
            productTitle.text = item.title
            productPrice.text = "$${item.price}"
            amountOfProducts.text = item.amountOfItems.toString()

            Glide.with(root)
                .load(item.images)
                .into(productImage)

            subtractProduct.setOnClickListener { onSubtractClick.invoke(item.id) }
            addProduct.setOnClickListener { onAddClick.invoke(item.id) }
        }
    }
