package com.fitness.tracking.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavBackStackEntry
import androidx.navigation.NavHostController
import com.fitness.navigation.Destinations
import com.fitness.tracking.HealthTrackingEntry
import com.fitness.tracking.HealthTrackingScreen
import javax.inject.Inject

class HealthTrackingEntryImpl @Inject constructor(): HealthTrackingEntry() {

    @Composable
    override fun Composable(navController: NavHostController, destinations: Destinations, backStackEntry: NavBackStackEntry) {
        HealthTrackingScreen()
    }
}