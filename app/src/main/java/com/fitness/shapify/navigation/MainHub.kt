package com.fitness.shapify.navigation

import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import com.fitness.account.AccountEntry
import com.fitness.analysis.AnalysisEntry
import com.fitness.auth.LogoutEntry
import com.fitness.home.HomeEntry
import com.fitness.navigation.find
import com.fitness.planner.HealthPlannerEntry
import com.fitness.planner.WorkoutPlannerEntry
import com.fitness.profile.ProfileEntry
import com.fitness.settings.SettingsEntry
import com.fitness.shapify.components.drawer.AppBarWithNavigationDrawer
import com.fitness.shapify.di.provider.LocalAppProvider
import com.fitness.tracking.HealthTrackingEntry
import com.fitness.tracking.WorkoutTrackingEntry
import com.fitness.training.TrainingEntry
import com.google.accompanist.navigation.animation.AnimatedNavHost
import util.DrawerNavigationUtil


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MainHub(navController: NavHostController) {
    AppBarWithNavigationDrawer(
        items = DrawerNavigationUtil.drawerNavItems,
        navController = navController
    )
}

@OptIn(ExperimentalAnimationApi::class)
@Composable
fun HomeNavigation(navController: NavHostController) {
    val destination = LocalAppProvider.current.destinations

    val account = destination.find<AccountEntry>()
    val settings = destination.find<SettingsEntry>()
    val analysis = destination.find<AnalysisEntry>()
    val home = destination.find<HomeEntry>()
    val healthPlanner = destination.find<HealthPlannerEntry>()
    val workoutPlanner = destination.find<WorkoutPlannerEntry>()
    val profile = destination.find<ProfileEntry>()
    val training = destination.find<TrainingEntry>()
    val workoutTracking = destination.find<WorkoutTrackingEntry>()
    val healthTracking = destination.find<HealthTrackingEntry>()
    val logout = destination.find<LogoutEntry>()

    AnimatedNavHost(
        navController = navController,
        startDestination = home.featureRoute,
    ) {
        with(account){
            composable(navController, destination)
        }

        with(analysis){
            composable(navController, destination)
        }

        with(home){
            composable(navController, destination)
        }

        with(healthPlanner){
            composable(navController, destination)
        }

        with(workoutPlanner){
            composable(navController, destination)
        }

        with(profile){
            composable(navController, destination)
        }

        with(settings){
            composable(navController, destination)
        }

        with(training){
            composable(navController, destination)
        }

        with(workoutTracking){
            composable(navController, destination)
        }

        with(healthTracking){
            composable(navController, destination)
        }

        with(logout){
            composable(navController, destination)
        }
    }
}