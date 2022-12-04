package com.example.jectpackrandomuidesion

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.ui.Modifier
import com.example.jectpackrandomuidesion.grocery_ui.GroceryUi
import com.example.jectpackrandomuidesion.login_register.login_ui.LoginPage
import com.example.jectpackrandomuidesion.qr_code.QrCode
import com.example.jectpackrandomuidesion.ui.theme.JectpackRandomUiDesionTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            JectpackRandomUiDesionTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
              // LoginPage()

                   // RegistrationUi()
                   // QrCode()
                    GroceryUi()

                }
            }
        }
    }
}

