package com.example.comandespizza

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Button
import androidx.compose.material3.Divider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun LifecycleLogPanel(viewModel: LifecycleViewModel) {

    Column {

        Text("Historial d'events del Activity Life Cycle:")

        Spacer(modifier = Modifier.height(8.dp))

        Divider()

        Spacer(modifier = Modifier.height(8.dp))

        viewModel.events.forEach {
            Text(it)
        }

        Button(
            onClick = { viewModel.reset() }
        ) {
            Text("Reset historial")
        }
    }
}