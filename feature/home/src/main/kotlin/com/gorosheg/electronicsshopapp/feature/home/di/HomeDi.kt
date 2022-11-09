package com.gorosheg.electronicsshopapp.feature.home.di

import com.gorosheg.electronicsshopapp.feature.home.data.HomeRepositoryImpl
import com.gorosheg.electronicsshopapp.feature.home.domain.HomeRepository
import com.gorosheg.electronicsshopapp.feature.home.presentation.HomeViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val homeModule = module {
    viewModel {
        HomeViewModel(get())
    }

    factory<HomeRepository> {
        HomeRepositoryImpl(get())
    }
}