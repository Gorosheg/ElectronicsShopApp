package com.gorosheg.electronicsshopapp.navigator

import com.gorosheg.electronicsshopapp.feature.home.HomeNavigator
import com.gorosheg.electronicsshopapp.feature.cart.CartNavigator
import com.gorosheg.electronicsshopapp.feature.productdetails.ProductDetailsNavigator
import org.koin.dsl.module

val navigatorModule = module {
    single<MainNavigator> { get<NavigatorImpl>() }
    single<HomeNavigator> { get<NavigatorImpl>() }
    single<CartNavigator> { get<NavigatorImpl>() }
    single<ProductDetailsNavigator> { get<NavigatorImpl>() }
    single { NavigatorImpl() }
}