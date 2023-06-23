plugins {
    id ("commons.android-feature")
}

android {
    namespace = "com.fitness.planner"
}

dependencies {
    PLANNER_API
    addDagger2Dependencies()
}