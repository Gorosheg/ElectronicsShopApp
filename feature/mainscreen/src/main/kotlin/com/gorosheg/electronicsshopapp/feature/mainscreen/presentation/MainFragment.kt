package com.gorosheg.electronicsshopapp.feature.mainscreen.presentation

import androidx.fragment.app.Fragment
import com.gorosheg.electronicsshopapp.feature.mainscreen.navigator.MainScreenNavigator
import com.gorosheg.mainscreen.R
import org.koin.android.ext.android.inject

class MainFragment : Fragment(R.layout.fragment_main) {

    private val navigator: MainScreenNavigator by inject()

    companion object {
        fun newInstance() = MainFragment()
    }
}