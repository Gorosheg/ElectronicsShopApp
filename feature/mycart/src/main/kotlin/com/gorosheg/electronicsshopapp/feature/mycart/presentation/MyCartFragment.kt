package com.gorosheg.electronicsshopapp.feature.mycart.presentation

import androidx.fragment.app.Fragment
import com.gorosheg.electronicsshopapp.feature.mycart.navigator.MyCartNavigator
import com.gorosheg.mycart.R
import org.koin.android.ext.android.inject

class MyCartFragment : Fragment(R.layout.fragment_my_cart) {

    private val navigator: MyCartNavigator by inject()

    companion object {
        fun newInstance() = MyCartFragment()
    }
}