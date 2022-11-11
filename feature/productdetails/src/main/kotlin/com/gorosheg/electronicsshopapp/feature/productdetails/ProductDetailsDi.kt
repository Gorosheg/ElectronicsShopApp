package com.gorosheg.electronicsshopapp.feature.productdetails

import com.gorosheg.electronicsshopapp.feature.productdetails.data.ProductDetailsRepositoryImpl
import com.gorosheg.electronicsshopapp.feature.productdetails.domain.ProductDetailsRepository
import com.gorosheg.electronicsshopapp.feature.productdetails.presentation.ProductDetailsViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val productDetailsModule = module {
    viewModel {
        ProductDetailsViewModel(get())
    }

    factory<ProductDetailsRepository> {
        ProductDetailsRepositoryImpl(get())
    }
}