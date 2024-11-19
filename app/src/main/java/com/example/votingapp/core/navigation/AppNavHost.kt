package com.example.votingapp.core.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import com.example.votingapp.core.navigation.login.loginNavigationRoute
import com.example.votingapp.core.navigation.pages.homeNavigationRoute
import com.example.votingapp.core.navigation.pages.homeScreen
import com.example.votingapp.core.navigation.pages.navigateToHome
import com.example.votingapp.core.navigation.login.loginScreen
import com.example.votingapp.core.navigation.login.navigateToLogin
import com.example.votingapp.core.navigation.register.navigateToRegister
import com.example.votingapp.core.navigation.register.registerScreen
import com.example.votingapp.core.navigation.pages.navigateToJoinVoting
import com.example.votingapp.core.navigation.pages.joinVotingScreen
import com.example.votingapp.core.navigation.pages.navigateToCreateVoting
import com.example.votingapp.core.navigation.pages.createVotingScreen
import com.example.votingapp.core.navigation.pages.historyScreen

@Composable
fun AppNavHost(
    navController: NavHostController,
    onBackClick: () -> Unit,
    modifier: Modifier = Modifier,
    startDestination: String = homeNavigationRoute
) {
    NavHost(
        navController = navController,
        startDestination = startDestination,
        modifier = modifier,
    ) {
        homeScreen(
            navigateToCreateVoting = { navController.navigateToCreateVoting() },
            navigateToJoinVoting = { navController.navigateToJoinVoting() }
        )
        loginScreen(
            navigateToHome = { navController.navigateToHome() },
            navigateToRegister = { navController.navigateToRegister() }
        )
        registerScreen(navigateToLogin = { navController.navigateToLogin() })
        joinVotingScreen()
        createVotingScreen()
        historyScreen()
    }
}
