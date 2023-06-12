package com.fitness.authentication.util

import android.util.Log
import com.fitness.framework.auth.AuthState
import com.google.firebase.auth.FirebaseAuth
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow

object AuthStateManager : FirebaseAuth.AuthStateListener {
    private val state = MutableStateFlow(AuthState.StartUp)
    val authState = state.asStateFlow()

    override fun onAuthStateChanged(auth: FirebaseAuth) {
        if(authState.value == AuthState.StartUp) {
            auth.currentUser?.let {
                state.value = AuthState.LoggedIn
            } ?: run {
                Log.e("LogoutComplete", "AuthStateManager")
                state.value = AuthState.LoggedOut
            }
        }
    }
}