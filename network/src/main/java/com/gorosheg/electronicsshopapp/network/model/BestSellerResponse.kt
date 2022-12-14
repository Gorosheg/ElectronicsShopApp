package com.gorosheg.electronicsshopapp.network.model

import androidx.annotation.Keep
import com.google.gson.annotations.SerializedName

@Keep
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