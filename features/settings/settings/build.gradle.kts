plugins {
    id ("commons.android-feature")
}

android {
    namespace = "com.fitness.settings"
}

dependencies {
    SETTINGS_API
    addDagger2Dependencies()
}