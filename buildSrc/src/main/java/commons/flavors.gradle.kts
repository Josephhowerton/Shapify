import config.Configs
import gradle.kotlin.dsl.accessors._c743f248286b75ac50c5d2c5b2791871.android
import org.gradle.kotlin.dsl.kotlin

plugins {
    id("kotlin-android")
    id("com.android.library")
}

android {

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
            compileSdk = Configs.HealthConnectCompileSdk
            minSdk = Configs.HealthConnectMinSdk
        }
    }

    buildFeatures {
        buildConfig = true
    }
}