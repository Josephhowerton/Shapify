package com.fitness.model.remote.user

data class UserDto(val uid: String,
                   val firstname: String,
                   val lastname: String,
                   val email: String?,
                   val phone: String?,
                   val lastLogin: String
)
