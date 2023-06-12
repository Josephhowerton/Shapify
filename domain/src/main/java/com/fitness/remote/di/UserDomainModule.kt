package com.fitness.remote.di

import com.fitness.remote.usecase.user.CreateUserUseCase
import dagger.Module
import dagger.Provides

@Module
class UserDomainModule {
    @Provides
    fun provideCreateUserUseCase() = CreateUserUseCase()
}