package com.gorosheg.electronicsshopapp.feature.mycart.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.gorosheg.electronicsshopapp.feature.mycart.domain.MyCartRepository
import com.gorosheg.electronicsshopapp.feature.mycart.presentation.model.BasketItem
import com.gorosheg.electronicsshopapp.feature.mycart.presentation.model.MyCartViewState
import com.gorosheg.electronicsshopapp.network.model.BasketResponse
import com.gorosheg.electronicsshopapp.network.model.CartResponse
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch

internal class MyCartViewModel(private val repository: MyCartRepository) : ViewModel() {

    val state = MutableStateFlow(MyCartViewState())

    init {
        viewModelScope.launch {
            state.value = getMyCart()
        }
    }

    private suspend fun getMyCart(): MyCartViewState {
        return repository.getMyCart().toUiCart()
    }

    private fun CartResponse.toUiCart(): MyCartViewState {
        return MyCartViewState(
            basket = getUiBasket(basket),
            delivery = delivery,
            id = id,
            total = total
        )
    }

    private fun getUiBasket(baskets: List<BasketResponse>): List<BasketItem> {
        return baskets.map { item ->
            BasketItem(
                id = item.id,
                images = item.images,
                title = item.title,
                price = item.price
            )
        }
    }
}