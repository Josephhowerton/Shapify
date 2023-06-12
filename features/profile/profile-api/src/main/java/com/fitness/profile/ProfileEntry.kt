package com.fitness.profile

import com.fitness.navigation.ComposableFeatureEntry

abstract class ProfileEntry : ComposableFeatureEntry {

    final override val featureRoute: String = "profile"

    fun destination() = featureRoute
}