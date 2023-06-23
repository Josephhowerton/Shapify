package com.fitness.shapify.di

import account.com.fitness.di.AccountEntryModule
import analysis.com.fitness.di.AnalysisEntryModule
import android.app.Application
import android.content.Context
import com.fitness.authentication.di.AuthEntryModule
import com.fitness.home.di.HomeEntryModule
import com.fitness.navigation.Destinations
import com.fitness.onboarding.di.module.OnboardingEntryModule
import com.fitness.planner.di.PlannerEntryModule
import com.fitness.profile.di.ProfileEntryModule
import com.fitness.settings.di.SettingsEntryModule
import com.fitness.tracking.di.TrackingEntryModule
import com.fitness.training.di.TrainingEntryModule
import com.fitness.welcome.di.WelcomeEntryModule
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module(includes = [
    AccountEntryModule::class,
    AnalysisEntryModule::class,
    AuthEntryModule::class,
    HomeEntryModule::class,
    OnboardingEntryModule::class,
    PlannerEntryModule::class,
    ProfileEntryModule::class,
    SettingsEntryModule::class,
    TrackingEntryModule::class,
    TrainingEntryModule::class,
    WelcomeEntryModule::class
])
@InstallIn(SingletonComponent::class)
class AppModule {
    @Provides
    @Singleton
    fun provideContext(application: Application): Context = application

    @Provides
    @Singleton
    fun provideAppProvider(destinations: Destinations): AppProvider = AppProvider(destinations)
}