plugins {
    id ("commons.android-feature")
}

android {
    namespace = "com.fitness.auth"
}

dependencies {
    AUTH_API
    ONBOARDING_API
    FRAMEWORK

    addFirebaseDependencies()
    addDagger2Dependencies()
}