package com.example.routee_commerceapp.presentation.Screens.Home

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@Composable
fun Home(modifier: Modifier = Modifier) {
    Text(
        text = "welcome "
    )
    CircularProgressIndicator(modifier = Modifier.fillMaxSize())

}