package com.fitness.authentication.di

import com.fitness.auth.CreateEntry
import com.fitness.auth.LoginEntry
import com.fitness.auth.LogoutEntry
import com.fitness.authentication.navigation.CreateEntryImpl
import com.fitness.authentication.navigation.LoginEntryImpl
import com.fitness.authentication.navigation.LogoutEntryImpl
import com.fitness.navigation.FeatureEntry
import com.fitness.navigation.di.FeatureEntryKey
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap
import javax.inject.Singleton

@Module
interface AuthEntryModule {

    @Binds
    @Singleton
    @IntoMap
    @FeatureEntryKey(LoginEntry::class)
    fun loginEntry(entry: LoginEntryImpl) : FeatureEntry

    @Binds
    @Singleton
    @IntoMap
    @FeatureEntryKey(CreateEntry::class)
    fun createEntry(entry: CreateEntryImpl) : FeatureEntry

    @Binds
    @Singleton
    @IntoMap
    @FeatureEntryKey(LogoutEntry::class)
    fun logoutEntry(entry: LogoutEntryImpl) : FeatureEntry

}