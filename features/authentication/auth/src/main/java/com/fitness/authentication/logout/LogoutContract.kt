package com.fitness.authentication.logout


data class LogoutState(val isDataSaved: Boolean)

sealed class LogoutEvent {
    data class LogoutData(val isDataSaved: Boolean) : LogoutEvent()
}