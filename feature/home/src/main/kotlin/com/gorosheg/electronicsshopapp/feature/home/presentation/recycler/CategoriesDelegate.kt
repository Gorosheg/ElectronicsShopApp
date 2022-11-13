package com.gorosheg.electronicsshopapp.feature.home.presentation.recycler

import android.graphics.PorterDuff
import com.gorosheg.common.R
import com.gorosheg.electronicsshopapp.common.recycler.adapter
import com.gorosheg.electronicsshopapp.common.recycler.adapterDelegate
import com.gorosheg.electronicsshopapp.common.recycler.utils.setCompatBackground
import com.gorosheg.electronicsshopapp.feature.home.presentation.model.Category
import com.gorosheg.electronicsshopapp.feature.home.presentation.model.HomeItem
import com.gorosheg.mainscreen.databinding.CategoryBinding
import com.gorosheg.mainscreen.databinding.ListOfCategoriesBinding

internal fun categoriesDelegate(onCategoryClick: (Category) -> Unit) =
    adapterDelegate<HomeItem.Categories, ListOfCategoriesBinding>(ListOfCategoriesBinding::inflate) {
        val categoriesAdapter = categoryAdapter(onCategoryClick)
        categoryList.adapter = categoriesAdapter

        bind {
            categoriesAdapter.items = item.categories
            categoriesAdapter.notifyDataSetChanged()
        }
    }

private fun categoryAdapter(onCategoryClick: (Category) -> Unit) =
    adapter<Category, CategoryBinding>(CategoryBinding::inflate) {
        bind {
            categoryName.text = item.name
            categoryImage.setImageResource(item.icon)

            categoryBackground.setOnClickListener { onCategoryClick.invoke(item) }

            if (item.isSelected) {
                categoryBackground.setCompatBackground(R.drawable.background_orange_circle)
                categoryName.setTextColor(R.color.orange)
                categoryImage.setColorFilter(R.color.white, PorterDuff.Mode.SRC_ATOP)
            } else {
                categoryBackground.setCompatBackground(R.drawable.background_white_circle)
                categoryName.setTextColor(R.color.text_dark_color)
                categoryImage.setColorFilter(R.color.deep_grey, PorterDuff.Mode.SRC_ATOP)
            }
        }
    }