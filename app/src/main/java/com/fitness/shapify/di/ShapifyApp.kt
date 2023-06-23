package com.fitness.shapify.di

import android.app.Application
import dagger.hilt.android.HiltAndroidApp
import javax.inject.Inject

@HiltAndroidApp
class ShapifyApp: Application() {
    @Inject
    lateinit var appProvider: AppProvider
}