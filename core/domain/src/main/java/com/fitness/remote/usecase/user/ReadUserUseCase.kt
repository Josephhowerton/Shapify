package com.fitness.remote.usecase.user

import com.fitness.framework.usecase.LocalUseCase
import com.fitness.model.cache.user.UserEntity
import com.fitness.model.domain.user.User
import com.fitness.model.util.extensions.toUser
import com.fitness.repository.user.UserRepository
import kotlinx.coroutines.flow.FlowCollector
import kotlinx.coroutines.tasks.await
import javax.inject.Inject

/*
TODO("update implementation")
 */
class ReadUserUseCase  @Inject constructor(
    private val userRepository: UserRepository
) : LocalUseCase<ReadUserUseCase.Params, User>() {

    data class Params(val id: String)

    override suspend fun FlowCollector<User>.execute(params: Params) {
        val user = userRepository
            .readUser(params.id)
            .await().toObject(UserEntity::class.java)

        user?.let {
            emit(user.toUser())
        } ?: run {
            throw Exception()
        }
    }
}