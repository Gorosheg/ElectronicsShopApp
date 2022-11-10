package com.gorosheg.electronicsshopapp.feature.productdetails.presentation.recycler

import androidx.core.content.ContextCompat
import com.gorosheg.common.R
import com.gorosheg.electronicsshopapp.common.recycler.adapter
import com.gorosheg.electronicsshopapp.feature.productdetails.presentation.model.CapacityItem
import com.gorosheg.productdetales.databinding.CapacityItemBinding

internal fun capacityDelegate() = adapter<CapacityItem, CapacityItemBinding>(CapacityItemBinding::inflate) {
    bind {
        capacityValue.text = item.capacityValue

        val background =
            if (item.isSelected) R.color.orange
            else R.color.white

        root.background = ContextCompat.getDrawable(context, background)
    }
}
