package com.example.comandespizza

import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue


@Composable
fun PantallaResum(){


    var contadorNormal = 0
    var contadorRemember by remember { mutableStateOf(0) }
    var contadorSaveable by rememberSaveable { mutableStateOf(0) }



    Button(
        onClick = {
            contadorNormal++
            contadorRemember++
            contadorSaveable++
        }
    ) {
        Text("+1 comptadors")
    }

    Text("Normal: $contadorNormal")
    Text("Remember: $contadorRemember")
    Text("Saveable: $contadorSaveable")


}