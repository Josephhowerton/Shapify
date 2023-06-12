package com.fitness.welcome.di

import com.fitness.navigation.FeatureEntry
import com.fitness.navigation.di.FeatureEntryKey
import com.fitness.welcome.WelcomeEntry
import com.fitness.welcome.navigation.WelcomeEntryImpl
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap
import javax.inject.Singleton


@Module
interface WelcomeEntryModule {

    @Binds
    @Singleton
    @IntoMap
    @FeatureEntryKey(WelcomeEntry::class)
    fun welcomeEntry(entry: WelcomeEntryImpl) : FeatureEntry
}