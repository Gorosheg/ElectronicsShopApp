package com.gorosheg.electronicsshopapp.core.model

import com.google.gson.annotations.SerializedName

data class BestSellerResponse(
    @SerializedName("discount_price")
    val discountPrice: Int,
    @SerializedName("is_favorites")
    val isFavorites: Boolean,
    val picture: String,
    @SerializedName("price_without_discount")
    val priceWithoutDiscount: Int,
    val title: String,
)