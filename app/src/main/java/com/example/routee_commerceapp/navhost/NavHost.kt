package com.example.routee_commerceapp.navhost

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.routee_commerceapp.constants.Destination
import com.example.routee_commerceapp.presentation.Screens.Home.Home
import com.example.routee_commerceapp.presentation.Screens.SignUp.SignUpScreen
import com.example.routee_commerceapp.presentation.Screens.splash.SplashScreen
import com.example.routee_commerceapp.presentation.componants.LoginScreen
@Composable
fun NavHost(modifier: Modifier = Modifier) {
    val navController = rememberNavController()
    androidx.navigation.compose.NavHost(
        navController = navController,
        startDestination = Destination.SPLASH
    ) {
        composable(Destination.SPLASH) {
            SplashScreen(
                navigateToHome = { navController.navigate(Destination.HOME) },
                navigateToLogin = { navController.navigate(Destination.LOGIN) }
            )
        }
        composable(Destination.LOGIN) {
            LoginScreen(
                navController = navController,
                navigateToHome = { navController.navigate(Destination.HOME) },
                navigateToSignUp = { navController.navigate(Destination.SIGNUP) }
            )
        }
        composable(Destination.SIGNUP) {
            SignUpScreen(
                navController = navController,
                navigateToHome = { navController.navigate(Destination.HOME) }
            )
        }
        composable(Destination.HOME) {
            Home()
        }
    }
}
