package com.fitness.tracking.di

import com.fitness.navigation.FeatureEntry
import com.fitness.navigation.di.FeatureEntryKey
import com.fitness.tracking.HealthTrackingEntry
import com.fitness.tracking.WorkoutTrackingEntry
import com.fitness.tracking.navigation.HealthTrackingEntryImpl
import com.fitness.tracking.navigation.WorkoutTrackingImpl
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap
import javax.inject.Singleton

@Module
interface TrackingEntryModule {

    @Binds
    @Singleton
    @IntoMap
    @FeatureEntryKey(HealthTrackingEntry::class)
    fun  healthTrackingEntry(entry: HealthTrackingEntryImpl) : FeatureEntry

    @Binds
    @Singleton
    @IntoMap
    @FeatureEntryKey(WorkoutTrackingEntry::class)
    fun  workoutTrackingEntry(entry: WorkoutTrackingImpl) : FeatureEntry

}