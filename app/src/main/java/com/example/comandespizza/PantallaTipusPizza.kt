package com.example.comandespizza

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.material3.Button
import androidx.compose.material3.Checkbox
import androidx.compose.material3.RadioButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.semantics.Role.Companion.Checkbox

@Composable
fun PantallaTipusPizza(
    tipusPizza: String,
    onNext: (String) -> Unit
){

    val pizzes = listOf(
        "Margarita",
        "Barbacoa",
        "4 Formatges",
        "Vegetal"
    )

    var pizzaSeleccionada by remember { mutableStateOf(listOf<String>()) }

    Column {

        Text("Tipus de pizzes per escollir")

        pizzes.forEach { pizza ->

            Row {

                Checkbox(
                    checked = pizzaSeleccionada.contains(pizza),

                    onCheckedChange = { checked ->

                        pizzaSeleccionada =
                            (if (checked) {
                                pizzaSeleccionada + pizza
                            } else pizzaSeleccionada - pizza)
                    }
                )

                Text(pizza)
            }
        }

        Button(
            onClick = { onNext(pizzaSeleccionada.toString()) },
            enabled = pizzaSeleccionada.isNotEmpty()
        ) {
            Text("Següent")
        }

    }
}