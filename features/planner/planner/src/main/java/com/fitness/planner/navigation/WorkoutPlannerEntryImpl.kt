package com.fitness.planner.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavBackStackEntry
import androidx.navigation.NavHostController
import com.fitness.navigation.Destinations
import com.fitness.planner.WorkoutPlannerEntry
import com.fitness.planner.fitness.planner.WorkoutPlannerScreen
import javax.inject.Inject

class WorkoutPlannerEntryImpl @Inject constructor(): WorkoutPlannerEntry() {

    @Composable
    override fun Composable(navController: NavHostController, destinations: Destinations, backStackEntry: NavBackStackEntry) {
        WorkoutPlannerScreen()
    }
}