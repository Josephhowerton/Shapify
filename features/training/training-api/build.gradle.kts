plugins {
    kotlin("kapt")
    id ("com.android.library")
    id ("org.jetbrains.kotlin.android")
//    id("com.google.dagger.hilt.android")
}

android {
    namespace = "com.fitness.training"
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
    addCoreModuleDependencies()
//    addHiltDependencies()
}