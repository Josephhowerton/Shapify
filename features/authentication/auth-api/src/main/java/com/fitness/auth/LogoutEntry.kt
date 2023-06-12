package com.fitness.auth

import com.fitness.navigation.ComposableFeatureEntry

abstract class LogoutEntry : ComposableFeatureEntry {
    final override val featureRoute: String = "logout"
}