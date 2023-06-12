package com.fitness.tracking.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavBackStackEntry
import androidx.navigation.NavHostController
import com.fitness.navigation.Destinations
import com.fitness.tracking.HealthTrackingScreen
import com.fitness.tracking.WorkoutTrackingEntry
import javax.inject.Inject

class WorkoutTrackingImpl @Inject constructor(): WorkoutTrackingEntry() {

    @Composable
    override fun Composable(navController: NavHostController, destinations: Destinations, backStackEntry: NavBackStackEntry) {
        HealthTrackingScreen()
    }
}