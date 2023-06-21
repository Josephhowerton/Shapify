package com.fitness.model.remote.user

import android.os.Parcelable
import kotlinx.parcelize.Parcelize
@Parcelize
data class UserDto(
    val uid: String,
    val firstname: String,
    val lastname: String,
    val email: String?,
    val phone: String?,
    val creationTimestamp: Long,
    val lastLoginTimestamp: Long
) : Parcelable