package com.fitness.remote.usecase.auth.create

import com.fitness.framework.state.DataState
import com.fitness.framework.usecase.DataStateUseCase
import com.fitness.model.remote.user.UserDto
import com.fitness.repository.AuthRepository
import kotlinx.coroutines.flow.FlowCollector
import javax.inject.Inject

class PhoneNumberCreateUseCase @Inject constructor(
    private val authRepository: AuthRepository
) : DataStateUseCase<PhoneNumberCreateUseCase.Params, UserDto>() {

    data class Params(val firstname: String, val lastname: String, val phone: String)
    override suspend fun FlowCollector<DataState<UserDto>>.execute(params: Params) {}
}