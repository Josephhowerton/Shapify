package com.fitness.remote.usecase.auth.login

import com.fitness.framework.state.DataState
import com.fitness.framework.usecase.DataStateUseCase
import com.google.firebase.auth.FirebaseAuth
import kotlinx.coroutines.flow.FlowCollector

class TwitterLoginUseCase : DataStateUseCase<TwitterLoginUseCase.Params, Nothing>()  {

    data class Params(val token: String)

    override suspend fun FlowCollector<DataState<Nothing>>.execute(params: Params) {
        TODO("implement twitter auth use case")
    }
}