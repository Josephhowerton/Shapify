package com.fitness.authentication.navigation

import androidx.compose.animation.ExperimentalAnimationApi
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import com.fitness.auth.LoginEntry
import com.fitness.authentication.di.component.DaggerLoginComponent
import com.fitness.authentication.forgot.ForgotPasswordEvent
import com.fitness.authentication.forgot.ForgotPasswordNumberScreen
import com.fitness.authentication.login.LoginEvent
import com.fitness.authentication.login.LoginWithEmailScreen
import com.fitness.authentication.login.LoginWithPhoneScreen
import com.fitness.framework.auth.AuthStateManager
import com.fitness.framework.auth.AuthState
import com.fitness.framework.extensions.cast
import com.fitness.framework.viewmodel.injectedViewModel
import com.fitness.navigation.Destinations
import com.google.accompanist.navigation.animation.composable
import com.google.accompanist.navigation.animation.navigation
import javax.inject.Inject

class LoginEntryImpl @Inject constructor(): LoginEntry() {

    private val rootRoute: String = "@login"
    private val phoneRoute: String = "login-phone"
    private val forgotPasswordRoute: String = "forgot-password"


    @OptIn(ExperimentalAnimationApi::class)
    override fun NavGraphBuilder.navigation(navController: NavHostController, destinations: Destinations) {
        navigation(startDestination = featureRoute, route = rootRoute) {

            composable(featureRoute) {

                val viewModel = injectedViewModel {
                    DaggerLoginComponent
                        .builder()
                        .build()
                        .loginViewModel
                }

                LoginWithEmailScreen(
                    state = viewModel.uiState.cast(),
                    onErrorEvent = { viewModel.onTriggerEvent(LoginEvent.Reset) },
                    onLoginCompleteEvent = { AuthStateManager.setAuthState(AuthState.LoggedIn) },
                    onTriggerEvent = { viewModel.onTriggerEvent(it) },
                    onForgotPasswordEvent = {navController.navigate(forgotPasswordRoute)},
                    onPhoneAuthEvent = {navController.navigate(phoneRoute)},
                    verifyCredentialsEvent = { viewModel.verifyCredentials(it) }
                )
            }

            composable(phoneRoute) {

                val viewModel = injectedViewModel {
                    DaggerLoginComponent
                        .builder()
                        .build()
                        .loginViewModel
                }

                LoginWithPhoneScreen(
                    state = viewModel.uiState.cast(),
                    onErrorEvent = { viewModel.onTriggerEvent(LoginEvent.Reset) },
                    onLoginCompleteEvent = { AuthStateManager.setAuthState(AuthState.LoggedIn) },
                    onTriggerEvent = { viewModel.onTriggerEvent(it) },
                    onEmailEvent = {navController.navigateUp()},
                    verifyCredentialsEvent = { viewModel.verifyCredentials(it) }
                )
            }

            composable(forgotPasswordRoute) {

                val viewModel = injectedViewModel {
                    DaggerLoginComponent
                        .builder()
                        .build()
                        .forgotViewModel
                }

                ForgotPasswordNumberScreen(
                    state = viewModel.uiState.cast(),
                    onErrorEvent = { viewModel.onTriggerEvent(ForgotPasswordEvent.Reset) },
                    onTriggerEvent = { viewModel.onTriggerEvent(it) },
                    verifyCredentialsEvent = { viewModel.verifyCredentials(it) })
            }
        }
    }
}