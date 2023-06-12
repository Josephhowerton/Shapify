package com.fitness.onboarding.di.component

import com.fitness.onboarding.di.module.OnboardingModule
import dagger.Component
import javax.inject.Singleton

@Component(modules = [OnboardingModule::class])
@Singleton
interface OnboardingComponent