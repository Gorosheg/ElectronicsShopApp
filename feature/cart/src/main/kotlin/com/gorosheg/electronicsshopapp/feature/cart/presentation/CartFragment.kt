package com.gorosheg.electronicsshopapp.feature.cart.presentation

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import by.kirich1409.viewbindingdelegate.viewBinding
import com.gorosheg.electronicsshopapp.feature.cart.CartNavigator
import com.gorosheg.electronicsshopapp.feature.cart.presentation.model.CartViewState
import com.gorosheg.electronicsshopapp.feature.cart.presentation.recycler.cartAdapter
import com.gorosheg.mycart.R
import com.gorosheg.mycart.databinding.FragmentCartBinding
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import org.koin.android.ext.android.inject
import org.koin.androidx.viewmodel.ext.android.viewModel

class CartFragment : Fragment(R.layout.fragment_cart) {

    private val viewModel: CartViewModel by viewModel()
    private val navigator: CartNavigator by inject()
    private val binding: FragmentCartBinding by viewBinding()

    private val cartItemsAdapter = cartAdapter(
        onSubtractClick = { viewModel.subtractProduct(it) },
        onAddClick = { viewModel.addProduct(it) }
    )

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) = with(binding) {
        viewModel.state.onEach(::render).launchIn(lifecycleScope)
        productsRecycler.adapter = cartItemsAdapter
        backButton.setOnClickListener { navigateBackToProductDetailsFragment() }
    }

    private fun render(state: CartViewState) = with(binding) {
        cartItemsAdapter.items = state.basket
        cartItemsAdapter.notifyDataSetChanged()

        totalCoast.text = getString(R.string.dollar) + state.total + getString(R.string.us_country_code)
        deliveryCoast.text = state.delivery
    }

    private fun navigateBackToProductDetailsFragment() {
        navigator.back(requireActivity())
    }

    companion object {
        fun newInstance() = CartFragment()
    }
}