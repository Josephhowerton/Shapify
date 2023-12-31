package com.fitness.framework.auth


import com.fitness.framework.state.DataState
import com.google.android.gms.tasks.Task
import com.google.firebase.auth.AuthResult
import com.google.firebase.auth.FirebaseUser
import kotlinx.coroutines.tasks.await

suspend fun <T: Task<AuthResult>> authenticate(call: () -> T): DataState<FirebaseUser> {
    val response = call().await()

    response.user?.let {
        return DataState.Success(it)
    }

    return DataState.Error(Exception().handleAuthFailure())
}
