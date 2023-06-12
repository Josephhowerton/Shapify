package com.fitness.authentication.forgot

data class ForgotPasswordState(
    val isVerified: Boolean = false
)

sealed class ForgotPasswordEvent {
    data class ForgotPasswordData(val email:String, val password:String, val confirmPassword: String) : ForgotPasswordEvent()
    object Reset : ForgotPasswordEvent()
}