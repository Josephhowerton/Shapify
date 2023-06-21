plugins {
    kotlin("kapt")
    id("com.android.application")
    id("org.jetbrains.kotlin.android")
    id("com.google.gms.google-services")
    id("com.google.dagger.hilt.android")
    id("com.google.firebase.crashlytics")
}

android {
    namespace = "com.fitness.shapify"
    compileSdk = Configs.CompileSdk

    defaultConfig {
        applicationId = "com.fitness.shapify"
        minSdk = Configs.MinSdk
        targetSdk = Configs.TargetSdk
        versionCode = Configs.VersionCode
        versionName = Configs.VersionName

        testInstrumentationRunner = Configs.AndroidJunitRunner
        vectorDrawables {
            useSupportLibrary = true
        }
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro")

            buildConfigField("String", "EXERCISE_BASE_URL", "\"${Configs.Exercise.BASE_URL}\"")
            buildConfigField("String", "NUTRITION_BASE_URL", "\"${Configs.Nutrition.BASE_URL}\"")
        }
        debug {
            buildConfigField("String", "EXERCISE_BASE_URL", "\"${Configs.Exercise.BASE_URL}\"")
            buildConfigField("String", "NUTRITION_BASE_URL", "\"${Configs.Nutrition.BASE_URL}\"")
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }
    kotlinOptions {
        jvmTarget = Configs.JvmTarget
    }

    buildFeatures {
        compose = true
        buildConfig = true
    }

    composeOptions {
        kotlinCompilerExtensionVersion = Configs.KotlinCompilerExtensionVersion
    }

    packaging {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
        }
    }
}



android.applicationVariants.all {
    val variantName = name
    kotlin.sourceSets {
        getByName("main") {
            kotlin.srcDir(File("build/generated/ksp/$variantName/kotlin"))
        }
    }
}

dependencies {
    MODEL
    REPOSITORY

    addCommonDependencies()
    addComposeDependencies()
    addNavigationDependencies()


    addHiltDependencies()
    addExerciseDependencies()
    addFeatureApiDependencies()

    addCoreModuleDependencies()
    addFeatureModuleDependencies()

}
