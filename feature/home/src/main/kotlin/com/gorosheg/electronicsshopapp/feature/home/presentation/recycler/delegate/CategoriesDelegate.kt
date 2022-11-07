package com.gorosheg.electronicsshopapp.feature.home.presentation.recycler.delegate

import androidx.core.content.ContextCompat
import com.gorosheg.electronicsshopapp.feature.home.presentation.recycler.Category
import com.gorosheg.electronicsshopapp.feature.home.presentation.recycler.RecyclerItems
import com.gorosheg.mainscreen.R
import com.gorosheg.mainscreen.databinding.CategoryBinding
import com.gorosheg.mainscreen.databinding.ListOfCategoriesBinding

internal fun categoriesDelegate() = adapterDelegate<RecyclerItems.Categories, ListOfCategoriesBinding>(
    ListOfCategoriesBinding::inflate) {
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
            if (item.isEnabled) R.drawable.orange_circle_background
            else R.drawable.white_circle_background

        categoryBackground.background = ContextCompat.getDrawable(context, background)
        categoryImage.setImageResource(item.icon)
    }
}