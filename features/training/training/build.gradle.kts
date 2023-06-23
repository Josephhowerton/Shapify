plugins {
    id ("commons.android-feature")
}

android {
    namespace = "com.fitness.training"
}

dependencies {
    TRAINING_API
    addDagger2Dependencies()
    addGoogleDependencies()
}