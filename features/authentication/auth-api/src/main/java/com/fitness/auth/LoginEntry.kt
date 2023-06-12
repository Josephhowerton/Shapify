package com.fitness.auth

import com.fitness.navigation.AggregateFeatureEntry

abstract class LoginEntry : AggregateFeatureEntry {

    final override val featureRoute: String = "login"

    fun destination() = featureRoute
}