package com.gorosheg.electronicsshopapp.feature.productdetails.presentation.recycler

import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.GridLayoutManager
import com.gorosheg.common.R
import com.gorosheg.electronicsshopapp.common.recycler.CommonAdapter
import com.gorosheg.electronicsshopapp.common.recycler.adapterDelegate
import com.gorosheg.electronicsshopapp.feature.productdetails.presentation.model.CapacityItem
import com.gorosheg.electronicsshopapp.feature.productdetails.presentation.model.ProductDetailsItem.Capacity
import com.gorosheg.productdetales.databinding.CapacityItemBinding
import com.gorosheg.productdetales.databinding.ListOfCapacityBinding

internal fun capacityDelegate() =
    adapterDelegate<Capacity, ListOfCapacityBinding>(ListOfCapacityBinding::inflate) {
        val capacityAdapter = CommonAdapter(capacityItemDelegate())
        capacityRecycler.layoutManager = GridLayoutManager(context, 2)
        capacityRecycler.adapter = capacityAdapter

        bind {
            capacityAdapter.items = item.capacity
        }
    }

private fun capacityItemDelegate() = adapterDelegate<CapacityItem, CapacityItemBinding>(CapacityItemBinding::inflate) {
    bind {
        capacityValue.text = item.capacityValue

        val background =
            if (item.isSelected) R.color.orange
            else R.color.white

        root.background = ContextCompat.getDrawable(context, background)
    }
}
