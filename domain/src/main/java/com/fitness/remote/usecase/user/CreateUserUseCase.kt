package com.fitness.remote.usecase.user

import com.fitness.framework.state.DataState
import com.fitness.framework.usecase.DataStateUseCase
import com.fitness.framework.usecase.LocalUseCase
import com.fitness.model.remote.user.UserDto
import kotlinx.coroutines.flow.FlowCollector

class CreateUserUseCase : DataStateUseCase<CreateUserUseCase.Params, Boolean>() {

    data class Params(val userDto: UserDto)

    override suspend fun FlowCollector<DataState<Boolean>>.execute(params: Params) {
        emit(DataState.Success(true))
    }
}