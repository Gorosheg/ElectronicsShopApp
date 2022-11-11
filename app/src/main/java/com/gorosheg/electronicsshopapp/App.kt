package com.gorosheg.electronicsshopapp

import android.app.Application
import com.gorosheg.electronicsshopapp.network.networkModule
import com.gorosheg.electronicsshopapp.feature.home.di.homeModule
import com.gorosheg.electronicsshopapp.feature.mycart.di.myCartDi
import com.gorosheg.electronicsshopapp.feature.productdetails.di.productDetailsModule
import com.gorosheg.electronicsshopapp.navigator.navigatorModule
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
                myCartDi
            )
        }
    }
}