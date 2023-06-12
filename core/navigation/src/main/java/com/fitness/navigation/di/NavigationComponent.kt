package com.fitness.navigation.di

import dagger.hilt.DefineComponent
import dagger.hilt.components.SingletonComponent

@DefineComponent(parent = SingletonComponent::class)
@FeatureScoped
interface NavigationComponent