package com.fitness.remote.usecase.auth.logout

import com.fitness.framework.usecase.LocalUseCase
import com.fitness.repository.auth.AuthRepository
import kotlinx.coroutines.flow.FlowCollector
import javax.inject.Inject

/*
TODO("finish logout auth use case")
 */
class LogoutUseCase @Inject constructor(
    private val authRepository: AuthRepository
) : LocalUseCase<LogoutUseCase.Params, Unit>() {

    data class Params(val unsavedData: Boolean = false)

    override suspend fun FlowCollector<Unit>.execute(params: Params) {
        authRepository.logout()
        emit(Unit)
    }
}