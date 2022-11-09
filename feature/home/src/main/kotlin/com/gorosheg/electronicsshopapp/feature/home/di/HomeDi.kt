package com.gorosheg.electronicsshopapp.feature.home.di

import com.gorosheg.electronicsshopapp.core.ElectronicsShopApi
import com.gorosheg.electronicsshopapp.feature.home.data.HomeRepositoryImpl
import com.gorosheg.electronicsshopapp.feature.home.domain.HomeInteractor
import com.gorosheg.electronicsshopapp.feature.home.domain.HomeInteractorImpl
import com.gorosheg.electronicsshopapp.feature.home.domain.HomeRepository
import com.gorosheg.electronicsshopapp.feature.home.presentation.HomeViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val homeModule = module {
    viewModel {
        HomeViewModel(get<HomeInteractor>())
    }

    factory<HomeInteractor> {
        HomeInteractorImpl(get<HomeRepository>())
    }

    factory<HomeRepository> {
        HomeRepositoryImpl(get<ElectronicsShopApi>())
    }
}