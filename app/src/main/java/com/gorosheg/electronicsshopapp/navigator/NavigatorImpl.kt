package com.gorosheg.electronicsshopapp.navigator

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import com.gorosheg.electronicsshopapp.R
import com.gorosheg.electronicsshopapp.feature.home.HomeNavigator
import com.gorosheg.electronicsshopapp.feature.home.presentation.HomeFragment
import com.gorosheg.electronicsshopapp.feature.cart.CartNavigator
import com.gorosheg.electronicsshopapp.feature.cart.presentation.CartFragment
import com.gorosheg.electronicsshopapp.feature.productdetails.ProductDetailsNavigator
import com.gorosheg.electronicsshopapp.feature.productdetails.presentation.ProductDetailsFragment

private const val HOME = "HomeFragment"
private const val CART = "CartFragment"
private const val PRODUCT_DETAILS = "ProductDetailsFragment"

class NavigatorImpl : MainNavigator, HomeNavigator, ProductDetailsNavigator, CartNavigator {

    override fun navigateToHome(activity: FragmentActivity) {
        val fragment = HomeFragment.newInstance()
        activity.navigateToNextFragment(fragment, HOME)
    }

    override fun navigateToProductDetails(activity: FragmentActivity) {
        val fragment = ProductDetailsFragment.newInstance()
        activity.navigateToNextFragment(fragment, PRODUCT_DETAILS)
    }

    override fun navigateToMyCart(activity: FragmentActivity) {
        val fragment = CartFragment.newInstance()
        activity.navigateToNextFragment(fragment, CART)
    }

    private fun FragmentActivity.navigateToNextFragment(fragment: Fragment, fragmentKey: String) {
        supportFragmentManager.beginTransaction().run {
            add(R.id.fragmentHolder, fragment)
            addToBackStack(fragmentKey)
            commit()
        }
    }

    override fun back(activity: FragmentActivity) {
        activity.supportFragmentManager.popBackStack()
    }
}