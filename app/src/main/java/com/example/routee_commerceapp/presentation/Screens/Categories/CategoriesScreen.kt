package com.example.routee_commerceapp.presentation.Screens.Categories

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import com.example.routee_commerceapp.presentation.Screens.Home.Componant.BottomNavigationBar

@Composable
fun CategoriesScreen(modifier: Modifier = Modifier , navController: NavHostController) {

    Text(text = "Categories" , modifier = Modifier.padding())

}


@Composable
fun Favorite(modifier: Modifier = Modifier , navController: NavHostController) {
    Text(text = "Favorites")

}
@Composable
fun ProfileScreen(modifier: Modifier = Modifier , navController: NavHostController) {
    Text(text = "Profile")}