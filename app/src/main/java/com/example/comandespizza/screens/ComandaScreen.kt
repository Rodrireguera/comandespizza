package com.example.comandespizza.screens

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.comandespizza.PizzaViewModel
import kotlin.collections.minus
import kotlin.collections.plus

@Composable
fun ComandaScreen(navController: NavController, viewModel: PizzaViewModel) {

    var q by remember { mutableStateOf(viewModel.quantitatPizzes) }

    val pizzes = listOf(
        "Margarita",
        "Barbacoa",
        "4 Formatges",
        "Vegetal"
    )

    var pizzaSeleccionada by remember { mutableStateOf(listOf<String>()) }

    Column(modifier = Modifier.padding(16.dp)) {

        Text("Comença la teva comanda")

        Spacer(modifier = Modifier.height(8.dp))

        Divider()

        Spacer(modifier = Modifier.height(8.dp))

        TextField(
            value = viewModel.nomClient,
            onValueChange = { viewModel.nomClient = it },
            label = { Text("Nom client") }
        )

        Spacer(modifier = Modifier.height(8.dp))

        Divider()

        Spacer(modifier = Modifier.height(8.dp))

        Text("Quantitat de pizzes")

        Row {

            Button(onClick = {
                if (q > 1) {
                    q--
                    viewModel.quantitatPizzes = q
                }
            }) {
                Text("-")
            }

            Text(" $q ", modifier = Modifier.padding(horizontal = 16.dp))

            Button(onClick = {
                q++
                viewModel.quantitatPizzes = q
            }) {
                Text("+")
            }
        }

        Spacer(modifier = Modifier.height(8.dp))

        Divider()

        Spacer(modifier = Modifier.height(8.dp))

        Text("Tipus de pizza")

        pizzes.forEach { pizza ->

            Row {

                Checkbox(
                    checked = pizzaSeleccionada.contains(pizza),

                    onCheckedChange = { checked ->

                        pizzaSeleccionada =
                            if (checked) {
                                pizzaSeleccionada + pizza
                            } else {
                                pizzaSeleccionada - pizza
                            }

                        viewModel.tipusPizza = pizzaSeleccionada.joinToString()
                    }
                )

                Text(pizza)
            }
        }

        Divider()

        Spacer(modifier = Modifier.height(16.dp))

        Button(
            onClick = { navController.navigate("resum") },
            enabled = viewModel.nomClient.isNotEmpty()
                    && viewModel.quantitatPizzes > 0
                    && viewModel.tipusPizza.isNotEmpty()
        ) {
            Text("Veure resum")
        }

    }
}