package com.gorosheg.electronicsshopapp.feature.productdetails.presentation.recycler

import com.gorosheg.common.R
import com.gorosheg.electronicsshopapp.common.recycler.adapter
import com.gorosheg.electronicsshopapp.common.recycler.utils.setCompatBackground
import com.gorosheg.electronicsshopapp.feature.productdetails.presentation.model.CapacityItem
import com.gorosheg.productdetales.R.*
import com.gorosheg.productdetales.databinding.CapacityItemBinding

internal fun capacityDelegate(onCapacityClick: (Int) -> Unit) =
    adapter<CapacityItem, CapacityItemBinding>(CapacityItemBinding::inflate) {
        capacityValue.setOnClickListener { onCapacityClick.invoke(item.id) }

        bind {
            capacityValue.text = item.capacityValue + context.getString(string.gb_measure)

            if (item.isSelected) {
                capacityValue.setCompatBackground(R.drawable.background_orange_rect_radius_10)
                capacityValue.setTextColor(context.getColor(R.color.white))
            } else {
                capacityValue.setCompatBackground(R.drawable.background_white_rect_radius_10)
                capacityValue.setTextColor(R.color.deep_grey)
            }
        }
    }
