package com.gorosheg.electronicsshopapp.feature.productdetails.presentation

import androidx.fragment.app.Fragment
import com.gorosheg.electronicsshopapp.feature.productdetails.navigator.ProductDetailsNavigator
import com.gorosheg.productdetales.R
import org.koin.android.ext.android.inject

class ProductDetailsFragment : Fragment(R.layout.fragment_product_details) {

    private val navigator: ProductDetailsNavigator by inject()

    companion object {
        fun newInstance() = ProductDetailsFragment()
    }
}