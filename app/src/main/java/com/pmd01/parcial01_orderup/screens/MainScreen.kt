package com.pmd01.parcial01_orderup.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items

import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.pmd01.parcial01_orderup.controller.menu


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MainScreen(
    cart: Map<Int, Int>,
    onAdd: (Int) -> Unit,
    onCartClick: () -> Unit,
    modifier: Modifier = Modifier
) {

    val totalItems = cart.values.sum()

    Scaffold(
        modifier = modifier.fillMaxSize(),
        containerColor = Color.Transparent,
        topBar = {
            MyTopBar(
                onCartClick = onCartClick,
                totalItems = totalItems
            )
        }
    ) { innerPadding ->

        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(Color(0xFFCCCCCC))
                .padding(innerPadding)
                .padding(10.dp)
        ) {

            Card(
                colors = CardDefaults.cardColors(
                    containerColor = MaterialTheme.colorScheme.surfaceVariant
                ),
                modifier = Modifier.fillMaxWidth()
            ) {
                Text(
                    text = "Menu",
                    modifier = Modifier.padding(16.dp)
                )
            }

            LazyColumn {
                items(menu) { product ->

                    val quantity = cart[product.id] ?: 0

                    Card(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(8.dp)
                            .clickable { onAdd(product.id) }
                    ) {
                        Row(
                            modifier = Modifier.padding(16.dp),
                            verticalAlignment = Alignment.CenterVertically
                        ) {

                            AsyncImage(
                                model = product.ImageURL,
                                contentDescription = product.name,
                                modifier = Modifier.size(64.dp)
                            )

                            Column(
                                modifier = Modifier
                                    .padding(start = 16.dp)
                                    .weight(1f)
                            ) {
                                Text(product.name)
                                Text("$${product.price}")
                            }

                            if (quantity > 0) {
                                Text("x$quantity")
                            }
                        }
                    }
                }
            }
        }
    }
}
