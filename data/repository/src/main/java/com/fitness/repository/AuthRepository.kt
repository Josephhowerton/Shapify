package com.fitness.repository


import com.google.firebase.auth.FirebaseAuth
import javax.inject.Inject

class AuthRepository @Inject constructor() {

    private val auth = FirebaseAuth.getInstance()

    fun createUserWithEmailAndPassword(email: String, password: String) =
        auth.createUserWithEmailAndPassword( email, password )


    fun loginUserWithEmailAndPassword(email: String, password: String)  =
        auth.signInWithEmailAndPassword(email, password)

    fun logout()  = auth.signOut()
}