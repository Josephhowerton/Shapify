plugins {
    id ("commons.android-feature")
}

android {
    namespace = "com.fitness.tracking"
}

dependencies {
    TRACKING_API
    addDagger2Dependencies()
}