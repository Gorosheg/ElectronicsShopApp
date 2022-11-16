package com.gorosheg.electronicsshopapp.feature.productdetails.presentation

import android.os.Bundle
import android.view.View
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.GridLayoutManager
import by.kirich1409.viewbindingdelegate.viewBinding
import com.gorosheg.common.R.drawable
import com.gorosheg.electronicsshopapp.common.ZoomLinearLayoutManager
import com.gorosheg.electronicsshopapp.feature.productdetails.ProductDetailsNavigator
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

    private val colorAdapter = colorDelegate { viewModel.changeSelectedColor(it) }
    private val capacityAdapter = capacityDelegate { viewModel.changeSelectedCapacity(it) }
    private val imageAdapter = imageDelegate()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) = with(binding) {
        viewModel.state.onEach(::render).launchIn(lifecycleScope)

        colorsRecycler.layoutManager = GridLayoutManager(context, 2)
        colorsRecycler.adapter = colorAdapter

        capacityRecycler.layoutManager = GridLayoutManager(context, 2)
        capacityRecycler.adapter = capacityAdapter

        imagesRecycler.layoutManager = ZoomLinearLayoutManager(requireContext())
        imagesRecycler.adapter = imageAdapter

        cartButton.setOnClickListener { navigateToCartFragment() }
        backButton.setOnClickListener { navigateBackToHomeFragment() }
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

        cpu.text = state.cpu
        camera.text = state.camera
        ssd.text = state.ssd
        sd.text = state.sd
        price.text = getString(R.string.dollar) + state.price + getString(R.string.cents)
    }

    private fun setRating(state: ProductDetailsViewState) = with(binding) {
        star1.isVisible = state.rating >= AWFUL_RATING
        star2.isVisible = state.rating >= BAD_RATING
        star3.isVisible = state.rating >= MEDIUM_RATING
        star4.isVisible = state.rating >= GOOD_RATING
        star5.isVisible = state.rating >= GREAT_RATING
    }

    private fun navigateToCartFragment() {
        navigator.navigateToMyCart(requireActivity())
    }

    private fun navigateBackToHomeFragment() {
        navigator.back(requireActivity())
    }

    companion object {
        const val AWFUL_RATING = 1
        const val BAD_RATING = 2
        const val MEDIUM_RATING = 3
        const val GOOD_RATING = 4
        const val GREAT_RATING = 5

        fun newInstance() = ProductDetailsFragment()
    }
}