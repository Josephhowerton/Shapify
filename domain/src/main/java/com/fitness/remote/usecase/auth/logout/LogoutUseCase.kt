package com.fitness.remote.usecase.auth.logout

import com.fitness.framework.state.DataState
import com.fitness.framework.usecase.DataStateUseCase
import com.fitness.repository.AuthRepository
import kotlinx.coroutines.flow.FlowCollector
import javax.inject.Inject

class LogoutUseCase @Inject constructor(
    private val authRepository: AuthRepository
) : DataStateUseCase<LogoutUseCase.Params, Boolean>() {

    data class Params(val unsavedData: Boolean = false)

    override suspend fun FlowCollector<DataState<Boolean>>.execute(params: Params) {
        authRepository.logout()
        emit(DataState.Success(params.unsavedData))
    }
}