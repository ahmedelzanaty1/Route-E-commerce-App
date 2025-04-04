package com.example.routee_commerceapp.presentation.activities

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Scaffold
import androidx.compose.ui.Modifier
import com.example.routee_commerceapp.navhost.NavHost
import com.example.routee_commerceapp.presentation.Screens.Home.Componant.BottomNavigationBar
import com.example.routee_commerceapp.presentation.theme.RouteEcommerceAppTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            RouteEcommerceAppTheme {
                Scaffold(modifier = Modifier.fillMaxSize()
                    ) { innerPadding ->
                    NavHost(modifier = Modifier.padding(innerPadding))
                }
            }
        }
    }
}
