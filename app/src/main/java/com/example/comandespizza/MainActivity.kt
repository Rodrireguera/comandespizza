package com.example.comandespizza

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.foundation.layout.*
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            PizzaApp()
        }
    }
}
@Composable
fun PizzaApp() {

    var pasActual by rememberSaveable { mutableStateOf(1) }

    var nom by rememberSaveable { mutableStateOf("") }
    var quantitat by rememberSaveable { mutableStateOf(0) }
    var tipusPizza by rememberSaveable { mutableStateOf("") }



    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {}
    when (pasActual) {

        1 -> PantallaNom(nom) {
            nom = it
            pasActual = 2
        }

        2 -> PantallaQuantitat(quantitat) {
            quantitat = it
            pasActual = 3
        }

        3 -> PantallaTipusPizza(tipusPizza) {
            tipusPizza = it
            pasActual = 4
        }

        4 -> PantallaResum(nom, quantitat, tipusPizza) {
            pasActual = 5
        }

    }
}
