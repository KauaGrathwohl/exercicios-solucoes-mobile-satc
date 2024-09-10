package com.example.exercicios_solucoes_mobile_satc.navigations

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.exercicios_solucoes_mobile_satc.navigations.screens.HomeScreen
import com.example.exercicios_solucoes_mobile_satc.navigations.screens.PistaScreen
import com.example.exercicios_solucoes_mobile_satc.navigations.screens.TreasureScreen

@Composable
fun AppNavigation(navController: NavHostController, startTime: Long) {
    NavHost(navController = navController, startDestination = "home") {
        composable("home") { HomeScreen(navController) }
        composable("pista1") { PistaScreen(navController, "Eu tenho cidades, mas não casas. Tenho montanhas, mas não árvores. Tenho água, mas não peixes. Quem sou eu?", "mapa", "pista2") }
        composable("pista2") { PistaScreen(navController, "Eu corro sem pés, sussurro sem boca. O que sou?", "vento", "pista3") }
        composable("pista3") { PistaScreen(navController, "O que pode passar pela água sem se molhar?", "sombra", "tesouro") }
        composable("tesouro") { TreasureScreen(navController, startTime) }
    }
}
