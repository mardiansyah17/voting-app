package com.example.votingapp.core.navigation.pages

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavOptions
import androidx.navigation.compose.composable
import com.example.votingapp.features.pages.CreateVotingScreen

const val createVotingNavigationRoute = "create_voting_route"

fun NavController.navigateToCreateVoting(navOptions: NavOptions? = null) {
    this.navigate(createVotingNavigationRoute, navOptions)
}

fun NavGraphBuilder.createVotingScreen() {
    composable(route = createVotingNavigationRoute) {
        CreateVotingScreen()
    }
}
