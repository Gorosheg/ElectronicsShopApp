package com.gorosheg.electronicsshopapp.navigator

import com.gorosheg.electronicsshopapp.feature.home.HomeNavigator
import com.gorosheg.electronicsshopapp.feature.mycart.MyCartNavigator
import com.gorosheg.electronicsshopapp.feature.productdetails.ProductDetailsNavigator
import org.koin.dsl.module

val navigatorModule = module {
    single<MainNavigator> { get<NavigatorImpl>() }
    single<HomeNavigator> { get<NavigatorImpl>() }
    single<MyCartNavigator> { get<NavigatorImpl>() }
    single<ProductDetailsNavigator> { get<NavigatorImpl>() }
    single { NavigatorImpl() }
}