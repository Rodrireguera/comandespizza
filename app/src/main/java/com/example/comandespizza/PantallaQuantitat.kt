package com.example.comandespizza

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.tooling.preview.Preview

    @Composable
    fun PantallaQuantitat(
        quantitat: Int,
        onNext: (Int) -> Unit
    ) {

        var q by remember { mutableStateOf(quantitat) }

        Column {

            Text("Quantitat de pizzes")

            Row {

                Button(onClick = { if (q > 0) q-- }) {
                    Text("-")
                }

                Text(" $q ")

                Button(onClick = { q++ }) {
                    Text("+")
                }
            }

            Button(
                onClick = { onNext(q) },
                enabled = q > 0
            ) {
                Text("Següent")
            }
        }
    }