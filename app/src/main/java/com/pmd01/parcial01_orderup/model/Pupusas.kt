package com.pmd01.parcial01_orderup.model

data class Pupusas (
    val id: Int,
    val name: String,
    val price: Double,
    val ImageURL : String,
    val Tipo_Pupusa: TipoProducto
)

enum class TipoProducto {
    PUPUSA,
    BEBIDA
}