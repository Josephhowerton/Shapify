package com.fitness.framework.auth

fun passwordVerification(password: String) : Boolean {
    val regex = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[@$!%*?&])[A-Za-z\\d@$!%*?&]{8,}$".toRegex()
    return password.matches(regex)
}