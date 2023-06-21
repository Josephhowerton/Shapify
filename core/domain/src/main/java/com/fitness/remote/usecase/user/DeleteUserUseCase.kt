package com.fitness.remote.usecase.user

import com.fitness.framework.usecase.LocalUseCase
import com.fitness.repository.user.UserRepository
import kotlinx.coroutines.flow.FlowCollector
import javax.inject.Inject

class DeleteUserUseCase  @Inject constructor(
    private val userRepository: UserRepository
) : LocalUseCase<DeleteUserUseCase.Params, Unit>() {

    data class Params(val id: String)

    override suspend fun FlowCollector<Unit>.execute(params: Params) {
        userRepository.deleteUser(params.id)
        emit(Unit)
    }
}