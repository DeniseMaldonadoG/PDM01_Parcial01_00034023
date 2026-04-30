package com.pmd01.parcial01_orderup.Router

import kotlinx.serialization.Serializable

sealed interface Routes {

    @Serializable
    data object Menu : Routes

    @Serializable
    data object Order : Routes
}
