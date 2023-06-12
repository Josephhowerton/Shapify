package com.fitness.tracking

import com.fitness.navigation.ComposableFeatureEntry

abstract class HealthTrackingEntry : ComposableFeatureEntry {

    final override val featureRoute: String = "health-tracking"

    fun destination() = featureRoute
}