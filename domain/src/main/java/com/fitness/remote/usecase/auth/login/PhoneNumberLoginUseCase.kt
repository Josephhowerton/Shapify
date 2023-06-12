package com.fitness.remote.usecase.auth.login

import com.fitness.framework.state.DataState
import com.fitness.framework.usecase.DataStateUseCase
import com.google.firebase.auth.FirebaseAuth
import kotlinx.coroutines.flow.FlowCollector

class PhoneNumberLoginUseCase: DataStateUseCase<PhoneNumberLoginUseCase.Params, Nothing>() {

    data class Params(val phoneNumber: String)

    override suspend fun FlowCollector<DataState<Nothing>>.execute(params: Params) {
        val auth = FirebaseAuth.getInstance()
    }
}