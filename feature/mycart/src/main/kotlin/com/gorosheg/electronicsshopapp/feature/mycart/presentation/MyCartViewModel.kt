package com.gorosheg.electronicsshopapp.feature.mycart.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.gorosheg.electronicsshopapp.feature.mycart.domain.MyCartRepository
import com.gorosheg.electronicsshopapp.feature.mycart.presentation.model.BasketItem
import com.gorosheg.electronicsshopapp.feature.mycart.presentation.model.CartViewState
import com.gorosheg.electronicsshopapp.feature.mycart.presentation.utils.countTotalPrice
import com.gorosheg.electronicsshopapp.feature.mycart.presentation.utils.toCartViewState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch

internal class MyCartViewModel(private val repository: MyCartRepository) : ViewModel() {

    val state = MutableStateFlow(CartViewState())

    init {
        viewModelScope.launch {
            state.value = getCart()
        }
    }

    fun subtractProduct(productId: Int) {
        val newBasket: List<BasketItem> = state.value.basket.subtractProduct(productId)
        updateBasket(newBasket)
    }

    fun addProduct(productId: Int) {
        val newBasket: List<BasketItem> = state.value.basket.addProduct(productId)
        updateBasket(newBasket)
    }

    private fun List<BasketItem>.subtractProduct(productId: Int): List<BasketItem> {
        return map { item ->
            item.copy(amountOfItems =
            if (item.id == productId && item.amountOfItems < 0) {
                item.amountOfItems - 1
            } else {
                item.amountOfItems
            })
        }
    }

    private fun List<BasketItem>.addProduct(productId: Int): List<BasketItem> {
        return map { item ->
            item.copy(amountOfItems =
            if (item.id == productId) {
                item.amountOfItems + 1
            } else {
                item.amountOfItems
            })
        }
    }

    private fun updateBasket(newBasket: List<BasketItem>) {
        val newTotalPrice = countTotalPrice(newBasket)
        val newState = state.value.copy(basket = newBasket, total = newTotalPrice)
        state.value = newState
    }

    private suspend fun getCart(): CartViewState {
        return repository.getCart().toCartViewState()
    }
}