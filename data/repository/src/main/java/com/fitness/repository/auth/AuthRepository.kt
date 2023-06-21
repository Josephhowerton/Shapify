package com.fitness.repository.auth


import com.google.android.gms.tasks.Continuation
import com.google.android.gms.tasks.Task
import com.google.android.gms.tasks.TaskExecutors
import com.google.firebase.auth.AuthResult
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import com.google.firebase.auth.UserProfileChangeRequest
import kotlinx.coroutines.coroutineScope
import javax.inject.Inject

class AuthRepository @Inject constructor() {

    private val auth = FirebaseAuth.getInstance()

    suspend fun createUserWithEmailAndPassword(email: String, password: String) =
        auth.createUserWithEmailAndPassword( email, password )

    suspend fun updateFirebaseAuthProfile(displayName: String, user: FirebaseUser) =
        user.updateProfile(
            UserProfileChangeRequest.Builder()
                .setDisplayName(displayName)
                .build()
        )

    fun loginUserWithEmailAndPassword(email: String, password: String)  =
        auth.signInWithEmailAndPassword(email, password)

    fun logout()  = auth.signOut()

    private suspend fun <TContinuationResult> Task<AuthResult>.continueWithUpdate(var1: Continuation<AuthResult?, TContinuationResult>): Task<TContinuationResult> {
        return coroutineScope {
            continueWith(TaskExecutors.MAIN_THREAD, var1)
        }
    }
}