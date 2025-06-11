package com.example.pizza

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.example.pizza.ui.screens.custom_pizza.CustomPizzaScreen
import com.example.pizza.ui.theme.PizzaTheme

@Composable
fun PizzaApp(){
    PizzaTheme {
        Scaffold(modifier = androidx.compose.ui.Modifier.fillMaxSize()) { innerPadding ->
            CustomPizzaScreen(modifier = Modifier.padding(innerPadding))
        }
    }
}