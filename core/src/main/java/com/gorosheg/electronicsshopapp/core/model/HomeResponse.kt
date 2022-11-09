package com.gorosheg.electronicsshopapp.core.model

import com.google.gson.annotations.SerializedName

data class HomeResponse(
    @SerializedName("best_seller")
    val bestSellers: List<BestSellerResponse>,
    @SerializedName("home_store")
    val hotSales: List<HotSaleResponse>
)