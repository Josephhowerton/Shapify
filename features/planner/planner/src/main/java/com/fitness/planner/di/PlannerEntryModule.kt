package com.fitness.planner.di

import com.fitness.navigation.FeatureEntry
import com.fitness.navigation.di.FeatureEntryKey
import com.fitness.planner.HealthPlannerEntry
import com.fitness.planner.WorkoutPlannerEntry
import com.fitness.planner.navigation.HealthPlannerEntryImpl
import com.fitness.planner.navigation.WorkoutPlannerEntryImpl
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap
import javax.inject.Singleton

@Module
interface PlannerEntryModule {

    @Binds
    @Singleton
    @IntoMap
    @FeatureEntryKey(HealthPlannerEntry::class)
    fun  healthPlannerEntry(entry: HealthPlannerEntryImpl) : FeatureEntry

    @Binds
    @Singleton
    @IntoMap
    @FeatureEntryKey(WorkoutPlannerEntry::class)
    fun  workoutPlannerEntry(entry: WorkoutPlannerEntryImpl) : FeatureEntry

}