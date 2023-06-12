package com.fitness.training

import com.fitness.navigation.ComposableFeatureEntry

abstract class TrainingEntry : ComposableFeatureEntry {

    final override val featureRoute: String = "training-hub"

    fun destination() = featureRoute
}