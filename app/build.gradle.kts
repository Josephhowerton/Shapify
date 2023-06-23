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
    compileSdk = config.Configs.CompileSdk

    defaultConfig {
        applicationId = "com.fitness.shapify"
        minSdk = config.Configs.MinSdk
        targetSdk = config.Configs.TargetSdk
        versionCode = config.Configs.VersionCode
        versionName = config.Configs.VersionName

        testInstrumentationRunner = config.Configs.AndroidJunitRunner
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

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }

    kotlinOptions {
        jvmTarget = config.Configs.JvmTarget
    }

    buildFeatures {
        compose = true
        buildConfig = true
    }

    composeOptions {
        kotlinCompilerExtensionVersion = config.Configs.KotlinCompilerExtensionVersion
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
