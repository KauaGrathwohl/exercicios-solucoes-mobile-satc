package com.example.exercicios_solucoes_mobile_satc.navigations.theme

import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color

private val LightColors = lightColorScheme(
    primary = Color(0xFF6200EA),
    onPrimary = Color.White,
    primaryContainer = Color(0xFFBB86FC),
    onPrimaryContainer = Color.Black
)

@Composable
fun TesouroJogoTheme(content: @Composable () -> Unit) {
    MaterialTheme(
        colorScheme = LightColors,
        typography = Typography(),
        content = content
    )
}
