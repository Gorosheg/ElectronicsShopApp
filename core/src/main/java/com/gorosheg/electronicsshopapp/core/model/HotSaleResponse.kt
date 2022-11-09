package com.gorosheg.electronicsshopapp.core.model

import com.google.gson.annotations.SerializedName

data class HotSaleResponse(
    @SerializedName("is_new")
    val isNew: Boolean,
    val picture: String,
    val subtitle: String,
    val title: String
)