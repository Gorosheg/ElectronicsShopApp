package com.gorosheg.electronicsshopapp.feature.home.presentation.recycler

import com.gorosheg.electronicsshopapp.feature.home.presentation.recycler.delegate.ListItem
import org.w3c.dom.Text

internal sealed interface RecyclerItems : ListItem {

    object Search : RecyclerItems {

        override val id: String = "Search"
    }

    data class Header(
        val title: String,
        val subtitle: String,
    ) : RecyclerItems {

        override val id: String = title
    }
}