package com.example.pizza.ui.screens.custom_pizza.model

import com.example.pizza.ui.screens.custom_pizza.utils.PizzaSize

data class PizzaUiState(
    val pizzaBreadImage : Int ,
    val pizzaSize : PizzaSize = PizzaSize.MEDIUM,
    val hasBasil : Boolean = false,
    val hasBroccoli : Boolean = false,
    val hasMushroom : Boolean = false,
    val hasOnion : Boolean = false,
    val hasSausage : Boolean = false,
)
