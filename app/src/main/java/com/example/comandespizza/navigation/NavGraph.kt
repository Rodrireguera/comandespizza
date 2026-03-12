package com.example.comandespizza.navigation

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.*
import com.example.comandespizza.PizzaViewModel
import com.example.comandespizza.screens.ComandaScreen
import com.example.comandespizza.screens.IniciScreen
import com.example.comandespizza.screens.ResumScreen


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun NavGraph() {

    val navController = rememberNavController()
    val viewModel: PizzaViewModel = viewModel()

    val currentRoute = navController.currentBackStackEntryAsState().value?.destination?.route

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Comanda de Pizzes") },

                actions = {
                    if (currentRoute != "inici") {
                        Button(
                            onClick = { navController.popBackStack() }
                        ) {
                            Text("Tornar enrera")
                        }
                    }
                }
            )
        }
    ) { padding ->

        NavHost(
            navController = navController,
            startDestination = "inici",
            modifier = Modifier.padding(padding)
        ) {

            composable("inici") {
                IniciScreen(navController)
            }

            composable("comanda") {
                ComandaScreen(navController, viewModel)
            }

            composable("resum") {
                ResumScreen(navController, viewModel)
            }

        }
    }
}


