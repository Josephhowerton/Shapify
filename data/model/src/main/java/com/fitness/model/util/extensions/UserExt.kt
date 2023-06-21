package com.fitness.model.util.extensions

import com.fitness.framework.enums.AccountType
import com.fitness.model.cache.user.UserEntity
import com.fitness.model.domain.user.User
import com.fitness.model.remote.user.UserDto
import com.google.firebase.auth.FirebaseUser
import java.util.Calendar


// Network to Cache
fun FirebaseUser.toUserDto(firstname: String, lastname: String) =
    UserDto(
        uid = uid,
        firstname = firstname,
        lastname = lastname,
        email = email,
        phone = phoneNumber,
        creationTimestamp = metadata?.creationTimestamp ?: Calendar.getInstance().timeInMillis,
        lastLoginTimestamp = metadata?.lastSignInTimestamp ?: Calendar.getInstance().timeInMillis,
    )

fun UserDto.toUserEntity() =
    UserEntity(
        uid = uid,
        firstname = firstname,
        lastname = lastname,
        email = email,
        phone = phone,
        creationTimestamp = creationTimestamp,
        lastLoginTimestamp = lastLoginTimestamp,
        accountType = AccountType.FREE_LEVEL_ZERO,
    )

// Cache to Network
fun UserEntity.toUserDto() =
    UserDto(
        uid = uid,
        firstname = firstname,
        lastname = lastname,
        email = email,
        phone = phone,
        creationTimestamp = creationTimestamp,
        lastLoginTimestamp = lastLoginTimestamp,
    )


// Cache to Domain
fun UserEntity.toUser() =
    User(
        uid = uid,
        displayName = "$firstname $lastname",
        email = email ?: "",
        phone = phone ?: "",
        creationTimestamp = creationTimestamp,
        lastLoginTimestamp = lastLoginTimestamp,
        accountType = accountType
    )


//Domain to Cache
fun User.toUserEntity() =
    UserEntity(
        uid = uid,
        firstname = displayName.split(" ")[0],
        lastname = displayName.split(" ")[1],
        email = email,
        phone = phone,
        creationTimestamp = creationTimestamp,
        lastLoginTimestamp = lastLoginTimestamp,
        accountType = accountType
    )