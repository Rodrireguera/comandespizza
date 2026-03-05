package com.example.comandespizza

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.example.comandespizza.ui.theme.ComandesPizzaTheme
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

    var contadorNormal = 0
    var contadorRemember by remember { mutableStateOf(0) }
    var contadorSaveable by rememberSaveable { mutableStateOf(0) }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {}
    when (pasActual) {

        1 -> PantallaNom(nom)

        2 -> PantallaQuantitat(quantitat)

        3 -> PantallaTipusPizza(
            tipusPizza,
            content = TODO()
        )

        4 -> PantallaResum(nom, quantitat, tipusPizza)
    }
}

@Composable
fun PantallaResum(x0: String, x1: Int, x2: String) {
    TODO("Not yet implemented")
}

@Composable
fun PantallaQuantitat(x0: Int) {
    TODO("Not yet implemented")
}

@Composable
fun PantallaTipusPizza(x0: String, content: @Composable () -> Unit) {
    TODO("Not yet implemented")
}