package com.fitness.remote.usecase.auth.create


import com.fitness.framework.auth.auth
import com.fitness.framework.state.DataState
import com.fitness.framework.usecase.DataStateUseCase
import com.fitness.model.remote.user.UserDto
import com.fitness.model.util.extensions.toUserDto
import com.fitness.repository.auth.AuthRepository
import kotlinx.coroutines.flow.FlowCollector
import javax.inject.Inject

class EmailPasswordCreateUseCase @Inject constructor(
    private val authRepository: AuthRepository
) : DataStateUseCase<EmailPasswordCreateUseCase.Params, UserDto>() {

    data class Params(val firstname: String, val lastname: String, val email: String, val password: String)

    override suspend fun FlowCollector<DataState<UserDto>>.execute(params: Params) {
        val auth = authRepository.createUserWithEmailAndPassword(  email = params.email, password = params.password)

        val response = auth { auth }

        val userDto = response.map {
            it.toUserDto(firstname = params.firstname, lastname = params.lastname)
        }

        emit(userDto)
    }
}

