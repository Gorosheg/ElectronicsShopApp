package com.gorosheg.electronicsshopapp.feature.mycart.di

import com.gorosheg.electronicsshopapp.feature.mycart.data.MyCartRepositoryImpl
import com.gorosheg.electronicsshopapp.feature.mycart.domain.MyCartRepository
import com.gorosheg.electronicsshopapp.feature.mycart.presentation.MyCartViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val myCartDi = module {
    viewModel {
        MyCartViewModel(get())
    }

    factory<MyCartRepository> {
        MyCartRepositoryImpl(get())
    }
}