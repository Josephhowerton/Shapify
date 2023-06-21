package com.fitness.framework.enums

enum class AuthState {
    StartUp,
    LoggedIn,
    LoggedOut,
}

enum class AuthUserCollisionCodes{
    ERROR_EMAIL_ALREADY_IN_USE,
    ERROR_ACCOUNT_EXISTS_WITH_DIFFERENT_CREDENTIAL,
    ERROR_CREDENTIAL_ALREADY_IN_USE
}