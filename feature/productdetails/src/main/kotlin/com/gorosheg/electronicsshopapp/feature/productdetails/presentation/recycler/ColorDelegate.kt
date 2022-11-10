package com.gorosheg.electronicsshopapp.feature.productdetails.presentation.recycler

import androidx.core.view.isVisible
import com.gorosheg.electronicsshopapp.common.recycler.adapter
import com.gorosheg.electronicsshopapp.feature.productdetails.presentation.model.ColorItem
import com.gorosheg.productdetales.databinding.ColorItemBinding

internal fun colorDelegate() = adapter<ColorItem, ColorItemBinding>(ColorItemBinding::inflate) {
    bind {
        selected.isVisible = item.isSelected
        // root.background = item.colorValue
    }
}
