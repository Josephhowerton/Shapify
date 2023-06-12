package com.fitness.onboarding.navigation


import androidx.compose.animation.ExperimentalAnimationApi
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import com.fitness.framework.auth.AuthState
import com.fitness.framework.auth.AuthStateManager
import com.google.accompanist.navigation.animation.composable
import com.google.accompanist.navigation.animation.navigation
import com.fitness.home.HomeEntry
import com.fitness.navigation.Destinations
import com.fitness.navigation.find
import com.fitness.onboarding.OnboardingEntry
import com.fitness.onboarding.OnboardingScreenOne
import com.fitness.onboarding.OnboardingScreenThree
import com.fitness.onboarding.OnboardingScreenTwo
import javax.inject.Inject

class OnboardingEntryImpl @Inject constructor(): OnboardingEntry() {
    private val rootRoute: String = "@onboarding"
    private val onboardingTwo: String = "onboarding-two"
    private val onboardingThree: String = "onboarding-three"

    @OptIn(ExperimentalAnimationApi::class)
    override fun NavGraphBuilder.navigation(navController: NavHostController, destinations: Destinations) {
        navigation(startDestination = featureRoute, route = rootRoute) {

            composable(featureRoute) {
                OnboardingScreenOne {
                    navController.navigate(onboardingTwo)
                }
            }

            composable(onboardingTwo) {
                OnboardingScreenTwo {
                    navController.navigate(onboardingThree)
                }

            }

            composable(onboardingThree) {
                OnboardingScreenThree {
                    AuthStateManager.setAuthState(AuthState.LoggedIn)
                }
            }
        }
    }
}