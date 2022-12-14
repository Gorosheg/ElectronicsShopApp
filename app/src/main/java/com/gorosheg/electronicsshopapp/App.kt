package com.gorosheg.electronicsshopapp

import android.app.Application
import com.gorosheg.electronicsshopapp.feature.home.homeModule
import com.gorosheg.electronicsshopapp.feature.cart.cartDi
import com.gorosheg.electronicsshopapp.feature.productdetails.productDetailsModule
import com.gorosheg.electronicsshopapp.navigator.navigatorModule
import com.gorosheg.electronicsshopapp.network.networkModule
import org.koin.core.context.startKoin

class App : Application() {

    override fun onCreate() {
        super.onCreate()

        startKoin {
            modules(
                navigatorModule,
                networkModule,
                homeModule,
                productDetailsModule,
                cartDi
            )
        }
    }
}