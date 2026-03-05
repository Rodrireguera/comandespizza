package com.example.comandespizza

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview

class PantallaNom : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            PantallaNom()
        }
    }
}
@Preview
@Composable
fun PantallaNom(nom: String)
 {
    Colum {
        Text(text = "Nom del client")

        TextField(
            nom, onNomChange
        )
    }
 }
