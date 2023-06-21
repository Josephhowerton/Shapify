package com.fitness.home.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavBackStackEntry
import androidx.navigation.NavHostController
import com.fitness.home.HomeEntry
import com.fitness.home.HomeScreen
import com.fitness.navigation.Destinations
import javax.inject.Inject

class HomeEntryImpl @Inject constructor(): HomeEntry() {

    @Composable
    override fun Composable(navController: NavHostController, destinations: Destinations, backStackEntry: NavBackStackEntry) {
        HomeScreen()
    }
}