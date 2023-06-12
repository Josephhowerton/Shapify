package com.fitness.authentication.logout

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import com.fitness.framework.state.BaseViewState
import kotlinx.coroutines.flow.StateFlow
import widget.ErrorScreen
import widget.LoadingScreen
import com.fitness.framework.R

@Composable
fun Logout(
    state: StateFlow<BaseViewState<LogoutState>>,
    onErrorEvent: () -> Unit,
    onLogoutCompleteEvent: () -> Unit,
    onTriggerEvent: (LogoutEvent) -> Unit,
) {

    val uiState by state.collectAsState()

    when (uiState) {
        is BaseViewState.Error -> {
            ErrorScreen(
                title = R.string.default_error_desc,
                description = R.string.default_error_desc,
                onClick = onErrorEvent
            )
        }

        is BaseViewState.Loading,
        BaseViewState.Empty -> {
            LoadingScreen()
            onTriggerEvent(LogoutEvent.LogoutData(true))
        }

        is BaseViewState.Complete -> {
            onLogoutCompleteEvent()
        }

        is BaseViewState.Data -> {
            onTriggerEvent(LogoutEvent.LogoutData(false))
        }
    }

}