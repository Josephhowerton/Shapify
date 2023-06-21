package com.fitness.model.domain.user

import com.fitness.framework.enums.AccountType

data class User(
    val uid: String,
    val displayName: String,
    val email: String,
    val phone: String,
    val creationTimestamp: Long,
    val lastLoginTimestamp: Long,
    val accountType: AccountType,
)