package com.example.votingapp.core.navigation.login

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavOptions
import androidx.navigation.compose.composable
import com.example.votingapp.features.login.LoginRoute

const val loginNavigationRoute = "login_route"

fun NavController.navigateToLogin(navOptions: NavOptions? = null) {
    this.navigate(loginNavigationRoute, navOptions)
}

fun NavGraphBuilder.loginScreen(navigateToHome: () -> Unit, navigateToRegister: () -> Unit) {
    composable(route = loginNavigationRoute) {
        LoginRoute(navigateToHome = navigateToHome, navigateToRegister =navigateToRegister )
    }
}