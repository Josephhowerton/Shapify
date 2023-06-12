package com.fitness.cache


interface UserSource {
    fun isUserLoggedIn(): Boolean
    fun createUser()
    fun readUserById()
    fun updateUserById()
    fun deleteUserById()
}