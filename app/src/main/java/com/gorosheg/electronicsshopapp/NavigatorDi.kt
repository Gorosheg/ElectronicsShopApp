package com.gorosheg.electronicsshopapp

import com.gorosheg.electronicsshopapp.feature.home.navigator.HomeNavigator
import com.gorosheg.electronicsshopapp.feature.mycart.navigator.MyCartNavigator
import com.gorosheg.electronicsshopapp.feature.productdetails.navigator.ProductDetailsNavigator
import org.koin.dsl.module

val navigatorModule = module {
    single<MainNavigator> { get<NavigatorImpl>() }
    single<HomeNavigator> { get<NavigatorImpl>() }
    single<MyCartNavigator> { get<NavigatorImpl>() }
    single<ProductDetailsNavigator> { get<NavigatorImpl>() }
    single { NavigatorImpl() }
}