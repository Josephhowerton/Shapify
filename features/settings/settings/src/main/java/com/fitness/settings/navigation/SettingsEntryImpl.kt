package com.fitness.settings.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavBackStackEntry
import androidx.navigation.NavHostController
import com.fitness.navigation.Destinations
import com.fitness.settings.SettingsEntry
import com.fitness.settings.settings.SettingsScreen
import javax.inject.Inject

class SettingsEntryImpl @Inject constructor(): SettingsEntry() {

    @Composable
    override fun Composable(navController: NavHostController, destinations: Destinations, backStackEntry: NavBackStackEntry) {
        SettingsScreen()
    }
}