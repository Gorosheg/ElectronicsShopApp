package com.gorosheg.electronicsshopapp.network.model

import androidx.annotation.Keep
import com.google.gson.annotations.SerializedName

@Keep
data class HotSaleResponse(
    @SerializedName("is_new")
    val isNew: Boolean,
    val picture: String,
    val subtitle: String,
    val title: String
)