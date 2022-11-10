package com.gorosheg.electronicsshopapp.feature.productdetails.presentation.recycler

import androidx.core.view.isVisible
import androidx.recyclerview.widget.GridLayoutManager
import com.gorosheg.electronicsshopapp.common.recycler.CommonAdapter
import com.gorosheg.electronicsshopapp.common.recycler.ListItem
import com.gorosheg.electronicsshopapp.common.recycler.adapterDelegate
import com.gorosheg.electronicsshopapp.feature.productdetails.presentation.model.ColorItem
import com.gorosheg.electronicsshopapp.feature.productdetails.presentation.model.ProductDetailsItem.Color
import com.gorosheg.productdetales.databinding.ColorItemBinding
import com.gorosheg.productdetales.databinding.ListOfColorsBinding
import com.hannesdorfmann.adapterdelegates4.AdapterDelegate

internal fun colorDelegate() =
    adapterDelegate<Color, ListOfColorsBinding>(ListOfColorsBinding::inflate) {
        val colorsAdapter = CommonAdapter(colorItemDelegate())
        colorsRecycler.layoutManager = GridLayoutManager(context, 2)
        colorsRecycler.adapter = colorsAdapter

        bind {
            colorsAdapter.items = item.colors
        }
    }

private fun colorItemDelegate(): AdapterDelegate<List<ListItem>> {
    return adapterDelegate<ColorItem, ColorItemBinding>(ColorItemBinding::inflate) {
        bind {
            selected.isVisible = item.isSelected
            // root.background = item.colorValue
        }
    }
}