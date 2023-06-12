package com.fitness.profile.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavBackStackEntry
import androidx.navigation.NavHostController
import com.fitness.navigation.Destinations
import com.fitness.profile.ProfileEntry
import com.fitness.profile.profile.ProfileScreen
import javax.inject.Inject

class ProfileEntryImpl @Inject constructor(): ProfileEntry() {

    @Composable
    override fun Composable(navController: NavHostController, destinations: Destinations, backStackEntry: NavBackStackEntry) {
        ProfileScreen()
    }
}