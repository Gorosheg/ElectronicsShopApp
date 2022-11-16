package com.gorosheg.electronicsshopapp.feature.cart

import com.gorosheg.electronicsshopapp.feature.cart.data.CartRepositoryImpl
import com.gorosheg.electronicsshopapp.feature.cart.domain.CartRepository
import com.gorosheg.electronicsshopapp.feature.cart.presentation.CartViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val cartDi = module {
    viewModel {
        CartViewModel(get())
    }

    factory<CartRepository> {
        CartRepositoryImpl(get())
    }
}