package commons

import addCommonDependencies
import addComposeDependencies
import addCoreModuleDependencies
import addDagger2Dependencies
import addDataModuleDependencies
import addNavigationDependencies
import config.Configs
import org.gradle.api.JavaVersion
import org.gradle.kotlin.dsl.dependencies

plugins {
    kotlin("kapt")
    id("kotlin-android")
    id("com.android.library")
    id("org.jetbrains.kotlin.android")
    id("org.jetbrains.kotlin.plugin.parcelize")
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

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro")
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }
    kotlinOptions {
        jvmTarget = Configs.JvmTarget
    }

    buildFeatures.compose = true

    composeOptions {
        kotlinCompilerExtensionVersion = config.Configs.KotlinCompilerExtensionVersion
    }
}


dependencies {
    addCommonDependencies()
    addComposeDependencies()
    addDataModuleDependencies()
    addCoreModuleDependencies()
    addNavigationDependencies()
}