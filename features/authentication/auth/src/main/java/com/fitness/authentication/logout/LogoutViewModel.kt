package com.fitness.authentication.logout

import com.fitness.framework.state.BaseViewState
import com.fitness.framework.viewmodel.IntentViewModel
import com.fitness.remote.usecase.auth.logout.LogoutUseCase
import javax.inject.Inject

class LogoutViewModel @Inject constructor(
    private val logoutUseCase: LogoutUseCase
) : IntentViewModel<BaseViewState<LogoutState>, LogoutEvent>() {

    init {
        setState(BaseViewState.Data(LogoutState()))
    }
    override fun onTriggerEvent(event: LogoutEvent) {
        when(event) {
            is LogoutEvent.LogoutData -> {
                onLogout()
            }
        }
    }
    private fun onLogout() = safeLaunch {
        call(logoutUseCase(LogoutUseCase.Params())) {
            setState(BaseViewState.Complete)
        }
    }
}