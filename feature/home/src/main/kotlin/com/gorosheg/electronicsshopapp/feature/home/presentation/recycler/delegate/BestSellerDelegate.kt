package com.gorosheg.electronicsshopapp.feature.home.presentation.recycler.delegate

import androidx.recyclerview.widget.GridLayoutManager
import com.gorosheg.electronicsshopapp.feature.home.presentation.recycler.BestSellerProduct
import com.gorosheg.electronicsshopapp.feature.home.presentation.recycler.HomeItem
import com.gorosheg.mainscreen.R
import com.gorosheg.mainscreen.databinding.BestSellerProductBinding
import com.gorosheg.mainscreen.databinding.ListOfBestSellerBinding

internal fun bestSellerDelegate() = adapterDelegate<HomeItem.BestSeller, ListOfBestSellerBinding>(
    ListOfBestSellerBinding::inflate) {
    val bestSellerAdapter = CommonAdapter(bestSellerProductDelegate())
    bestSellerList.layoutManager = GridLayoutManager(context, 2)
    bestSellerList.adapter = bestSellerAdapter

    bind {
        bestSellerAdapter.items = item.products
    }
}

private fun bestSellerProductDelegate() =
    adapterDelegate<BestSellerProduct, BestSellerProductBinding>(BestSellerProductBinding::inflate) {
        bind {
            productName.text = item.name
            productPrice.text = item.price
            productPriceWithoutSale.text = item.priceWithoutSale

            val likeImage =
                if (item.isLiked) R.drawable.ic_like_2
                else R.drawable.ic_like_1

            like.setImageResource(likeImage)
        }
    }