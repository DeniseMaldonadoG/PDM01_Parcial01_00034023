package com.pmd01.parcial01_orderup.screens


import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material3.*
import androidx.compose.runtime.Composable

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MyTopBar(
    onCartClick: () -> Unit,
    totalItems: Int
) {
    TopAppBar(
        title = { Text("OrderUp") },
        actions = {
            IconButton(onClick = onCartClick) {
                BadgedBox(
                    badge = {
                        if (totalItems > 0) {
                            Badge { Text("$totalItems") }
                        }
                    }
                ) {
                    Icon(
                        imageVector = Icons.Default.Menu,
                        contentDescription = "Cart"
                    )
                }
            }
        }
    )
}
