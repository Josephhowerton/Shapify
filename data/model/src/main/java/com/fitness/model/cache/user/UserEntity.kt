package com.fitness.model.cache.user

import com.fitness.framework.enums.AccountType

data class  UserEntity(
    val uid: String,
    val firstname: String,
    val lastname: String,
    val email: String?,
    val phone: String?,
    val creationTimestamp: Long,
    val lastLoginTimestamp: Long,
    val accountType: AccountType
)