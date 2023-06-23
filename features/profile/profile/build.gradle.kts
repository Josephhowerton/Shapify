plugins {
    id ("commons.android-feature")
}
android {
    namespace = "com.fitness.profile"
}

dependencies {
    PROFILE_API
    addDagger2Dependencies()
}