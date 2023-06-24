plugins {
    id ("com.android.library")
    id ("org.jetbrains.kotlin.android")
    id ("commons.android-library")
}

android{
    namespace = "com.fitness.cache"
}


dependencies{
    MODEL
    addFirebaseDependencies()
}