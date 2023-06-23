plugins {
    id ("com.android.library")
    id ("org.jetbrains.kotlin.android")
}

android{
    namespace = "com.fitness.theme"
    compileSdk = config.Configs.CompileSdk

    defaultConfig {
        minSdk = config.Configs.MinSdk
        testInstrumentationRunner = config.Configs.AndroidJunitRunner
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
        jvmTarget = config.Configs.JvmTarget
    }

    buildFeatures {
        compose = true
    }
    composeOptions {
        kotlinCompilerExtensionVersion = config.Configs.KotlinCompilerExtensionVersion
    }
}

dependencies {
    addCommonDependencies()
    addComposeDependencies()
}