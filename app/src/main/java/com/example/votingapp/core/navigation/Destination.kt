package com.example.votingapp.core.navigation

import com.example.votingapp.R
import com.example.votingapp.core.navigation.pages.homeNavigationRoute
import com.example.votingapp.core.navigation.pages.joinVotingNavigationRoute
import com.example.votingapp.core.navigation.login.loginNavigationRoute
import com.example.votingapp.core.navigation.pages.historyNavigationRoute
import com.example.votingapp.core.navigation.register.registerNavigationRoute
import com.example.votingapp.core.ui.AppIcons
import com.example.votingapp.core.ui.Icon


/**
 * Type for the top level destinations in the application. Each of these destinations
 * can contain one or more screens (based on the window size). Navigation from one screen to the
 * next within a single destination will be handled directly in composables.
 */


enum class Destination(
    val isTopLevelDestination: Boolean,
    val isBottomBarTab: Boolean,
    val isTopBarTab: Boolean,
    val selectedIcon: Icon? = null,
    val unselectedIcon: Icon? = null,
    val iconTextId: Int? = null,
    val titleTextId: Int,
    val route: String
) {
    HOME(
        isTopLevelDestination = true,
        isBottomBarTab = true,
        isTopBarTab = true,
        selectedIcon = Icon.DrawableResourceIcon(AppIcons.Home),
        unselectedIcon = Icon.DrawableResourceIcon(AppIcons.HomeBorder),
        iconTextId = R.string.home,
        titleTextId = R.string.home,
        route = homeNavigationRoute
    ),
    HISTORY(
        isTopLevelDestination = true,
        isBottomBarTab = true,
        isTopBarTab = true,
        selectedIcon = Icon.DrawableResourceIcon(AppIcons.History),
        unselectedIcon = Icon.DrawableResourceIcon(AppIcons.History),
        iconTextId = R.string.history,
        titleTextId = R.string.history,
        route = historyNavigationRoute
    ),

    LOGIN(
        isTopLevelDestination = true,
        isBottomBarTab = false,
        isTopBarTab = false,
        titleTextId = R.string.login,
        route = loginNavigationRoute
    ),

    REGISTER(
        isTopLevelDestination = true,
        isBottomBarTab = false,
        isTopBarTab = false,
        titleTextId = R.string.register,
        route = registerNavigationRoute
    ),
    JOIN(
        isTopLevelDestination = true,
        isBottomBarTab = false,
        isTopBarTab = true,
        selectedIcon = Icon.DrawableResourceIcon(AppIcons.Home),
        unselectedIcon = Icon.DrawableResourceIcon(AppIcons.HomeBorder),
        iconTextId = R.string.home,
        titleTextId = R.string.join_voting,
        route = joinVotingNavigationRoute
    );


}
