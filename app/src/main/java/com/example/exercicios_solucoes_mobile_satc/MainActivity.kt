package com.example.exercicios_solucoes_mobile_satc

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.exercicios_solucoes_mobile_satc.calculator.Calculator
import com.example.exercicios_solucoes_mobile_satc.calculator.CalculatorUI
import com.example.exercicios_solucoes_mobile_satc.ui.theme.Exercicios_solucoes_mobile_satcTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val calculator = Calculator()

        enableEdgeToEdge()
        setContent {
            Exercicios_solucoes_mobile_satcTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    CalculatorUI(calculator)
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun CalculatorPreview() {
    Exercicios_solucoes_mobile_satcTheme {
        val calculator = Calculator()
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = MaterialTheme.colorScheme.background
        ) {
            CalculatorUI(calculator)
        }
    }
}
