package com.example.routee_commerceapp.presentation.Screens.Home

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.routee_commerceapp.constants.Destination
import com.example.routee_commerceapp.presentation.Screens.Categories.CategoriesScreen
import com.example.routee_commerceapp.presentation.Screens.Home.Componant.BottomNavigationBar

@Composable
fun MainScreen() {
    val navController = rememberNavController()

    Scaffold(
        bottomBar = {
            BottomNavigationBar(navController = navController)
        }
    ) { innerPadding ->
        NavHost(
            navController = navController,
            startDestination = Destination.HOME,
            modifier = Modifier.padding(innerPadding)
        ) {
            composable(Destination.HOME) {
                HomeUi()
            }
            composable(Destination.CATEGORIES) {
                CategoriesScreen(navController = navController)
            }
            composable(Destination.FAVORITES) {
            }
            composable(Destination.PROFILE) {
            }
        }
    }
}
