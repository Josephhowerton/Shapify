plugins {
    id ("commons.android-feature")
}

android {
    namespace = "com.fitness.welcome"
}

dependencies {
    WELCOME_API
    AUTH_API
    addDagger2Dependencies()
}