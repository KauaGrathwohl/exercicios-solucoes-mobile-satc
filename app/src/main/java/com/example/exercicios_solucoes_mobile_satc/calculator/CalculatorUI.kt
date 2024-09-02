package com.example.exercicios_solucoes_mobile_satc.calculator

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun CalculatorUI(calculator: Calculator) {

    var displayValue by remember { mutableStateOf("0") }
    var operand1 by remember { mutableStateOf<Double?>(null) }
    var operand2 by remember { mutableStateOf<Double?>(null) }
    var operation by remember { mutableStateOf<String?>(null) }

    val appendNumber = { number: String ->
        if (displayValue == "0") {
            displayValue = number
        } else {
            displayValue += number
        }
    }

    val clear = {
        displayValue = "0"
        operand1 = null
        operand2 = null
        operation = null
    }

    val selectOperation = { selectedOperation: String ->
        operand1 = displayValue.toDoubleOrNull()
        operation = selectedOperation
        displayValue = "0"
    }

    val calculateResult = {
        operand2 = displayValue.toDoubleOrNull()
        if (operand1 != null && operand2 != null && operation != null) {
            displayValue = when (operation) {
                "+" -> calculator.add(operand1!!, operand2!!).toString()
                "-" -> calculator.subtract(operand1!!, operand2!!).toString()
                "×" -> calculator.multiply(operand1!!, operand2!!).toString()
                "÷" -> try {
                    calculator.divide(operand1!!, operand2!!).toString()
                } catch (e: IllegalArgumentException) {
                    "Error"
                }
                else -> "Error"
            }
        }
        operation = null
        operand1 = null
        operand2 = null
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
            .background(Color.Black),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        // Display
        Text(
            text = displayValue,
            color = Color.White,
            fontSize = 48.sp,
            fontWeight = FontWeight.Bold,
            textAlign = TextAlign.End,
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp)
        )

        Spacer(modifier = Modifier.height(16.dp))

        // Buttons
        val buttonModifier = Modifier
            .weight(1f)
            .padding(8.dp)

        val buttonColors = ButtonDefaults.buttonColors(containerColor = Color.DarkGray)

        Column(modifier = Modifier.fillMaxWidth()) {
            Row(modifier = Modifier.fillMaxWidth()) {
                CalculatorButton("7", buttonModifier, buttonColors) { appendNumber("7") }
                CalculatorButton("8", buttonModifier, buttonColors) { appendNumber("8") }
                CalculatorButton("9", buttonModifier, buttonColors) { appendNumber("9") }
                CalculatorButton("÷", buttonModifier, buttonColors) { selectOperation("÷") }
            }
            Row(modifier = Modifier.fillMaxWidth()) {
                CalculatorButton("4", buttonModifier, buttonColors) { appendNumber("4") }
                CalculatorButton("5", buttonModifier, buttonColors) { appendNumber("5") }
                CalculatorButton("6", buttonModifier, buttonColors) { appendNumber("6") }
                CalculatorButton("×", buttonModifier, buttonColors) { selectOperation("×") }
            }
            Row(modifier = Modifier.fillMaxWidth()) {
                CalculatorButton("1", buttonModifier, buttonColors) { appendNumber("1") }
                CalculatorButton("2", buttonModifier, buttonColors) { appendNumber("2") }
                CalculatorButton("3", buttonModifier, buttonColors) { appendNumber("3") }
                CalculatorButton("-", buttonModifier, buttonColors) { selectOperation("-") }
            }
            Row(modifier = Modifier.fillMaxWidth()) {
                CalculatorButton("0", buttonModifier, buttonColors) { appendNumber("0") }
                CalculatorButton(".", buttonModifier, buttonColors) { appendNumber(".") }
                CalculatorButton("C", buttonModifier, buttonColors) { clear() }
                CalculatorButton("+", buttonModifier, buttonColors) { selectOperation("+") }
            }
            Row(modifier = Modifier.fillMaxWidth()) {
                CalculatorButton("=", Modifier.weight(4f).padding(8.dp), ButtonDefaults.buttonColors(containerColor = Color.Red)) {
                    calculateResult()
                }
            }
        }
    }
}

@Composable
fun CalculatorButton(
    text: String,
    modifier: Modifier = Modifier,
    colors: ButtonColors = ButtonDefaults.buttonColors(),
    onClick: () -> Unit
) {
    Button(
        onClick = onClick,
        modifier = modifier,
        colors = colors
    ) {
        Text(text = text, fontSize = 24.sp, color = Color.White)
    }
}
