package com.pmd01.parcial01_orderup.screens


import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.pmd01.parcial01_orderup.controller.menu


@Composable
fun OrderScreen(
    cart: Map<Int, Int>,
    onRemove: (Int) -> Unit
) {

    val itemsInCart = menu.filter { cart.containsKey(it.id) }

    val total = itemsInCart.sumOf {
        val quantity = cart[it.id] ?: 0
        it.price * quantity
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {

        Text("Tu Orden", style = MaterialTheme.typography.titleLarge)

        LazyColumn(
            modifier = Modifier.weight(1f)
        ) {
            items(itemsInCart) { product ->

                val quantity = cart[product.id] ?: 0

                Card(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(8.dp)
                ) {
                    Row(
                        modifier = Modifier.padding(16.dp),
                        horizontalArrangement = Arrangement.SpaceBetween
                    ) {

                        Column {
                            Text(product.name)
                            Text("Cantidad: $quantity")
                            Text("Subtotal: $${product.price * quantity}")
                        }

                        IconButton(onClick = {
                            onRemove(product.id)
                        }) {
                            Icon(Icons.Default.Delete, contentDescription = "Eliminar")
                        }
                    }
                }
            }
        }
        Text(
            text = "Total: $${"%.2f".format(total)}",
            style = MaterialTheme.typography.titleLarge,
            modifier = Modifier.padding(top = 16.dp)
        )
    }
}
