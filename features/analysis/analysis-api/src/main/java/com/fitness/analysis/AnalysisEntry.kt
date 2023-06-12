package com.fitness.analysis

import com.fitness.navigation.ComposableFeatureEntry

abstract class AnalysisEntry : ComposableFeatureEntry {

    final override val featureRoute: String = "analysis"

    fun destination() = featureRoute
}