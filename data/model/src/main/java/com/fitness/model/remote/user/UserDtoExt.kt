package com.fitness.model.remote.user

import com.fitness.model.local.user.User
import com.google.firebase.auth.FirebaseUser
import java.util.Calendar


fun FirebaseUser.toUserDto(firstname: String = "", lastname:String = "") =
        UserDto (
                uid = uid,
                firstname = firstname,
                lastname = lastname,
                email = email,
                phone = phoneNumber,
                lastLogin = Calendar.getInstance().time.toString()
        )

fun UserDto.toUser() =
        User (
                id = uid,
                displayName = "$firstname $lastname",
                email = email,
                phone = phone
        )