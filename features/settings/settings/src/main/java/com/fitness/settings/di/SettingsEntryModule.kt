package com.fitness.settings.di

import com.fitness.navigation.FeatureEntry
import com.fitness.navigation.di.FeatureEntryKey
import com.fitness.settings.SettingsEntry
import com.fitness.settings.navigation.SettingsEntryImpl
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap
import javax.inject.Singleton

@Module
interface SettingsEntryModule {

    @Binds
    @Singleton
    @IntoMap
    @FeatureEntryKey(SettingsEntry::class)
    fun  settingsEntry(entry: SettingsEntryImpl) : FeatureEntry

}