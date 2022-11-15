package com.gorosheg.electronicsshopapp.feature.home.presentation.model

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import com.gorosheg.electronicsshopapp.common.ListItem

internal class Category(
    val id: Int,
    @StringRes val name: Int,
    @DrawableRes val icon: Int,
    val isSelected: Boolean,
) : ListItem