package com.fitness.tracking

import com.fitness.navigation.ComposableFeatureEntry

abstract class WorkoutTrackingEntry : ComposableFeatureEntry {

    final override val featureRoute: String = "workout-tracking"

    fun destination() = featureRoute
}