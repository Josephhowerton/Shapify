package com.fitness.auth

import com.fitness.navigation.AggregateFeatureEntry

abstract class CreateEntry : AggregateFeatureEntry {

    final override val featureRoute: String = "create"

    fun destination() = featureRoute
}