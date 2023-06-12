package com.fitness.authentication.navigation


import androidx.compose.animation.ExperimentalAnimationApi
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import com.fitness.auth.CreateEntry
import com.fitness.authentication.create.CreateAccountEvent
import com.fitness.authentication.create.CreateAccountWithEmailScreen
import com.fitness.authentication.create.CreateAccountWithPhoneScreen
import com.fitness.authentication.di.component.DaggerCreateAccountComponent
import com.fitness.framework.extensions.cast
import com.fitness.framework.viewmodel.injectedViewModel
import com.fitness.navigation.Destinations
import com.fitness.navigation.find
import com.fitness.onboarding.OnboardingEntry
import com.google.accompanist.navigation.animation.composable
import com.google.accompanist.navigation.animation.navigation
import javax.inject.Inject

class CreateEntryImpl @Inject constructor() : CreateEntry() {

    private val rootRoute: String = "@create-account"
    private val phoneRoute = "ca-phone"

    @OptIn(ExperimentalAnimationApi::class)
    override fun NavGraphBuilder.navigation(
        navController: NavHostController,
        destinations: Destinations
    ) {
        navigation(startDestination = featureRoute, route = rootRoute) {


            composable(featureRoute) {
                val viewModel = injectedViewModel {
                    DaggerCreateAccountComponent
                        .builder()
                        .build()
                        .createAccountViewModel
                }



                CreateAccountWithEmailScreen(
                    state = viewModel.uiState.cast(),
                    onErrorEvent = { viewModel.onTriggerEvent(CreateAccountEvent.Reset) },
                    onCreateCompleteEvent = { navController.navigate(destinations.find<OnboardingEntry>().featureRoute) },
                    onTriggerEvent = { viewModel.onTriggerEvent(it) },
                    onPhoneAuthEvent = { navController.navigate(phoneRoute) },
                    verifyCredentials = { viewModel.verifyCredentials(it) }
                )

            }

            composable(phoneRoute) {

                val viewModel = injectedViewModel {
                    DaggerCreateAccountComponent
                        .builder()
                        .build()
                        .createAccountViewModel
                }

                CreateAccountWithPhoneScreen(
                    state = viewModel.uiState.cast(),
                    onErrorEvent = { viewModel.onTriggerEvent(CreateAccountEvent.Reset) },
                    onCreateCompleteEvent = { navController.navigate(destinations.find<OnboardingEntry>().featureRoute) },
                    onTriggerEvent = { viewModel.onTriggerEvent(it) },
                    onEmailAuthEvent = { navController.navigateUp() },
                    verifyCredentials = { viewModel.verifyCredentials(it) }
                )

            }
        }
    }
}