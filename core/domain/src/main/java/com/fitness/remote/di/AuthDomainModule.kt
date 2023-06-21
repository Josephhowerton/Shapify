package com.fitness.remote.di

import com.fitness.remote.usecase.auth.create.EmailPasswordCreateUseCase
import com.fitness.remote.usecase.auth.create.GoogleCreateUseCase
import com.fitness.remote.usecase.auth.create.PhoneNumberCreateUseCase
import com.fitness.remote.usecase.auth.create.TwitterCreateUseCase
import com.fitness.remote.usecase.auth.login.EmailPasswordLoginUseCase
import com.fitness.remote.usecase.auth.login.ForgotPasswordUseCase
import com.fitness.remote.usecase.auth.login.GoogleLoginUseCase
import com.fitness.remote.usecase.auth.login.PhoneNumberLoginUseCase
import com.fitness.remote.usecase.auth.login.TwitterLoginUseCase
import com.fitness.remote.usecase.auth.logout.LogoutUseCase
import com.fitness.repository.auth.AuthRepository
import dagger.Module
import dagger.Provides

@Module
class AuthDomainModule {

    @Provides
    fun provideEmailPasswordCreateUseCase(authRepository: AuthRepository) = EmailPasswordCreateUseCase(authRepository)

    @Provides
    fun provideGoogleCreateUseCase() = GoogleCreateUseCase()

    @Provides
    fun providePhoneNumberCreateUseCase(authRepository: AuthRepository) = PhoneNumberCreateUseCase(authRepository)

    @Provides
    fun provideTwitterCreateUseCase() = TwitterCreateUseCase()

    @Provides
    fun provideEmailPasswordLoginUseCase(authRepository: AuthRepository) = EmailPasswordLoginUseCase(authRepository)

    @Provides
    fun provideGoogleLoginUseCase() = GoogleLoginUseCase()

    @Provides
    fun providePhoneNumberLoginUseCase() = PhoneNumberLoginUseCase()

    @Provides
    fun provideTwitterLoginUseCase() = TwitterLoginUseCase()

    @Provides
    fun provideForgotPasswordUseCase(authRepository: AuthRepository) = ForgotPasswordUseCase(authRepository)

    @Provides
    fun provideLogoutOutUseCase(authRepository: AuthRepository) = LogoutUseCase(authRepository)
}