package com.gorosheg.electronicsshopapp.network.model

import androidx.annotation.Keep
import com.google.gson.annotations.SerializedName

@Keep
data class HomeResponse(
    @SerializedName("best_seller")
    val bestSellers: List<BestSellerResponse>,
    @SerializedName("home_store")
    val hotSales: List<HotSaleResponse>,
)