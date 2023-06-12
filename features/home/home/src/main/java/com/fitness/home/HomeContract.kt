package com.fitness.home

import com.fitness.model.local.user.User

data class HomeState(val user: User)

sealed class HomeEvent {
    data class LoadHomeData(val id: String) : HomeEvent()
}