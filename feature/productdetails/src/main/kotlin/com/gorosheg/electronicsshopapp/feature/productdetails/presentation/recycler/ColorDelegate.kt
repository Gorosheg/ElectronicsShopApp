package com.gorosheg.electronicsshopapp.feature.productdetails.presentation.recycler

import android.graphics.Color
import androidx.core.view.isVisible
import com.gorosheg.electronicsshopapp.common.recycler.adapter
import com.gorosheg.electronicsshopapp.feature.productdetails.presentation.model.ColorItem
import com.gorosheg.productdetales.databinding.ColorItemBinding

internal fun colorDelegate(onColorClick: (Int) -> Unit) =
    adapter<ColorItem, ColorItemBinding>(ColorItemBinding::inflate) {
        root.setOnClickListener { onColorClick.invoke(item.id) }

        bind {
            selected.isVisible = item.isSelected
            root.setCardBackgroundColor(Color.parseColor(item.colorValue))
        }
    }
