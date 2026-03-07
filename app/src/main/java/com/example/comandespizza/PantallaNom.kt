package com.example.comandespizza

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.material3.Button
import androidx.compose.runtime.remember

@Preview
@Composable
fun PantallaNom(
    nom: String,
    onClick: (String) -> Unit
) {

    var text by remember { mutableStateOf(nom) }

    Column {

        Text("Nom del client")

        TextField(
            value = text,
            onValueChange = { text = it }
        )

        Button(
            onClick = { onClick(text) },
            enabled = text.isNotBlank()
        ) {
            Text("Següent")
        }
    }
}
