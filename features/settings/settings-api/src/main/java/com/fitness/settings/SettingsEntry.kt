package com.fitness.settings

import com.fitness.navigation.ComposableFeatureEntry

abstract class SettingsEntry : ComposableFeatureEntry {

    final override val featureRoute: String = "settings"

    fun destination() = featureRoute
}