package com.gorosheg.electronicsshopapp.feature.home.presentation.recycler

import com.gorosheg.electronicsshopapp.common.recycler.ListItem
import com.gorosheg.electronicsshopapp.common.recycler.adapterDelegate
import com.gorosheg.electronicsshopapp.feature.home.presentation.model.HomeItem
import com.gorosheg.mainscreen.databinding.HeaderWithTextBinding
import com.hannesdorfmann.adapterdelegates4.AdapterDelegate

internal fun headerDelegate() =
    adapterDelegate<HomeItem.Header, HeaderWithTextBinding>(HeaderWithTextBinding::inflate) {
        bind {
            title.text = context.getString(item.title)
            subtitle.text = context.getString(item.subtitle)
        }
    }