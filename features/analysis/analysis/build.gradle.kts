plugins {
    id ("commons.android-feature")
}

android {
    namespace = "com.fitness.analysis"
}

dependencies {
    ANALYSIS_API

    addDagger2Dependencies()
}