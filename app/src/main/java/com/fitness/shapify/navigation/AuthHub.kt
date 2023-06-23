package com.fitness.shapify.navigation

import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import com.fitness.auth.CreateEntry
import com.fitness.auth.LoginEntry
import com.fitness.welcome.WelcomeEntry
import com.fitness.navigation.find
import com.fitness.onboarding.OnboardingEntry
import com.fitness.shapify.di.LocalAppProvider
import com.google.accompanist.navigation.animation.AnimatedNavHost


@Composable
fun AuthHub(navController: NavHostController) {
    OnboardingNavigation(navController)
}
@OptIn(ExperimentalAnimationApi::class)
@Composable
private fun OnboardingNavigation(navController: NavHostController){
    val destination = LocalAppProvider.current.destinations

    val welcome = destination.find<WelcomeEntry>()
    val create = destination.find<CreateEntry>()
    val login = destination.find<LoginEntry>()
    val onboarding = destination.find<OnboardingEntry>()


    AnimatedNavHost(navController = navController, startDestination = welcome.featureRoute) {

        with(welcome) {
            composable(navController, destination)
        }

        with(login) {
            navigation(navController, destination)
        }

        with(create) {
            navigation(navController, destination)
        }

        with(onboarding) {
            navigation(navController, destination)
        }
    }
}