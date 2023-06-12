package com.fitness.planner

import com.fitness.navigation.ComposableFeatureEntry

abstract class WorkoutPlannerEntry : ComposableFeatureEntry {

    final override val featureRoute: String = "workout-planner"

    fun destination() = featureRoute
}