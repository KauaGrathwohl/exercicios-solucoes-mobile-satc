package com.example.exercicios_solucoes_mobile_satc.navigations.screens

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController

@Composable
fun TreasureScreen(navController: NavHostController, startTime: Long) {
    val timeTaken = (System.currentTimeMillis() - startTime) / 1000

    Surface(modifier = Modifier.fillMaxSize(), color = MaterialTheme.colorScheme.background) {
        Column(
            modifier = Modifier.fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Text(text = "Parabéns! Você encontrou o tesouro!")
            Spacer(modifier = Modifier.height(20.dp))
            Text(text = "Você levou $timeTaken segundos.")
            Spacer(modifier = Modifier.height(20.dp))
            Button(onClick = { navController.navigate("home") }) {
                Text("Recomeçar Caça ao Tesouro")
            }
        }
    }
}
