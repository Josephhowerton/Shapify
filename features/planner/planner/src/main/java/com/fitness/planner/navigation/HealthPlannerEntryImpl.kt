package com.fitness.planner.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavBackStackEntry
import androidx.navigation.NavHostController
import com.fitness.navigation.Destinations
import com.fitness.planner.HealthPlannerEntry
import com.fitness.planner.fitness.planner.DietPlannerScreen
import javax.inject.Inject

class HealthPlannerEntryImpl @Inject constructor() : HealthPlannerEntry() {

    @Composable
    override fun Composable(navController: NavHostController, destinations: Destinations, backStackEntry: NavBackStackEntry) {
        DietPlannerScreen()
    }
}