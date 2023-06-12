package com.fitness.navigation.di

import com.fitness.navigation.FeatureEntry
import dagger.MapKey
import kotlin.reflect.KClass


@MapKey
annotation class FeatureEntryKey(val value: KClass<out FeatureEntry>)
