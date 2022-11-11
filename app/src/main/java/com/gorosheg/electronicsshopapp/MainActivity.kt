package com.gorosheg.electronicsshopapp

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.gorosheg.electronicsshopapp.navigator.MainNavigator
import org.koin.android.ext.android.inject

class MainActivity : AppCompatActivity() {

    private val navigator: MainNavigator by inject()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        createHomeFragment()
    }

    private fun createHomeFragment() {
        navigator.navigateToHome(this)
    }
}