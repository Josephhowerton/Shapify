plugins {
    id ("commons.android-feature")
}

android {
    namespace = "com.fitness.account"
}

dependencies {
    ACCOUNT_API

    addDagger2Dependencies()
}