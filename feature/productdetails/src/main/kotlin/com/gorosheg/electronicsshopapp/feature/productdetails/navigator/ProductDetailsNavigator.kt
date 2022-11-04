package com.gorosheg.electronicsshopapp.feature.productdetails.navigator

import androidx.fragment.app.FragmentActivity

interface ProductDetailsNavigator {
    fun navigateToMyCart(activity: FragmentActivity)

    fun back(activity: FragmentActivity)
}