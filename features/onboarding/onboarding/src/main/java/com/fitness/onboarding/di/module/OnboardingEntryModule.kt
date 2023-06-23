package com.fitness.onboarding.di.module

import com.fitness.navigation.FeatureEntry
import com.fitness.navigation.di.FeatureEntryKey
import com.fitness.onboarding.OnboardingEntry
import com.fitness.onboarding.navigation.OnboardingEntryImpl
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap
import javax.inject.Singleton


@Module
interface OnboardingEntryModule {

    @Binds
    @Singleton
    @IntoMap
    @FeatureEntryKey(OnboardingEntry::class)
    fun onboardingEntry(entry: OnboardingEntryImpl) : FeatureEntry
}