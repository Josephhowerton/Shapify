package com.fitness.framework.usecase

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOn

abstract class ReturnUseCase<in Params,  ReturnType> where ReturnType: Any {

    protected abstract suspend fun execute(params: Params): Flow<ReturnType>

    suspend operator fun invoke(params: Params) = execute(params).flowOn(Dispatchers.IO)
}