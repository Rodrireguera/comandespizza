package com.example.comandespizza

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.foundation.layout.*
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp


class MainActivity : ComponentActivity() {

    private val lifecycleViewModel: LifecycleViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        logEvent("onCreate")

        setContent {
            PizzaApp(lifecycleViewModel)
        }
    }

    override fun onStart() {
        super.onStart()
        logEvent("onStart")
    }

    override fun onResume() {
        super.onResume()
        logEvent("onResume")
    }

    override fun onPause() {
        super.onPause()
        logEvent("onPause")
    }

    override fun onStop() {
        super.onStop()
        logEvent("onStop")
    }

    override fun onDestroy() {
        super.onDestroy()
        logEvent("onDestroy")
    }

    override fun onRestart() {
        super.onRestart()
        logEvent("onRestart")
    }

    private fun logEvent(event: String) {
        Log.d("LIFECYCLE", event)
        lifecycleViewModel.addEvent(event)
    }
}
@Composable
fun PizzaApp(lifecycleViewModel: LifecycleViewModel) {

    var pasActual by rememberSaveable { mutableStateOf(1) }

    var nom by rememberSaveable { mutableStateOf("") }
    var quantitat by rememberSaveable { mutableStateOf(0) }
    var tipusPizza by rememberSaveable { mutableStateOf("") }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {

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
                pasActual = 1
                nom = ""
                quantitat = 0
                tipusPizza = ""
            }
        }

        Spacer(modifier = Modifier.height(20.dp))

        LifecycleLogPanel(lifecycleViewModel)
    }
}

