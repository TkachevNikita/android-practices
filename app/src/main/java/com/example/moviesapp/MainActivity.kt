package com.example.moviesapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.ui.Modifier
import androidx.navigation.compose.rememberNavController
import com.example.moviesapp.business.navigation.BottomBar
import com.example.moviesapp.business.navigation.NavigationGraph
import com.example.moviesapp.ui.theme.MoviesAppTheme

@OptIn(ExperimentalMaterial3Api::class)
class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {


        super.onCreate(savedInstanceState)
        setContent {
            MoviesAppTheme {
                val navController = rememberNavController()
                Scaffold (bottomBar = {
                    BottomBar(navController = navController)
                } ) {
                    Box(modifier = Modifier.padding(it)) {
                        NavigationGraph(navController = navController)
                    }
                }
            }
        }
    }
}

