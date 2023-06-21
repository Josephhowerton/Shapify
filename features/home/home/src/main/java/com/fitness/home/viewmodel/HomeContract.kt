package com.fitness.home.viewmodel

import com.fitness.model.domain.user.User

data class HomeState(
    val user: User
)

sealed class HomeEvent {
    data class LoadHomeData(val uid: String) : HomeEvent()
}