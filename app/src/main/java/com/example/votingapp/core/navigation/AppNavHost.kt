package com.example.votingapp.core.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import com.example.votingapp.core.navigation.home.homeScreen
import com.example.votingapp.core.navigation.home.navigateToHome
import com.example.votingapp.core.navigation.login.loginNavigationRoute
import com.example.votingapp.core.navigation.login.loginScreen
import com.example.votingapp.core.navigation.login.navigateToLogin
import com.example.votingapp.core.navigation.register.navigateToRegister
import com.example.votingapp.core.navigation.register.registerScreen


@Composable
fun AppNavHost(
    navController: NavHostController,
    onBackClick: () -> Unit,
    modifier: Modifier = Modifier,
    startDestination: String = loginNavigationRoute
) {
    NavHost(
        navController = navController,
        startDestination = startDestination,
        modifier = modifier,
    ) {
        homeScreen()
        loginScreen(navigateToHome = { navController.navigateToHome()}, navigateToRegister = { navController.navigateToRegister() })
        registerScreen(navigateToLogin = {navController.navigateToLogin()})

    }
}