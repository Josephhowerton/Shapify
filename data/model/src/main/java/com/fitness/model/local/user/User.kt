package com.fitness.model.local.user

data class User(
    val id: String,
    val displayName: String,
    val email: String?,
    val phone: String?
)
