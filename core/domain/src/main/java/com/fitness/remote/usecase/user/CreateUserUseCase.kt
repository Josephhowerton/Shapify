package com.fitness.remote.usecase.user

import com.fitness.framework.usecase.LocalUseCase
import com.fitness.model.util.extensions.toUserEntity
import com.fitness.model.remote.user.UserDto
import com.fitness.repository.user.UserRepository
import kotlinx.coroutines.flow.FlowCollector
import javax.inject.Inject

class CreateUserUseCase @Inject constructor(
    private val userRepository: UserRepository
) : LocalUseCase<CreateUserUseCase.Params, Unit>() {

    data class Params(val userDto: UserDto)

    override suspend fun FlowCollector<Unit>.execute(params: Params) {
        userRepository.createUser(params.userDto.toUserEntity())
        emit(Unit)
    }

}