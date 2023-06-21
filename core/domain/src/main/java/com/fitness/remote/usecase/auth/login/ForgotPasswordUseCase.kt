package com.fitness.remote.usecase.auth.login

import com.fitness.framework.state.DataState
import com.fitness.framework.usecase.DataStateUseCase
import com.fitness.repository.auth.AuthRepository
import kotlinx.coroutines.flow.FlowCollector
import javax.inject.Inject

class ForgotPasswordUseCase @Inject constructor(
    private val repository: AuthRepository
) : DataStateUseCase<ForgotPasswordUseCase.Params, Nothing>() {

    data class Params(val email: String, val password: String, val confirmPassword: String)

    override suspend fun FlowCollector<DataState<Nothing>>.execute(params: Params) {
        TODO("implement forgot password use case")
    }
}