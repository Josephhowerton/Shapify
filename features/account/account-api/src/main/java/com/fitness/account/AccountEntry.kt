package com.fitness.account

import com.fitness.navigation.ComposableFeatureEntry

abstract class AccountEntry : ComposableFeatureEntry {

    final override val featureRoute: String = "account"

    fun destination() = featureRoute
}