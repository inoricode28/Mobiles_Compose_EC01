package pe.edu.idat.ec01_miguel_chavez

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

import androidx.compose.ui.unit.dp
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            val navController = rememberNavController()
            NavHost(navController = navController, startDestination = "menu") {
                composable("menu") { MenuScreen(navController) }

                composable("Estacion") { CobroEstacionScreen() }
                composable("promedio") { PromedioScreen() }
                composable("ValidarDNI") { ValidarDNIScreen() }
                composable("NumerosPares") { Numero_ParesScreen() }

                // Agrega aquí las demás pantallas según sea necesario
            }


        }
    }
}

@Composable
fun MySpace(espacio: Int){
    Spacer(modifier = Modifier.size(espacio.dp))
}