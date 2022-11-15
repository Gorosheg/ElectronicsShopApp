package com.gorosheg.electronicsshopapp.feature.home.presentation.recycler

import android.graphics.Paint
import androidx.recyclerview.widget.GridLayoutManager
import com.bumptech.glide.Glide
import com.gorosheg.common.R.drawable
import com.gorosheg.electronicsshopapp.common.recycler.adapter
import com.gorosheg.electronicsshopapp.common.recycler.adapterDelegate
import com.gorosheg.electronicsshopapp.feature.home.presentation.model.BestSellerProduct
import com.gorosheg.electronicsshopapp.feature.home.presentation.model.HomeItem
import com.gorosheg.mainscreen.databinding.BestSellerProductBinding
import com.gorosheg.mainscreen.databinding.ListOfBestSellerBinding

internal fun bestSellerDelegate(onProductClick: () -> Unit) =
    adapterDelegate<HomeItem.BestSeller, ListOfBestSellerBinding>(ListOfBestSellerBinding::inflate) {
        val bestSellerAdapter = bestSellerProductDelegate(onProductClick)
        bestSellerList.layoutManager = GridLayoutManager(context, 2)
        bestSellerList.adapter = bestSellerAdapter

        bind {
            bestSellerAdapter.items = item.products
            bestSellerAdapter.notifyDataSetChanged()
        }
    }

private fun bestSellerProductDelegate(onProductClick: () -> Unit) =
    adapter<BestSellerProduct, BestSellerProductBinding>(BestSellerProductBinding::inflate) {
        root.setOnClickListener { onProductClick.invoke() }

        bind {
            productName.text = item.name
            productPrice.text = item.price
            productPriceWithoutSale.text = item.priceWithoutSale

            val likeImage =
                if (item.isLiked) drawable.ic_like_filled
                else drawable.ic_like_orange

            like.setImageResource(likeImage)

            Glide.with(root)
                .load(item.image)
                .into(productImage)

            productPriceWithoutSale.paintFlags = productPriceWithoutSale.paintFlags or Paint.STRIKE_THRU_TEXT_FLAG
        }
    }