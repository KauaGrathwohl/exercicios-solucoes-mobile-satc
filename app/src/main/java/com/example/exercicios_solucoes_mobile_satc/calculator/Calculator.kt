package com.example.exercicios_solucoes_mobile_satc.calculator

class Calculator {

    fun add(a: Double, b: Double): Double {
        return a + b
    }

    fun subtract(a: Double, b: Double): Double {
        return a - b
    }

    fun multiply(a: Double, b: Double): Double {
        return a * b
    }

    fun divide(a: Double, b: Double): Double {
        if (b == 0.0) throw IllegalArgumentException("Não pode dividir números por zero!")
        return a / b
    }
}
