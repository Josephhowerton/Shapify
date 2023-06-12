package com.fitness.welcome

import com.fitness.navigation.ComposableFeatureEntry

abstract class WelcomeEntry : ComposableFeatureEntry {

    final override val featureRoute: String = "welcome"

    fun destination() = featureRoute
}