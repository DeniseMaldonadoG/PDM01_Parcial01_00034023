package com.pmd01.parcial01_orderup

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.ui.Modifier
import com.pmd01.parcial01_orderup.ui.theme.Parcial01_OrderUpTheme
import com.pmd01.parcial01_orderup.screens.MainScreen
import com.pmd01.parcial01_orderup.Router.OrderUpApp
import com.pmd01.parcial01_orderup.Router.OrderUpApp

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        setContent {
            Parcial01_OrderUpTheme {
                OrderUpApp()
            }
        }
    }
}


