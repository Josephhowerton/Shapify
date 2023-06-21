package com.fitness.remote.di

import com.fitness.remote.usecase.user.CreateUserUseCase
import com.fitness.repository.user.UserRepository
import dagger.Module
import dagger.Provides

@Module
class UserDomainModule {
    @Provides
    fun provideCreateUserUseCase(userRepository: UserRepository) = CreateUserUseCase(userRepository)
}