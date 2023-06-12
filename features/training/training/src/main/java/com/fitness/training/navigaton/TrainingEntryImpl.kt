package com.fitness.training.navigaton

import androidx.compose.runtime.Composable
import androidx.navigation.NavBackStackEntry
import androidx.navigation.NavHostController
import com.fitness.navigation.Destinations
import com.fitness.training.TrainingEntry
import com.fitness.training.training.TrainingHubScreen
import javax.inject.Inject

class TrainingEntryImpl @Inject constructor(): TrainingEntry() {

    @Composable
    override fun Composable(navController: NavHostController, destinations: Destinations, backStackEntry: NavBackStackEntry) {
        TrainingHubScreen()
    }
}