package com.example.segurancaquod

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.segurancaquod.ui.theme.SEGURANCAQUODTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            TelaInicial()
        }
    }
}

@Composable
fun TelaInicial() {
    // Cria o controlador de navegação
    val navController = rememberNavController()

    // Define o tema do aplicativo
    SEGURANCAQUODTheme {
        // Layout principal com navegação
        NavHost(navController = navController, startDestination = "menu") {
            composable("menu") {
                MenuScreen(navController)
            }
            composable("biometriaDigital") {
                BiometriaDigitalScreen()
            }
        }
    }
}

@Composable
fun MenuScreen(navController: NavHostController) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        // Título
        Text(
            text = "Soluções Antifraude",
            style = MaterialTheme.typography.headlineLarge,
            modifier = Modifier.padding(bottom = 32.dp)
        )

        // Botões do menu
        MenuButton("Biometria Facial") {
            // Ação para Biometria Facial
        }
        MenuButton("Biometria Digital") {
            // Navegar para a tela de Biometria Digital
            navController.navigate("biometriaDigital")
        }
        MenuButton("Documentoscopia") {
            // Ação para análise de documentos
        }
        MenuButton("SIM SWAP") {
            // Ação para SIM SWAP
        }
        MenuButton("Autenticação Cadastral") {
            // Ação para autenticação cadastral
        }
        MenuButton("Score Antifraude") {
            // Ação para calcular o Score
        }
    }
}

@Composable
fun BiometriaDigitalScreen() {
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text = "Tela de Biometria Digital", fontSize = 24.sp)
        Image(
            painter = painterResource(id = R.drawable.ic_fingerprint),
            contentDescription = "Ícone de impressão digital",
            modifier = Modifier.size(100.dp)
        )
        Button(onClick = { /* Ação ao clicar no botão */ }) {
            Text(text = "Iniciar Leitura")
        }
    }
}

@Composable
fun MenuButton(text: String, onClick: () -> Unit) {
    Button(
        onClick = onClick,
        shape = RoundedCornerShape(8.dp),
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 8.dp)
    ) {
        Text(text = text, fontSize = 18.sp)
    }
}
