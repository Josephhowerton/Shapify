plugins {
    kotlin("kapt")
    id ("com.android.library")
    id ("org.jetbrains.kotlin.android")
    id("com.google.dagger.hilt.android")
    id ("commons.android-library")
}

android{
    namespace = "com.fitness.remote"
}

dependencies {
    FRAMEWORK
    MODEL

    addHiltDependencies()
    addNetworkDependencies()
}