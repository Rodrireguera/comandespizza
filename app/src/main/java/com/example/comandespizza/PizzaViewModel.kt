package com.example.comandespizza

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel

class PizzaViewModel : ViewModel(){

    var nomClient by mutableStateOf("")
    var quantitatPizzes by mutableStateOf(0)
    var tipusPizza by mutableStateOf("")

    fun reiniciar(){
        nomClient = ""
        quantitatPizzes = 0
        tipusPizza = ""
    }

}