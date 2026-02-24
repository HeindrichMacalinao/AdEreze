package com.example.adereze

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.adereze.ui.theme.AdErezeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            AdErezeTheme {
                // Scaffold handles the basic layout structure (like top bars)
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    // We call our new Dashboard here instead of Greeting
                    AdShieldDashboard(modifier = Modifier.padding(innerPadding))
                }
            }
        }
    }
}

@Composable
fun AdShieldDashboard(modifier: Modifier = Modifier) {
    // This 'state' keeps track of whether the shield is on or off
    var isEnabled by remember { mutableStateOf(false) }

    Column(
        modifier = modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = if (isEnabled) "🛡️ AdEreze ACTIVE" else "⚠️ AdEreze OFF",
            style = MaterialTheme.typography.headlineLarge
        )

        Spacer(modifier = Modifier.height(24.dp))

        Button(
            onClick = { isEnabled = !isEnabled },
            modifier = Modifier.height(56.dp).width(200.dp)
        ) {
            Text(text = if (isEnabled) "STOP" else "START PROTECTION")
        }
    }
}