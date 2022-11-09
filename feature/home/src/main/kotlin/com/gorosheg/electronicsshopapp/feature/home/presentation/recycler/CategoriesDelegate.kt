package com.gorosheg.electronicsshopapp.feature.home.presentation.recycler

import androidx.core.content.ContextCompat
import com.gorosheg.common.R.*
import com.gorosheg.electronicsshopapp.common.recycler.CommonAdapter
import com.gorosheg.electronicsshopapp.common.recycler.adapterDelegate
import com.gorosheg.electronicsshopapp.feature.home.presentation.model.Category
import com.gorosheg.electronicsshopapp.feature.home.presentation.model.HomeItem
import com.gorosheg.mainscreen.databinding.CategoryBinding
import com.gorosheg.mainscreen.databinding.ListOfCategoriesBinding

internal fun categoriesDelegate() =
    adapterDelegate<HomeItem.Categories, ListOfCategoriesBinding>(ListOfCategoriesBinding::inflate) {
        val categoriesAdapter = CommonAdapter(categoryDelegate())
        categoryList.adapter = categoriesAdapter

        bind {
            categoriesAdapter.items = item.categories
        }
    }

private fun categoryDelegate() = adapterDelegate<Category, CategoryBinding>(CategoryBinding::inflate) {
    bind {
        categoryName.text = item.name

        val background =
            if (item.isEnabled) drawable.orange_circle_background
            else drawable.white_circle_background

        categoryBackground.background = ContextCompat.getDrawable(context, background)
        categoryImage.setImageResource(item.icon)
    }
}