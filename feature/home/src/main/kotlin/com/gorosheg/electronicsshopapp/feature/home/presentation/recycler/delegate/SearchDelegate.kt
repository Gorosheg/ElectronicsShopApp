package com.gorosheg.electronicsshopapp.feature.home.presentation.recycler.delegate

import com.gorosheg.electronicsshopapp.feature.home.presentation.recycler.RecyclerItems
import com.gorosheg.mainscreen.databinding.SearchBinding


internal fun searchDelegate() = adapterDelegate<RecyclerItems.Search, SearchBinding>(SearchBinding::inflate) {}