package com.fitness.authentication.logout

import com.fitness.authentication.login.LoginState
import com.fitness.framework.state.BaseViewState
import com.fitness.framework.viewmodel.IntentViewModel
import com.fitness.remote.usecase.auth.logout.LogoutUseCase
import com.fitness.remote.usecase.user.CreateUserUseCase
import com.fitness.repository.AuthRepository
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
        execute(logoutUseCase(LogoutUseCase.Params())) {
            setState(BaseViewState.Complete)
        }
    }
}