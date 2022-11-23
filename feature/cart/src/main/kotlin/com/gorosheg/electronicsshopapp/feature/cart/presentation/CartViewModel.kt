package com.gorosheg.electronicsshopapp.feature.cart.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.gorosheg.electronicsshopapp.feature.cart.domain.CartRepository
import com.gorosheg.electronicsshopapp.feature.cart.presentation.model.CartBasketItem
import com.gorosheg.electronicsshopapp.feature.cart.presentation.model.CartViewState
import com.gorosheg.electronicsshopapp.feature.cart.presentation.utils.countTotalPrice
import com.gorosheg.electronicsshopapp.feature.cart.presentation.utils.toCartViewState
import com.gorosheg.electronicsshopapp.network.model.ProductId
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch

internal class CartViewModel(private val repository: CartRepository) : ViewModel() {

    val state = MutableStateFlow(CartViewState())

    init {
        viewModelScope.launch {
            state.value = getCart()
        }
    }

    fun subtractProduct(id: ProductId) {
        val newBasket = state.value.basket.subtractProduct(id)
        updateBasket(newBasket)
    }

    fun addProduct(id: ProductId) {
        val newBasket = state.value.basket.addProduct(id)
        updateBasket(newBasket)
    }

    private fun List<CartBasketItem>.subtractProduct(id: ProductId): List<CartBasketItem> {
        return map { item ->
            val amountOfItems =
                if (item.id == id && item.amountOfItems > 1) item.amountOfItems - 1
                else item.amountOfItems

            item.copy(amountOfItems = amountOfItems)
        }
    }

    private fun List<CartBasketItem>.addProduct(id: ProductId): List<CartBasketItem> {
        return map { item ->
            val amountOfItems =
                if (item.id == id) item.amountOfItems + 1
                else item.amountOfItems

            item.copy(amountOfItems = amountOfItems)
        }
    }

    private fun updateBasket(newBasket: List<CartBasketItem>) {
        val newTotalPrice = countTotalPrice(newBasket)
        val newState = state.value.copy(basket = newBasket, total = newTotalPrice)
        state.value = newState
    }

    private suspend fun getCart(): CartViewState {
        return repository.getCart().toCartViewState()
    }
}