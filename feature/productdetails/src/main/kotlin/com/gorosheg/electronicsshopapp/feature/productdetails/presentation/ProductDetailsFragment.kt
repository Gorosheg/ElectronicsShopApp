package com.gorosheg.electronicsshopapp.feature.productdetails.presentation

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import by.kirich1409.viewbindingdelegate.viewBinding
import com.gorosheg.electronicsshopapp.common.recycler.CommonAdapter
import com.gorosheg.electronicsshopapp.feature.productdetails.navigator.ProductDetailsNavigator
import com.gorosheg.electronicsshopapp.feature.productdetails.presentation.model.ProductDetailsViewState
import com.gorosheg.electronicsshopapp.feature.productdetails.presentation.recycler.capacityDelegate
import com.gorosheg.electronicsshopapp.feature.productdetails.presentation.recycler.colorDelegate
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

    private val colorCapacityAdapter = CommonAdapter(
        colorDelegate(),
        capacityDelegate()
    )

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) = with(binding) {
        viewModel.state.onEach(::render).launchIn(lifecycleScope)
        colorsCapacityRecycler.adapter = colorCapacityAdapter
    }

    private fun render(state: ProductDetailsViewState) {
        colorCapacityAdapter.items = state.items
        colorCapacityAdapter.notifyDataSetChanged()
    }

    companion object {
        fun newInstance() = ProductDetailsFragment()
    }
}