package com.fitness.authentication.di.module

import com.fitness.remote.di.AuthDomainModule
import dagger.Module


@Module(includes = [AuthDomainModule::class])
interface LogoutModule