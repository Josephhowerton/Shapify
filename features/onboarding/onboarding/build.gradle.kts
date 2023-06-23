plugins {
    id ("commons.android-feature")
}

android {
    namespace = "com.fitness.onboarding"
}

dependencies {
    ONBOARDING_API
    FRAMEWORK

    addDagger2Dependencies()
}