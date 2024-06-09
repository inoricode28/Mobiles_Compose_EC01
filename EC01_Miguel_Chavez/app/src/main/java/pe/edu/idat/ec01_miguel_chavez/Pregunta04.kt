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
fun Numero_ParesScreen(){
    Box(modifier = Modifier
        .fillMaxSize()
        .padding(top = 25.dp)){


        var resultado by rememberSaveable {
            mutableStateOf("")
        }

        Column {
            Text(text = "NUMEROS PARES DEL 20 AL 10 DECENDENTE",
                textAlign = TextAlign.Center,
                modifier = Modifier.fillMaxWidth(),
                style = TextStyle(fontWeight = FontWeight.Bold, fontSize = 30.sp)
            )
            MySpace(16)

            Button(onClick = {
                resultado = obtenerNumerosPares()
            },
                modifier = Modifier.fillMaxWidth()) {
                Text(text = "MOSTRAR")
            }
            MySpace(espacio = 16)
            Text(text = resultado,
                style = TextStyle(fontWeight = FontWeight.Bold, color = Color.DarkGray)
            )
        }
    }
}

fun obtenerNumerosPares(): String {
    val numerosPares = (10..20).filter { it % 2 == 0 }.sortedDescending()
    return numerosPares.joinToString(", ")
}