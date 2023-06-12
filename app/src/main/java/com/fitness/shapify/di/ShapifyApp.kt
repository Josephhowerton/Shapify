package com.fitness.shapify.di

import android.app.Application
import com.fitness.shapify.di.provider.AppProvider
import dagger.hilt.android.HiltAndroidApp
import javax.inject.Inject

@HiltAndroidApp
class ShapifyApp: Application() {
    @Inject
    lateinit var appProvider: AppProvider
}