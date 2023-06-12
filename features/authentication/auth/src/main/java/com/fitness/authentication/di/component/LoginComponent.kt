package com.fitness.authentication.di.component

import com.fitness.authentication.di.module.LoginModule
import com.fitness.authentication.forgot.ForgotPasswordViewModel
import com.fitness.authentication.login.LoginViewModel
import dagger.Component
import javax.inject.Singleton

@Component(modules = [LoginModule::class])
@Singleton
interface LoginComponent {
    val loginViewModel: LoginViewModel
    val forgotViewModel: ForgotPasswordViewModel
}