plugins {
    id ("com.android.library")
    id ("org.jetbrains.kotlin.android")
    id ("kotlin-parcelize")
    id ("commons.android-library")
    kotlin("kapt")
}

android{
    namespace = "com.fitness.model"
}


dependencies{
    FRAMEWORK
    addExerciseDependencies()
    addFirebaseDependencies()
    addNetworkDependencies()
}