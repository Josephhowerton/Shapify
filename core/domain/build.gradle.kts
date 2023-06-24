plugins {
    id ("com.android.library")
    id ("org.jetbrains.kotlin.android")
    id ("commons.android-library")
    kotlin("kapt")
}

android {
    namespace = "com.fitness.domain"
}

dependencies {
    FRAMEWORK
    REPOSITORY
    MODEL
    addDagger2Dependencies()
    addFirebaseDependencies()
    addCoroutinesDependencies()
}