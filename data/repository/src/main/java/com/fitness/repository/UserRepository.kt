package com.fitness.repository

import com.fitness.cache.UserSource
import javax.inject.Inject

class UserRepository @Inject constructor() : UserSource {
    override fun isUserLoggedIn(): Boolean {
        TODO("Not yet implemented")
    }

    override fun createUser() {
        TODO("Not yet implemented")
    }

    override fun readUserById() {
        TODO("Not yet implemented")
    }

    override fun updateUserById() {
        TODO("Not yet implemented")
    }

    override fun deleteUserById() {
        TODO("Not yet implemented")
    }
}