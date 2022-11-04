package com.gorosheg.electronicsshopapp.feature.home.presentation

import androidx.fragment.app.Fragment
import com.gorosheg.electronicsshopapp.feature.home.navigator.HomeNavigator
import com.gorosheg.mainscreen.R
import org.koin.android.ext.android.inject

class HomeFragment : Fragment(R.layout.fragment_home) {

    private val navigator: HomeNavigator by inject()

    companion object {
        fun newInstance() = HomeFragment()
    }
}