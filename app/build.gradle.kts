import config.Configs

plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.android")
    id("com.google.gms.google-services")
    id("com.google.dagger.hilt.android")
    id("com.google.firebase.crashlytics")
    kotlin("kapt")
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

            buildConfigField("String", "EXERCISE_BASE_URL", "\"${config.Configs.Exercise.BASE_URL}\"")
            buildConfigField("String", "NUTRITION_BASE_URL", "\"${config.Configs.Nutrition.BASE_URL}\"")
        }
        debug {
            buildConfigField("String", "EXERCISE_BASE_URL", "\"${config.Configs.Exercise.BASE_URL}\"")
            buildConfigField("String", "NUTRITION_BASE_URL", "\"${config.Configs.Nutrition.BASE_URL}\"")
        }
    }


    flavorDimensions.add(Configs.FlavorDimension)
    productFlavors {
        create(Configs.ShapifyFlavor) {
            dimension = Configs.FlavorDimension
        }
        create(Configs.HealthFlavor) {
            dimension = Configs.FlavorDimension
            targetSdk = Configs.HealthConnectTargetSdk
            compileSdk = Configs.HealthConnectCompileSdk
            minSdk = Configs.HealthConnectMinSdk
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

    hilt {
        enableAggregatingTask = true
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
    FRAMEWORK

    addCommonDependencies()
    addComposeDependencies()
    addNavigationDependencies()


    addHiltDependencies()
    addExerciseDependencies()
    addFeatureApiDependencies()

    addCoreModuleDependencies()
    addFeatureModuleDependencies()

}
