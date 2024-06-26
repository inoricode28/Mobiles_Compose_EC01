package pe.edu.idat.ec01_miguel_chavez

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun CobroEstacionScreen(){
    Box(modifier = Modifier
        .fillMaxSize()
        .padding(top = 25.dp)){

        var Horas by rememberSaveable {
            mutableStateOf("")
        }
        var Minutos by rememberSaveable {
            mutableStateOf("")
        }

        var resultado by rememberSaveable {
            mutableStateOf("")
        }

        Column {
            Text(text = "ESTACIONAMIENTO SOL DEL SUR",
                textAlign = TextAlign.Center,
                modifier = Modifier.fillMaxWidth(),
                style = TextStyle(fontWeight = FontWeight.Bold, fontSize = 30.sp)
            )
            MySpace(16)
            OutlinedTextField(value = Horas,
                onValueChange = { Horas = it },
                modifier = Modifier.fillMaxWidth(),
                label = { Text(text ="HORAS") },
                maxLines = 1,
                singleLine = true,
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number)
            )
            MySpace(16)
            OutlinedTextField(value = Minutos,
                onValueChange = { Minutos = it },
                modifier = Modifier.fillMaxWidth(),
                label = { Text(text ="MINUTOS") },
                maxLines = 1,
                singleLine = true,
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number)
            )

            MySpace(16)
            Button(onClick = {
                resultado = calcularCostoEstacionamiento(Horas.toInt(),
                    Minutos.toInt())
            },
                modifier = Modifier.fillMaxWidth()) {
                Text(text = "CALCULAR")
            }
            MySpace(espacio = 16)
            Text(text = resultado,
                style = TextStyle(fontWeight = FontWeight.Bold, color = Color.DarkGray)
            )
        }
    }
}


fun calcularCostoEstacionamiento(horas: Int, minutos: Int): String {
    // Precio por hora o fracción
    val precioPorHora = 1500

    // Calculamos el total de horas incluyendo fracciones de hora
    // Si hay algún minuto, se cuenta como una hora adicional
    val totalHoras = if (minutos > 0) horas + 1 else horas

    // Calculamos el costo total
    val costoTotal = totalHoras * precioPorHora

    // Devolvemos el resultado formateado
    return "El costo del estacionamiento es Dolares $costoTotal"
}

