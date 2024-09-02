package com.example.exercicios_solucoes_mobile_satc

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import com.example.exercicios_solucoes_mobile_satc.calculator.Calculator
import com.example.exercicios_solucoes_mobile_satc.calculator.CalculatorUI

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val calculator = Calculator()

        setContent {
            MaterialTheme {
                Surface {
                    CalculatorUI(calculator)
                }
            }
        }
    }
}

