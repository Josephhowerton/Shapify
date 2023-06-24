package commons

import NAVIGATION
import addCommonDependencies
import config.Configs
import org.gradle.api.JavaVersion
import org.gradle.kotlin.dsl.dependencies

plugins {
    kotlin("kapt")
    id("kotlin-android")
    id("com.android.library")
    id("org.jetbrains.kotlin.android")
    id("org.jetbrains.kotlin.plugin.parcelize")
    id("flavors")
}

android {
    compileSdk = Configs.CompileSdk

    defaultConfig {
        minSdk = Configs.MinSdk
        testInstrumentationRunner = Configs.AndroidJunitRunner
        vectorDrawables {
            useSupportLibrary = true
        }
    }

    compileOptions {
        sourceCompatibility = Configs.SourceCompatibility
        targetCompatibility = Configs.TargetCompatibility
    }
    kotlinOptions {
        jvmTarget = Configs.JvmTarget
    }
}


dependencies {
    NAVIGATION

    addCommonDependencies()
}