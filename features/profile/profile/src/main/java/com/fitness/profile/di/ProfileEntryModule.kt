package com.fitness.profile.di

import com.fitness.navigation.FeatureEntry
import com.fitness.navigation.di.FeatureEntryKey
import com.fitness.profile.ProfileEntry
import com.fitness.profile.navigation.ProfileEntryImpl
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap
import javax.inject.Singleton

@Module
interface ProfileEntryModule {

    @Binds
    @Singleton
    @IntoMap
    @FeatureEntryKey(ProfileEntry::class)
    fun  profileEntry(entry: ProfileEntryImpl) : FeatureEntry

}