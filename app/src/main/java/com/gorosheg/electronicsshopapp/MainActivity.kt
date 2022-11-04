package com.gorosheg.electronicsshopapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import org.koin.android.ext.android.inject

class MainActivity : AppCompatActivity() {

    private val navigator: MajorNavigator by inject()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        createMainFragment()
    }

    private fun createMainFragment() {
        navigator.navigateToMainScreen(this)
    }
}