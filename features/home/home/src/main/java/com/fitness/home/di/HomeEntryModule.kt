package com.fitness.home.di

import com.fitness.home.HomeEntry
import com.fitness.home.navigation.HomeEntryImpl
import com.fitness.navigation.FeatureEntry
import com.fitness.navigation.di.FeatureEntryKey
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap
import javax.inject.Singleton

@Module
interface HomeEntryModule {

    @Binds
    @Singleton
    @IntoMap
    @FeatureEntryKey(HomeEntry::class)
    fun homeEntry(entry: HomeEntryImpl) : FeatureEntry

}