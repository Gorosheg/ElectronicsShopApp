package com.gorosheg.electronicsshopapp.feature.home.presentation.recycler.delegate

import com.gorosheg.electronicsshopapp.feature.home.presentation.recycler.HomeItem
import com.gorosheg.mainscreen.databinding.HeaderWithTextBinding
import com.hannesdorfmann.adapterdelegates4.AdapterDelegate

internal fun headerDelegate(): AdapterDelegate<List<ListItem>> {
    return adapterDelegate<HomeItem.Header, HeaderWithTextBinding>(HeaderWithTextBinding::inflate) {

        bind {
            this.binding.title.text = item.title
            this.binding.subtitle.text = item.subtitle
        }
    }
}