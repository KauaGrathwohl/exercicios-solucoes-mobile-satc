package com.example.exercicios_solucoes_mobile_satc.navigations.screens

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController

@Composable
fun PistaScreen(navController: NavHostController, pista: String, respostaCorreta: String, proximaRota: String) {
    var resposta by remember { mutableStateOf(TextFieldValue("")) }
    var isRespostaCorreta by remember { mutableStateOf(false) }

    Surface(modifier = Modifier.fillMaxSize(), color = MaterialTheme.colorScheme.background) {
        Column(
            modifier = Modifier.fillMaxSize().padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Text(text = pista)
            Spacer(modifier = Modifier.height(20.dp))
            TextField(
                value = resposta,
                onValueChange = { resposta = it },
                label = { Text("Digite sua resposta") }
            )
            Spacer(modifier = Modifier.height(20.dp))
            Button(
                onClick = {
                    isRespostaCorreta = resposta.text.equals(respostaCorreta, ignoreCase = true)
                    if (isRespostaCorreta) navController.navigate(proximaRota)
                },
                enabled = resposta.text.isNotEmpty()
            ) {
                Text("Próxima Pista")
            }
            Spacer(modifier = Modifier.height(8.dp))
            Button(onClick = { navController.popBackStack() }) {
                Text("Voltar")
            }
        }
    }
}
