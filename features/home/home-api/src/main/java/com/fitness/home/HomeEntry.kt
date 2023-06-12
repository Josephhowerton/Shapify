package com.fitness.home

import com.fitness.navigation.ComposableFeatureEntry

abstract class HomeEntry : ComposableFeatureEntry {

    final override val featureRoute: String = "home"

    fun destination() = featureRoute
}