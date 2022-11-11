package com.gorosheg.electronicsshopapp.feature.home.presentation.recycler

import com.gorosheg.electronicsshopapp.common.recycler.adapterDelegate
import com.gorosheg.electronicsshopapp.feature.home.presentation.model.HomeItem
import com.gorosheg.mainscreen.databinding.SearchBinding

internal fun searchDelegate() = adapterDelegate<HomeItem.Search, SearchBinding>(SearchBinding::inflate)