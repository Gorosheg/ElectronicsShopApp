package com.gorosheg.electronicsshopapp

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import com.gorosheg.electronicsshopapp.feature.home.navigator.HomeNavigator
import com.gorosheg.electronicsshopapp.feature.home.presentation.HomeFragment
import com.gorosheg.electronicsshopapp.feature.mycart.navigator.MyCartNavigator
import com.gorosheg.electronicsshopapp.feature.mycart.presentation.MyCartFragment
import com.gorosheg.electronicsshopapp.feature.productdetails.navigator.ProductDetailsNavigator
import com.gorosheg.electronicsshopapp.feature.productdetails.presentation.ProductDetailsFragment

private const val HOME = "HomeFragment"
private const val MYCART = "MyCartFragment"
private const val PRODUCTDETAILS = "ProductDetailsFragment"

class NavigatorImpl : MainNavigator, HomeNavigator, ProductDetailsNavigator, MyCartNavigator {
    override fun navigateToHome(activity: FragmentActivity) {
        val fragment = HomeFragment.newInstance()
        activity.navigateToNextFragment(fragment, HOME)
    }

    override fun navigateToProductDetails(activity: FragmentActivity) {
        val fragment = ProductDetailsFragment.newInstance()
        activity.navigateToNextFragment(fragment, PRODUCTDETAILS)
    }

    override fun navigateToMyCart(activity: FragmentActivity) {
        val fragment = MyCartFragment.newInstance()
        activity.navigateToNextFragment(fragment, MYCART)
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