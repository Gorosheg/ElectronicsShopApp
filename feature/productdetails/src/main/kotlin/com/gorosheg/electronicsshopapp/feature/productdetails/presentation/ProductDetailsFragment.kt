package com.gorosheg.electronicsshopapp.feature.productdetails.presentation

import android.os.Bundle
import android.view.View
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.GridLayoutManager
import by.kirich1409.viewbindingdelegate.viewBinding
import com.gorosheg.common.R.drawable
import com.gorosheg.electronicsshopapp.feature.productdetails.navigator.ProductDetailsNavigator
import com.gorosheg.electronicsshopapp.feature.productdetails.presentation.model.ProductDetailsViewState
import com.gorosheg.electronicsshopapp.feature.productdetails.presentation.recycler.capacityDelegate
import com.gorosheg.electronicsshopapp.feature.productdetails.presentation.recycler.colorDelegate
import com.gorosheg.electronicsshopapp.feature.productdetails.presentation.recycler.imageDelegate
import com.gorosheg.productdetales.R
import com.gorosheg.productdetales.databinding.FragmentProductDetailsBinding
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import org.koin.android.ext.android.inject
import org.koin.androidx.viewmodel.ext.android.viewModel

class ProductDetailsFragment : Fragment(R.layout.fragment_product_details) {

    private val viewModel: ProductDetailsViewModel by viewModel()
    private val navigator: ProductDetailsNavigator by inject()
    private val binding: FragmentProductDetailsBinding by viewBinding()

    private val colorAdapter = colorDelegate()
    private val capacityAdapter = capacityDelegate()
    private val imageAdapter = imageDelegate()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) = with(binding) {
        viewModel.state.onEach(::render).launchIn(lifecycleScope)

        colorsRecycler.layoutManager = GridLayoutManager(context, 2)
        colorsRecycler.adapter = colorAdapter

        capacityRecycler.layoutManager = GridLayoutManager(context, 2)
        capacityRecycler.adapter = capacityAdapter
        imagesRecycler.adapter = imageAdapter
    }

    private fun render(state: ProductDetailsViewState) = with(binding) {
        colorAdapter.items = state.colors
        colorAdapter.notifyDataSetChanged()

        capacityAdapter.items = state.capacity
        capacityAdapter.notifyDataSetChanged()

        imageAdapter.items = state.images
        imageAdapter.notifyDataSetChanged()

        productName.text = state.title

        val like =
            if (state.isFavorite) drawable.ic_like_filled
            else drawable.ic_like_white

        addToFavorites.setImageResource(like)
        setRating(state)

        CPU.text = state.CPU
        camera.text = state.camera
        ssd.text = state.ssd
        sd.text = state.sd
        price.text = state.price.toString()
    }

    private fun setRating(state: ProductDetailsViewState) = with(binding) {
        when (state.rating) {
            0 -> {
                star1.isVisible = false
                star2.isVisible = false
                star3.isVisible = false
                star4.isVisible = false
                star5.isVisible = false
            }
            1 -> {
                star2.isVisible = false
                star3.isVisible = false
                star4.isVisible = false
                star5.isVisible = false
            }
            2 -> {
                star3.isVisible = false
                star4.isVisible = false
                star5.isVisible = false
            }
            3 -> {
                star4.isVisible = false
                star5.isVisible = false
            }
            4 -> {
                star5.isVisible = false
            }
            else -> {}
        }
    }

    companion object {
        fun newInstance() = ProductDetailsFragment()
    }
}