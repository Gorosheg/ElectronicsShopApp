package com.gorosheg.electronicsshopapp.feature.home.presentation.recycler.delegate

import com.gorosheg.electronicsshopapp.feature.home.presentation.recycler.RecyclerItems
import com.gorosheg.mainscreen.databinding.HeaderWithTextBinding

internal fun headerDelegate() = adapterDelegate<RecyclerItems.Header, HeaderWithTextBinding>(HeaderWithTextBinding::inflate) {

    bind {
        this.binding.title.text = item.title
        this.binding.subtitle.text = item.subtitle
    }
}