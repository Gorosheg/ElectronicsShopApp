package com.gorosheg.electronicsshopapp.feature.home.presentation.recycler

import androidx.core.content.ContextCompat
import com.gorosheg.common.R
import com.gorosheg.electronicsshopapp.common.recycler.adapter
import com.gorosheg.electronicsshopapp.common.recycler.adapterDelegate
import com.gorosheg.electronicsshopapp.feature.home.presentation.model.Category
import com.gorosheg.electronicsshopapp.feature.home.presentation.model.HomeItem
import com.gorosheg.mainscreen.databinding.CategoryBinding
import com.gorosheg.mainscreen.databinding.ListOfCategoriesBinding

internal fun categoriesDelegate() =
    adapterDelegate<HomeItem.Categories, ListOfCategoriesBinding>(ListOfCategoriesBinding::inflate) {
        val categoriesAdapter = categoryAdapter()
        categoryList.adapter = categoriesAdapter

        bind {
            categoriesAdapter.items = item.categories
        }
    }

private fun categoryAdapter() = adapter<Category, CategoryBinding>(CategoryBinding::inflate) {
    bind {
        categoryName.text = item.name

        val background =
            if (item.isEnabled) R.drawable.background_orange_circle
            else R.drawable.background_white_circle

        categoryBackground.background = ContextCompat.getDrawable(context, background)
        categoryImage.setImageResource(item.icon)
    }
}