package com.fitness.authentication.di.component

import com.fitness.authentication.create.CreateAccountViewModel
import com.fitness.authentication.di.module.CreateAccountModule
import dagger.Component
import javax.inject.Singleton

@Component(modules = [CreateAccountModule::class])
@Singleton
interface CreateAccountComponent {
    val createAccountViewModel: CreateAccountViewModel
}