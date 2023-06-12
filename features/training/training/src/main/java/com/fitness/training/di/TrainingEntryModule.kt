package com.fitness.training.di

import com.fitness.navigation.FeatureEntry
import com.fitness.navigation.di.FeatureEntryKey
import com.fitness.training.TrainingEntry
import com.fitness.training.navigaton.TrainingEntryImpl
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap
import javax.inject.Singleton


@Module
interface TrainingEntryModule {

    @Binds
    @Singleton
    @IntoMap
    @FeatureEntryKey(TrainingEntry::class)
    fun  trainingEntry(entry: TrainingEntryImpl) : FeatureEntry

}