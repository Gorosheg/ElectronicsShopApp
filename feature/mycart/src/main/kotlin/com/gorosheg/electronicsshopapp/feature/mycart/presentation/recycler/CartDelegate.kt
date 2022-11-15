package com.gorosheg.electronicsshopapp.feature.mycart.presentation.recycler

import com.bumptech.glide.Glide
import com.gorosheg.electronicsshopapp.common.recycler.adapter
import com.gorosheg.electronicsshopapp.feature.mycart.presentation.model.CartBasketItem
import com.gorosheg.electronicsshopapp.network.model.ProductId
import com.gorosheg.mycart.databinding.ProductItemBinding

internal fun cartDelegate(onSubtractClick: (ProductId) -> Unit, onAddClick: (ProductId) -> Unit) =
    adapter<CartBasketItem, ProductItemBinding>(ProductItemBinding::inflate) {
        subtractProduct.setOnClickListener { onSubtractClick.invoke(item.id) }
        addProduct.setOnClickListener { onAddClick.invoke(item.id) }

        bind {
            productTitle.text = item.title
            productPrice.text = "$${item.price}"
            amountOfProducts.text = item.amountOfItems.toString()

            Glide.with(root)
                .load(item.images)
                .into(productImage)
        }
    }
