package com.fitness.authentication.forgot

import android.util.Patterns
import com.fitness.framework.auth.handleAuthFailure
import com.fitness.framework.state.BaseViewState
import com.fitness.framework.auth.passwordVerification
import com.fitness.framework.viewmodel.IntentViewModel
import com.fitness.remote.usecase.auth.login.ForgotPasswordUseCase
import javax.inject.Inject

class ForgotPasswordViewModel @Inject constructor(
    val forgotPasswordUseCase: ForgotPasswordUseCase,
) : IntentViewModel<BaseViewState<ForgotPasswordState>, ForgotPasswordEvent>() {

    init {
        setState(BaseViewState.Data(ForgotPasswordState()))
    }

    override fun onTriggerEvent(event: ForgotPasswordEvent) {
        when(event) {
            is ForgotPasswordEvent.ForgotPasswordData -> {
                onForgotPasswordAuth(event.email, event.password, event.confirmPassword)
            }
            else -> {
                setState(
                    BaseViewState.Data(ForgotPasswordState())
                )
            }
        }
    }

    override fun handleError(exception: Throwable) {
        super.handleError(exception.handleAuthFailure())
    }

    fun verifyCredentials(event: ForgotPasswordEvent) {
        event as ForgotPasswordEvent.ForgotPasswordData
        val email = event.email
        val password = event.password
        val confirmPassword = event.confirmPassword
        setState(
            BaseViewState.Data(
                ForgotPasswordState(
                Patterns.EMAIL_ADDRESS.matcher(email).matches() && passwordVerification(password) && passwordVerification(confirmPassword) && password == confirmPassword
                )
            )
        )
    }

    private fun onForgotPasswordAuth(email: String, password: String, confirmPassword: String) = safeLaunch {
        val params = ForgotPasswordUseCase.Params(email, password, confirmPassword)
        execute(forgotPasswordUseCase(params)) {

        }
    }

}