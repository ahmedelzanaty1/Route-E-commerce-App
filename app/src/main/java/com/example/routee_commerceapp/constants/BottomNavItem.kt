package com.example.routee_commerceapp.constants

import com.example.routee_commerceapp.R

sealed class BottomNavItem(
    val route: String,
    val label: String,
    val selectedIcon: Int,
    val unselectedIcon: Int
) {
    object Home : BottomNavItem("home", "Home", R.drawable.homeselected, R.drawable.home)
    object Categories : BottomNavItem("categories", "Categories", R.drawable.categoryselected, R.drawable.categories)
    object Favorite : BottomNavItem("favorite", "Favorite", R.drawable.favoriteselected, R.drawable.favorite)
    object Profile : BottomNavItem("profile", "Profile", R.drawable.profileselected, R.drawable.user)
}