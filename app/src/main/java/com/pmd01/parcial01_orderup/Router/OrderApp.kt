package com.pmd01.parcial01_orderup.Router

import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.navigation3.runtime.*
import androidx.navigation3.ui.NavDisplay
import com.pmd01.parcial01_orderup.screens.MainScreen
import com.pmd01.parcial01_orderup.screens.OrderScreen

@Composable
fun OrderUpApp() {

    val backStack = rememberNavBackStack(Routes.Menu)

    var cart by rememberSaveable {
        mutableStateOf(mutableMapOf<Int, Int>())
    }

    fun addToCart(id: Int) {
        cart = cart.toMutableMap().apply {
            this[id] = (this[id] ?: 0) + 1
        }
    }

    fun removeFromCart(id: Int) {
        cart = cart.toMutableMap().apply {
            val current = this[id] ?: 0
            if (current > 1) this[id] = current - 1 else remove(id)
        }
    }

    fun goBack() {
        if (backStack.size > 1) {
            backStack.removeLast()
        }
    }

    NavDisplay(
        backStack = backStack,
        onBack = { goBack() },

        entryProvider = entryProvider {

            entry<Routes.Menu> {
                MainScreen(
                    cart = cart,
                    onAdd = { addToCart(it) },
                    onCartClick = {
                        backStack.add(Routes.Order)
                    }
                )
            }

            entry<Routes.Order> {
                OrderScreen(
                    cart = cart,
                    onRemove = { removeFromCart(it) },
                    onBack = { goBack() }
                )
            }
        }
    )
}
