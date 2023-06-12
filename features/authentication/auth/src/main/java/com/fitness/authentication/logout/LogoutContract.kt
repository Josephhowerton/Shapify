package com.fitness.authentication.logout


data class LogoutState(val isDataSaved: Boolean = false)

sealed class LogoutEvent {
    data class LogoutData(val isDataSaved: Boolean) : LogoutEvent()
}