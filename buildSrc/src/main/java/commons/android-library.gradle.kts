package commons

import NAVIGATION
import addCommonDependencies
import config.Configs
import gradle.kotlin.dsl.accessors._c743f248286b75ac50c5d2c5b2791871.android
import gradle.kotlin.dsl.accessors._c743f248286b75ac50c5d2c5b2791871.kotlinOptions
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
}


dependencies {
}