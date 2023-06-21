package com.fitness.remote.usecase.user

import com.fitness.framework.usecase.LocalUseCase
import com.fitness.repository.user.UserRepository
import kotlinx.coroutines.flow.FlowCollector
import javax.inject.Inject

class UpdateUserUseCase  @Inject constructor(
    private val userRepository: UserRepository
) : LocalUseCase<UpdateUserUseCase.Params, Unit>() {

    sealed class Params{
        data class UpdateEmail(val id: String, val email: String): Params()
        data class UpdateDisplayName(val id: String, val firstname: String, val lastname: String): Params()
        data class UpdatePhoneNumber(val id: String, val phone: String): Params()
    }

    override suspend fun FlowCollector<Unit>.execute(params: Params) {
        when(params) {
            is Params.UpdateEmail -> {
                userRepository.updateUserEmail(params.id, params.email)
            }

            is Params.UpdateDisplayName -> {
                userRepository.updateUserDisplayName(params.id, params.firstname, params.lastname)
            }

            is Params.UpdatePhoneNumber -> {
                userRepository.updateUserPhone(params.id, params.phone)
            }
        }

        emit(Unit)
    }
}