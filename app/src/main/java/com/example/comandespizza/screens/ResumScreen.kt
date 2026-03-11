package com.example.comandespizza.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Button
import androidx.compose.material3.Divider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.comandespizza.PizzaViewModel

@Composable
fun ResumScreen (navController: NavController, viewModel: PizzaViewModel, onRestart: () -> Unit){

    Column {

        Text("Resum comanda pizzes:")

        Spacer(modifier = Modifier.height(8.dp))

        Divider()

        Spacer(modifier = Modifier.height(8.dp))

        Text("Nom del client: ${viewModel.nomClient}")
        Text("Quantitat de pizzes: ${viewModel.quantitatPizzes}")
        Text("Pizzes escullides: ${viewModel.tipusPizza.removeSurrounding("[", "]") }")

        Button(onClick = { viewModel.reiniciar()
            navController.navigate("inici")     }) {
            Text("Reiniciar")
        }

        Spacer(modifier = Modifier.height(8.dp))

        Divider()

        Spacer(modifier = Modifier.height(8.dp))

        Button(
            onClick = { onRestart() }
        ) {
            Text("Comanda Confirmada")
        }

    }
}