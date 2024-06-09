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
fun PromedioScreen(){
    Box(modifier = Modifier
        .fillMaxSize()
        .padding(top = 25.dp)){

        var ec1 by rememberSaveable {
            mutableStateOf("")
        }
        var ec2 by rememberSaveable {
            mutableStateOf("")
        }
        var ec3 by rememberSaveable {
            mutableStateOf("")
        }
        var ef by rememberSaveable {
            mutableStateOf("")
        }
        var resultado by rememberSaveable {
            mutableStateOf("")
        }

        Column {
            Text(text = "PROMEDIO DE NOTAS IDAT",
                textAlign = TextAlign.Center,
                modifier = Modifier.fillMaxWidth(),
                style = TextStyle(fontWeight = FontWeight.Bold, fontSize = 30.sp)
            )
            MySpace(16)
            OutlinedTextField(value = ec1,
                onValueChange = { ec1 = it },
                modifier = Modifier.fillMaxWidth(),
                label = {Text(text ="Ingrese EC 1")},
                maxLines = 1,
                singleLine = true,
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number)
            )
            MySpace(16)
            OutlinedTextField(value = ec2,
                onValueChange = { ec2 = it },
                modifier = Modifier.fillMaxWidth(),
                label = {Text(text ="Ingrese EC 2")},
                maxLines = 1,
                singleLine = true,
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number)
            )
            MySpace(16)
            OutlinedTextField(value = ec3,
                onValueChange = { ec3 = it },
                modifier = Modifier.fillMaxWidth(),
                label = {Text(text ="Ingrese EC 3")},
                maxLines = 1,
                singleLine = true,
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number)
            )
            MySpace(16)
            OutlinedTextField(value = ef,
                onValueChange = { ef = it },
                modifier = Modifier.fillMaxWidth(),
                label = {Text(text ="Ingrese EF")},
                maxLines = 1,
                singleLine = true,
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number)
            )
            MySpace(16)
            Button(onClick = {
                resultado = calcularPromedio(ec1.toInt(),
                    ec2.toInt(), ec3.toInt(), ef.toInt())
            },
                modifier = Modifier.fillMaxWidth()) {
                Text(text = "CALCULAR")
            }
            MySpace(espacio = 16)
            Text(text = resultado,
                style = TextStyle(fontWeight = FontWeight.Bold, color = Color.DarkGray))
        }
    }
}

fun calcularPromedio(nota1: Int, nota2: Int, nota3: Int, nota4: Int): String {
    // Crear una lista con las notas
    val notas = listOf(nota1, nota2, nota3, nota4)
    // Ordenar las notas y eliminar la más baja
    val notasFiltradas = notas.sorted().drop(1)

    // Calcular el promedio con las tres notas restantes
    val promedio = (notasFiltradas[0] * 0.2) + (notasFiltradas[1] * 0.3) + (notasFiltradas[2] * 0.5)
    val resultado = if (promedio > 12.5) "APROBADO" else "DESAPROBADO"

    return "Su promedio es %.2f su estado es $resultado".format(promedio)
}