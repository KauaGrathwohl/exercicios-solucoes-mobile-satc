package com.example.exercicios_solucoes_mobile_satc.calculator

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.unit.dp

@Composable
fun CalculatorUI(calculator: Calculator) {

    var number1 by remember { mutableStateOf(TextFieldValue("")) }
    var number2 by remember { mutableStateOf(TextFieldValue("")) }
    var result by remember { mutableStateOf("") }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        TextField(
            value = number1,
            onValueChange = { number1 = it },
            label = { Text("Number 1") },
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(16.dp))

        TextField(
            value = number2,
            onValueChange = { number2 = it },
            label = { Text("Number 2") },
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(16.dp))

        Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceBetween) {
            Button(onClick = {
                result = calculator.add(number1.text.toDouble(), number2.text.toDouble()).toString()
            }) {
                Text("Add")
            }

            Button(onClick = {
                result = calculator.subtract(number1.text.toDouble(), number2.text.toDouble()).toString()
            }) {
                Text("Subtract")
            }

            Button(onClick = {
                result = calculator.multiply(number1.text.toDouble(), number2.text.toDouble()).toString()
            }) {
                Text("Multiply")
            }

            Button(onClick = {
                result = try {
                    calculator.divide(number1.text.toDouble(), number2.text.toDouble()).toString()
                } catch (e: IllegalArgumentException) {
                    "Error"
                }
            }) {
                Text("Divide")
            }
        }

        Spacer(modifier = Modifier.height(16.dp))

        Text(text = "Result: $result", style = MaterialTheme.typography.headlineSmall)
    }
}
