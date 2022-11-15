package com.gorosheg.electronicsshopapp.network.model

import androidx.annotation.Keep
import com.google.gson.annotations.SerializedName

@Keep
data class ProductDetailsResponse(
    @SerializedName("CPU")
    val cpu: String,
    val camera: String,
    val capacity: List<String>,
    val color: List<String>,
    val images: List<String>,
    val isFavorites: Boolean,
    val price: Int,
    val rating: Double,
    val sd: String,
    val ssd: String,
    val title: String,
)