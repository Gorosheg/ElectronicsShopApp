package com.gorosheg.electronicsshopapp.feature.mycart.presentation

import androidx.lifecycle.ViewModel
import com.gorosheg.electronicsshopapp.feature.mycart.domain.MyCartRepository
import com.gorosheg.electronicsshopapp.feature.mycart.presentation.model.MyCartViewState
import kotlinx.coroutines.flow.MutableStateFlow

internal class MyCartViewModel(private val repository: MyCartRepository) : ViewModel() {

    val state = MutableStateFlow(MyCartViewState())


}