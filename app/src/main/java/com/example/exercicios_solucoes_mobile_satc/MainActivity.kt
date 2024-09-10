package com.example.exercicios_solucoes_mobile_satc

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.navigation.compose.rememberNavController
import com.example.exercicios_solucoes_mobile_satc.navigations.AppNavigation
import com.example.exercicios_solucoes_mobile_satc.navigations.theme.TesouroJogoTheme


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            TesouroJogoApp()
        }
    }
}

@Composable
fun TesouroJogoApp() {
    TesouroJogoTheme {
        // Inicializa o controlador de navegação e o tempo inicial do jogo
        val navController = rememberNavController()
        val startTime = remember { System.currentTimeMillis() }

        // Inicia a navegação do aplicativo
        AppNavigation(navController, startTime)
    }
}
