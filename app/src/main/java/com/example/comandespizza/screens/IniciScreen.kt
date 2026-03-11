package com.example.comandespizza.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.navigation.NavController

@Composable
fun IniciScreen(navController: NavController) {

    Column{
        Text("Benvingut a la comanda pizzes")

        Button(
            onClick = { navController.navigate("comanda") }
        ){
            Text("Començar comanda")
        }
    }
}