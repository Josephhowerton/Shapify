package com.fitness.authentication.navigation


import androidx.compose.runtime.Composable
import androidx.navigation.NavBackStackEntry
import androidx.navigation.NavHostController
import com.fitness.auth.LogoutEntry
import com.fitness.authentication.di.component.DaggerLogoutComponent
import com.fitness.authentication.logout.Logout
import com.fitness.authentication.logout.LogoutEvent
import com.fitness.framework.auth.AuthStateManager
import com.fitness.framework.auth.AuthState
import com.fitness.framework.extensions.cast
import com.fitness.framework.viewmodel.injectedViewModel
import com.fitness.navigation.Destinations
import javax.inject.Inject

class LogoutEntryImpl @Inject constructor() : LogoutEntry() {

    @Composable
    override fun Composable(
        navController: NavHostController,
        destinations: Destinations,
        backStackEntry: NavBackStackEntry
    ) {
        val viewModel = injectedViewModel {
            DaggerLogoutComponent
                .builder()
                .build()
                .logoutViewModel
        }

        Logout(
            state = viewModel.uiState.cast(),
            onErrorEvent = {
                viewModel.onTriggerEvent(LogoutEvent.LogoutData(true))
            },
            onLogoutCompleteEvent = {
                AuthStateManager.setAuthState(AuthState.LoggedOut)
            },
            onTriggerEvent = {
                viewModel.onTriggerEvent(it)
            }
        )
    }
}