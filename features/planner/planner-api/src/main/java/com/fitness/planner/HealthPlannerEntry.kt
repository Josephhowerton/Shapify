package com.fitness.planner

import com.fitness.navigation.ComposableFeatureEntry

abstract class HealthPlannerEntry : ComposableFeatureEntry {

    final override val featureRoute: String = "diet-planner"

    fun destination() = featureRoute
}