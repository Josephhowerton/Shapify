plugins {
    id ("commons.android-feature")
}

android {
    namespace = "com.fitness.home"
}

dependencies {
    HOME_API
    FRAMEWORK

    addDagger2Dependencies()
}