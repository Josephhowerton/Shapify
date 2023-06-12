package com.fitness.authentication.di.module

import com.fitness.remote.di.AuthDomainModule
import com.fitness.remote.di.UserDomainModule
import dagger.Module


@Module(includes = [AuthDomainModule::class, UserDomainModule::class])
interface CreateAccountModule