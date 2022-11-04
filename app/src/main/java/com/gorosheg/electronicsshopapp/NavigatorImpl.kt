package com.gorosheg.electronicsshopapp

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import com.gorosheg.electronicsshopapp.feature.mainscreen.navigator.MainScreenNavigator
import com.gorosheg.electronicsshopapp.feature.mainscreen.presentation.MainFragment
import com.gorosheg.electronicsshopapp.feature.mycart.navigator.MyCartNavigator
import com.gorosheg.electronicsshopapp.feature.mycart.presentation.MyCartFragment
import com.gorosheg.electronicsshopapp.feature.productdetails.navigator.ProductDetailsNavigator
import com.gorosheg.electronicsshopapp.feature.productdetails.presentation.ProductDetailsFragment

private const val MAIN = "MainFragment"
private const val MYCART = "MyCartFragment"
private const val PRODUCTDETAILS = "ProductDetailsFragment"

class NavigatorImpl : MajorNavigator, MainScreenNavigator, MyCartNavigator, ProductDetailsNavigator {
    override fun navigateToMainScreen(activity: FragmentActivity) {
        val fragment = MainFragment.newInstance()
        activity.navigateToNextFragment(fragment, MAIN)
    }

    override fun navigateToMyCart(activity: FragmentActivity) {
        val fragment = MyCartFragment.newInstance()
        activity.navigateToNextFragment(fragment, MYCART)
    }

    override fun navigateToProductDetails(activity: FragmentActivity) {
        val fragment = ProductDetailsFragment.newInstance()
        activity.navigateToNextFragment(fragment, PRODUCTDETAILS)
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