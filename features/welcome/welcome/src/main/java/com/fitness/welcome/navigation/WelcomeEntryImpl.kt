package com.fitness.welcome.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavBackStackEntry
import androidx.navigation.NavHostController
import com.fitness.auth.CreateEntry
import com.fitness.auth.LoginEntry
import com.fitness.navigation.Destinations
import com.fitness.navigation.find
import com.fitness.welcome.WelcomeScreen
import javax.inject.Inject

class WelcomeEntryImpl @Inject constructor(): com.fitness.welcome.WelcomeEntry() {

    @Composable
    override fun Composable(navController: NavHostController, destinations: Destinations, backStackEntry: NavBackStackEntry) {
        val loginEntry = destinations.find<LoginEntry>()
        val createEntry = destinations.find<CreateEntry>()
        WelcomeScreen(
            onLoginTap = { navController.navigate(loginEntry.featureRoute) },
            onCreateTap = { navController.navigate(createEntry.featureRoute) }
        )
    }
}