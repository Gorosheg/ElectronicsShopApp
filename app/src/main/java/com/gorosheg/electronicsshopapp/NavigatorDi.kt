package com.gorosheg.electronicsshopapp

import com.gorosheg.electronicsshopapp.feature.mainscreen.navigator.MainScreenNavigator
import com.gorosheg.electronicsshopapp.feature.mycart.navigator.MyCartNavigator
import com.gorosheg.electronicsshopapp.feature.productdetails.navigator.ProductDetailsNavigator
import org.koin.dsl.module

val navigatorModule = module {
    single<MajorNavigator> { get<NavigatorImpl>() }
    single<MainScreenNavigator> { get<NavigatorImpl>() }
    single<MyCartNavigator> { get<NavigatorImpl>() }
    single<ProductDetailsNavigator> { get<NavigatorImpl>() }
    single { NavigatorImpl() }
}