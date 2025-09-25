package com.example.formularioregistro

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import com.example.formularioregistro.ui.theme.FormularioRegistroTheme
import androidx.compose.ui.unit.dp // Unidades de medida
import androidx.compose.ui.unit.sp // Tamaño de texto
import androidx.compose.ui.text.input.PasswordVisualTransformation // Ocultar contraseña

//:Actividad Práctica Acumulativa Individual)  Formulario de Registro con Validación

//interfaz gráfica de registro que incluya al menos los siguientes 5 campos obligatorios
//Nombre completo
//Correo electrónico
//Contraseña
//Confirmar contraseña
//Sede (puede ser un campo de texto o un selector simple)
//Aplica diseño, colores y un logotipo al layout de Registro
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            FormularioRegistroTheme {
               RegisterScreen()
            }
        }
    }
}

@Composable
fun RegisterScreen(){
    var nombreCompleto by remember { mutableStateOf("") }
    var correo by remember { mutableStateOf("") }
    var contrasenia by remember { mutableStateOf("") }

    Column(
        modifier = Modifier
            .fillMaxSize() // Ocupa toda la pantalla
            .background(Color(0xFFa2d2ff)) // Fondo gris claro
            .padding(24.dp), // Margen interno general
        horizontalAlignment = Alignment.CenterHorizontally, // Centrado horizontal
        verticalArrangement = Arrangement.Center // Centrado vertical
    ){
        // ---------- LOGO ----------
        Image(
            painter = painterResource(id = R.drawable.carita_feliz), // Carga el logo
            contentDescription = "Logo", // Descripción accesible
            modifier = Modifier
                .height(100.dp) // Alto del logo
                .padding(bottom = 32.dp) // Espacio debajo del logo
        )

        // ---------- CAMPO USUARIO ----------
        TextField(
            value = nombreCompleto,
            onValueChange = { nombreCompleto = it }, // Actualiza estado
            label = { Text("Nombre Completo") }, // Etiqueta
            singleLine = true // Solo una línea
        )

        Spacer(modifier = Modifier.height(12.dp)) // Espacio entre campos

        // ---------- CAMPO CORREO ----------
        TextField(
            value = correo,
            onValueChange = { correo = it }, // Actualiza estado
            label = { Text("Correo Electrónico") }, // Etiqueta
            singleLine = true // Solo una línea
        )

        Spacer(modifier = Modifier.height(12.dp)) // Espacio entre campos

        // ---------- CAMPO CONTRASEÑA ----------
        TextField(
            value = contrasenia,
            onValueChange = { contrasenia = it }, // Actualiza estado
            label = { Text("Contraseña") }, // Etiqueta
            singleLine = true,
            visualTransformation = PasswordVisualTransformation() // Oculta caracteres
        )

        Spacer(modifier = Modifier.height(12.dp)) // Espacio entre campos

        

    }
}


@Preview(showBackground = true)
@Composable
fun RegistroPreview() {
FormularioRegistroTheme {
    RegisterScreen()
}
}






















//@Composable
// fun Greeting(name: String, modifier: Modifier = Modifier) {
// Text(
// text = "Hello $name!",
// modifier = modifier
// )
// }

//@Preview(showBackground = true)
// @Composable
// fun GreetingPreview() {
// FormularioRegistroTheme {
// Greeting("Android")
// }
// }