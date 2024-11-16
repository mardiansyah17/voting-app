package com.example.votingapp.core.navigation.register

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavOptions
import androidx.navigation.compose.composable
import com.example.votingapp.features.register.RegisterRoute

const val registerNavigationRoute = "register_route"

fun NavController.navigateToRegister(navOptions: NavOptions? = null) {
    this.navigate(registerNavigationRoute, navOptions)
}

fun NavGraphBuilder.registerScreen(navigateToLogin: () -> Unit) {
    composable(route = registerNavigationRoute) {
        RegisterRoute(navigateToLogin = navigateToLogin)
    }
}