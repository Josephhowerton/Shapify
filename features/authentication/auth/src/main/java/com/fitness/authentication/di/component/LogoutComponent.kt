package com.fitness.authentication.di.component

import com.fitness.authentication.di.module.LogoutModule
import com.fitness.authentication.logout.LogoutViewModel
import com.fitness.remote.di.AuthDomainModule
import dagger.Component
import javax.inject.Singleton

@Component(modules = [LogoutModule::class])
@Singleton
interface LogoutComponent {
    val logoutViewModel: LogoutViewModel
}