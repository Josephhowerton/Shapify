package com.fitness.navigation.di

import dagger.hilt.DefineComponent

@DefineComponent.Builder
interface NavigationComponentBuilder {
    fun build() : NavigationComponent
}