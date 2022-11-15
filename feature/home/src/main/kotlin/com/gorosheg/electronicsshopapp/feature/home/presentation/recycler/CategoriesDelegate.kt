package com.gorosheg.electronicsshopapp.feature.home.presentation.recycler

import android.graphics.PorterDuff.Mode
import androidx.annotation.ColorRes
import androidx.annotation.DrawableRes
import androidx.core.content.ContextCompat
import com.gorosheg.common.R
import com.gorosheg.electronicsshopapp.common.recycler.adapter
import com.gorosheg.electronicsshopapp.common.recycler.adapterDelegate
import com.gorosheg.electronicsshopapp.common.recycler.utils.setCompatBackground
import com.gorosheg.electronicsshopapp.feature.home.presentation.model.Category
import com.gorosheg.electronicsshopapp.feature.home.presentation.model.HomeItem
import com.gorosheg.mainscreen.databinding.CategoryBinding
import com.gorosheg.mainscreen.databinding.ListOfCategoriesBinding
import com.hannesdorfmann.adapterdelegates4.dsl.AdapterDelegateViewBindingViewHolder

internal typealias CategoryAdapter = AdapterDelegateViewBindingViewHolder<Category, CategoryBinding>

internal fun categoriesDelegate(onCategoryClick: (Int) -> Unit) =
    adapterDelegate<HomeItem.Categories, ListOfCategoriesBinding>(ListOfCategoriesBinding::inflate) {
        val categoriesAdapter = categoryAdapter(onCategoryClick)
        categoryList.adapter = categoriesAdapter

        bind {
            categoriesAdapter.items = item.categories
            categoriesAdapter.notifyDataSetChanged()
        }
    }

private fun categoryAdapter(onCategoryClick: (Int) -> Unit) =
    adapter<Category, CategoryBinding>(CategoryBinding::inflate) {
        categoryBackground.setOnClickListener { onCategoryClick.invoke(item.id) }

        bind {
            categoryName.setText(item.name)
            categoryImage.setImageResource(item.icon)

            if (item.isSelected) {
                selectCategory(R.drawable.background_orange_circle, R.color.orange, R.color.white)
            } else {
                selectCategory(R.drawable.background_white_circle, R.color.text_dark_color, R.color.light_grey)
            }
        }
    }

context(CategoryBinding) internal fun CategoryAdapter.selectCategory(
    @DrawableRes background: Int,
    @ColorRes nameColor: Int,
    @ColorRes imageColor: Int,
) {
    categoryBackground.setCompatBackground(background)
    categoryName.setTextColor(context.getColor(nameColor))
    categoryImage.setColorFilter(ContextCompat.getColor(context, imageColor), Mode.SRC_IN)
}