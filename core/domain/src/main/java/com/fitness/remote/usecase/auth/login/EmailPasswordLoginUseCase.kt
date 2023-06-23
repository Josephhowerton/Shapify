package com.fitness.remote.usecase.auth.login

import com.fitness.framework.auth.authenticate
import com.fitness.framework.state.DataState
import com.fitness.framework.usecase.DataStateUseCase
import com.fitness.model.remote.user.UserDto
import com.fitness.model.util.extensions.toUserDto
import com.fitness.repository.auth.AuthRepository
import kotlinx.coroutines.flow.FlowCollector
import javax.inject.Inject

class EmailPasswordLoginUseCase @Inject constructor(
    private val repository: AuthRepository
) : DataStateUseCase<EmailPasswordLoginUseCase.Params, UserDto>() {

    data class Params(val email: String, val password: String)

    override suspend fun FlowCollector<DataState<UserDto>>.execute(params: Params) {
        val auth = repository.loginUserWithEmailAndPassword(email = params.email, password = params.password)

        val response = authenticate { auth }

        val userDto = response.map{
            it.toUserDto("", "")
        }

        emit(userDto)
    }
}

