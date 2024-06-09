package pe.edu.idat.ec01_miguel_chavez

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
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
import java.util.Calendar


@Composable
fun ValidarDNIScreen(){
    Box(modifier = Modifier
        .fillMaxSize()
        .padding(top = 25.dp)){

        var yearOfBirth  by rememberSaveable {
            mutableStateOf("")
        }

        var resultado by rememberSaveable {
            mutableStateOf("")
        }

        Column {
            Text(text = "RENIEC",
                textAlign = TextAlign.Center,
                modifier = Modifier.fillMaxWidth(),
                style = TextStyle(fontWeight = FontWeight.Bold, fontSize = 30.sp)
            )
            MySpace(16)
            OutlinedTextField(value = yearOfBirth ,
                onValueChange = { yearOfBirth = it },
                modifier = Modifier.fillMaxWidth(),
                label = { Text(text ="AÑO DE NACIMIENTO") },
                maxLines = 1,
                singleLine = true,
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number)
            )

            MySpace(16)
            Button(onClick = {
                resultado = validarDNI(yearOfBirth.toInt())
            },
                modifier = Modifier.fillMaxWidth()) {
                Text(text = "VALIDAR")
            }
            MySpace(espacio = 16)
            Text(text = resultado,
                style = TextStyle(fontWeight = FontWeight.Bold, color = Color.DarkGray)
            )
        }
    }
}

fun validarDNI(yearOfBirth: Int): String {
    val currentYear = Calendar.getInstance().get(Calendar.YEAR)
    val age = currentYear - yearOfBirth

    return if (age >= 18) {
        "Debe sacar su DNI. Tiene $age años."
    } else {
        "No necesita sacar su DNI. Tiene $age años."
    }
}




