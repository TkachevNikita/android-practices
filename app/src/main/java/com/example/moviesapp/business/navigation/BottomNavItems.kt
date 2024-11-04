package com.example.moviesapp.business.navigation

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Home
import androidx.compose.material.icons.outlined.List
import androidx.compose.ui.graphics.vector.ImageVector

sealed class BottomNavItems(
    val route: String,
    val title: String,
    val icon: ImageVector
) {
    object ListMoviesScreen: BottomNavItems(
        route = Routes.LIST_OF_MOVIES,
        title = "Movies",
        icon = Icons.Outlined.List
    )

    object HomeScreen: BottomNavItems(
        route = Routes.HOME,
        title = "Home",
        icon = Icons.Outlined.Home
    )
}