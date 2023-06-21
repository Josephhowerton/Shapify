package com.fitness.remote.usecase.auth.create

import com.fitness.framework.state.DataState
import com.fitness.framework.usecase.DataStateUseCase
import com.fitness.model.remote.user.UserDto
import kotlinx.coroutines.flow.FlowCollector
import javax.inject.Inject

class TwitterCreateUseCase @Inject constructor() : DataStateUseCase<TwitterCreateUseCase.Params, UserDto>() {

    data class Params(val firstname: String, val lastname: String)

    override suspend fun FlowCollector<DataState<UserDto>>.execute(params: Params) {
        TODO("implement twitter create use case")
    }
}