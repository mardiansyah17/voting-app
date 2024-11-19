package com.example.votingapp.core.navigation.pages

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavOptions
import androidx.navigation.compose.composable
import com.example.votingapp.features.pages.JoinVotingScreen

const val joinVotingNavigationRoute = "join_voting_route"

fun NavController.navigateToJoinVoting(navOptions: NavOptions? = null) {
    this.navigate(joinVotingNavigationRoute, navOptions)
}

fun NavGraphBuilder.joinVotingScreen() {
    composable(route = joinVotingNavigationRoute) {
        JoinVotingScreen()
    }
}
