package com.fitness.onboarding

import com.fitness.navigation.AggregateFeatureEntry

abstract class OnboardingEntry : AggregateFeatureEntry {

    final override val featureRoute: String = "onboarding"

    fun destination() = featureRoute
}