plugins {
    id ("com.android.library")
    id ("org.jetbrains.kotlin.android")
    id ("commons.android-library")
}

android{
    namespace = "com.fitness.components"

    buildFeatures {
        compose = true
    }
    composeOptions {
        kotlinCompilerExtensionVersion = config.Configs.KotlinCompilerExtensionVersion
    }
}

dependencies {
    MODEL
    REPOSITORY
    THEME
    UTILITY

    addCommonDependencies()
    addComposeDependencies()

}