package com.example.moviesapp.business.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.example.moviesapp.business.home.Home
import com.example.moviesapp.business.movie.MovieScreen
import com.example.moviesapp.business.moviesList.MoviesScreen

@Composable
fun NavigationGraph(navController: NavHostController) {
    NavHost(navController, startDestination = Routes.LIST_OF_MOVIES) {
        composable(Routes.LIST_OF_MOVIES) {
            MoviesScreen() {
                navController.navigate(it)
            }
        }
        composable(Routes.HOME) {
            Home()
        }

        composable(route = Routes.MOVIE, arguments = listOf(navArgument("id") {})) {
            MovieScreen(it.arguments?.getString("id")?: "0")
        }
    }
}