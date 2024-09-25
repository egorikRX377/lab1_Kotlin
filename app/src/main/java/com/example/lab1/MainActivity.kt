package com.example.lab1
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue

class MainActivity : ComponentActivity()
{
    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                Greeting(modifier = Modifier.padding(innerPadding))
            }
        }
    }
}

@Composable
fun Greeting(modifier: Modifier = Modifier)
{
    Column(
        modifier = modifier
            .fillMaxSize()
            .background(Color(0xFF2196F3)),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        var fullName by remember { mutableStateOf("") }
        var textValue by remember { mutableStateOf("") }

        Text(
            text = fullName,
            modifier = modifier.padding(16.dp),
            fontSize = 48.sp
        )

        TextField(
            value = textValue,
            onValueChange = { textValue = it },
            label = { Text(text = "Введите ФИО") },
            placeholder = { Text(text = "") },
            modifier = modifier.padding(4.dp)
        )

        Button(
            onClick = {
                fullName = textValue
            },
            modifier = modifier.padding(top = 16.dp)
        ) {
            Text(text = "Показать ФИО")
        }

        Button(
            onClick = {
                fullName = ""
                textValue = ""
            },
            modifier = modifier.padding(top = 16.dp)
        ) {
            Text(text = "Очистить")
        }
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    Greeting()
}