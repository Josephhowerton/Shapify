import org.gradle.api.artifacts.Dependency
import org.gradle.api.artifacts.dsl.DependencyHandler
import org.gradle.kotlin.dsl.project

/**
 * Adds a dependency to the `kapt` configuration.
 *
 * @param dependencyNotation name of dependency to add at specific configuration
 *
 * @return the dependency
 */
fun DependencyHandler.kapt(dependencyNotation: Any): Dependency? =
    add("kapt", dependencyNotation)

/**
 * Adds a dependency to the `debugImplementation` configuration.
 *
 * @param dependencyNotation name of dependency to add at specific configuration
 *
 * @return the dependency
 */
fun DependencyHandler.debugImplementation(dependencyNotation: Any): Dependency? =
    add("debugImplementation", dependencyNotation)

/**
 * Adds a dependency to the `implementation` configuration.
 *
 * @param dependencyNotation name of dependency to add at specific configuration
 *
 * @return the dependency
 */
fun DependencyHandler.implementation(dependencyNotation: Any): Dependency? =
    add("implementation", dependencyNotation)

/**
 * Adds a dependency to the `api` configuration.
 *
 * @param dependencyNotation name of dependency to add at specific configuration
 *
 * @return the dependency
 */
fun DependencyHandler.api(dependencyNotation: Any): Dependency? =
    add("api", dependencyNotation)


fun DependencyHandler.addCommonDependencies() {
    implementation(SupportLib.CoreKTX)
    implementation(SupportLib.AndroidxCompat)
    implementation(SupportLib.LifecycleRuntime)
    implementation(SupportLib.Material)
}

fun DependencyHandler.addExerciseDependencies() {
    implementation(ExerciseLib.GoogleHealthConnect)
}

fun DependencyHandler.addComposeDependencies() {
    implementation(ComposeLib.ComposeConstraintLayout)
    implementation(ComposeLib.ComposeAcitivity)
    implementation(platform(ComposeLib.ComposeBom))
    implementation(ComposeLib.ComposeUI)
    implementation(ComposeLib.ComposeUIGraphics)
    implementation(ComposeLib.ComposeUITooling)
    implementation(ComposeLib.ComposeMaterial3)
    debugImplementation(ComposeLib.DebugComposeUITooling)
    debugImplementation(ComposeLib.DebugUITooling)
}

fun DependencyHandler.addNavigationDependencies() {
    implementation(NavigationLib.NavigationCompose)
    implementation(NavigationLib.AccompanistAnimation)
}

fun DependencyHandler.addGoogleDependencies() {
    implementation(GoogleLib.GoogleMapsCompose)
    implementation(GoogleLib.GooglePlayServicesMaps)
}

fun DependencyHandler.addFirebaseDependencies() {
    implementation(platform(FirebaseLib.FirebaseBom))
    implementation(FirebaseLib.FirebaseAnalytics)
    implementation(FirebaseLib.FirebaseCrashlytics)
    api(FirebaseLib.FirebaseAuth)
    implementation(FirebaseLib.FirebaseStore)
    implementation(FirebaseLib.FirebaseGoogleAuth)
}

fun DependencyHandler.addCoroutinesDependencies() {
    implementation(CoroutineLib.Coroutines)
    implementation(CoroutineLib.CoroutinesViewModel)
}

fun DependencyHandler.addHiltDependencies(){
    implementation(HiltLib.HiltAndroid)
    implementation(HiltLib.HiltViewModel)
    kapt(HiltLib.HiltCompiler)
}

fun DependencyHandler.addDagger2Dependencies(){
    implementation(Dagger2Lib.Dagger2)
    kapt(Dagger2Lib.Dagger2Compiler)
}

fun DependencyHandler.addUnitTestDependencies() {
    implementation(UnitTest.JUnit)
}

fun DependencyHandler.addAndroidTestDependencies() {
    implementation(AndroidTest.ExtJUnit)
    implementation(AndroidTest.Espresso)
    implementation(AndroidTest.ComposeBom)
    implementation(AndroidTest.UITestJUnit)
}

val DependencyHandler.CRASHLYTICS get() = implementation(FirebaseLib.FirebaseCrashlytics)

val DependencyHandler.COMPONENTS get() = implementation(project(":common:components"))
val DependencyHandler.THEME get() = implementation(project(":common:theme"))
val DependencyHandler.UTILITY get() = implementation(project(":common:utility"))

val DependencyHandler.NAVIGATION get() = implementation(project(":core:navigation"))
val DependencyHandler.PROVIDER get() = implementation(project(":core:provider"))

val DependencyHandler.CACHE get() = implementation(project(":data:cache"))
val DependencyHandler.MODEL get() = implementation(project(":data:model"))
val DependencyHandler.REPOSITORY get() = implementation(project(":data:repository"))
val DependencyHandler.REMOTE get() = implementation(project(":data:remote"))

val DependencyHandler.DOMAIN get() = implementation(project(":domain"))

val DependencyHandler.ACCOUNT get() = implementation(project(":features:account:account"))
val DependencyHandler.ANALYSIS get() = implementation(project(":features:analysis:analysis"))
val DependencyHandler.AUTH get() = implementation(project(":features:authentication:auth"))
val DependencyHandler.HOME get() = implementation(project(":features:home:home"))
val DependencyHandler.PLANNER get() = implementation(project(":features:planner:planner"))
val DependencyHandler.PROFILE get() = implementation(project(":features:profile:profile"))
val DependencyHandler.SETTINGS get() = implementation(project(":features:settings:settings"))
val DependencyHandler.TRACKING get() = implementation(project(":features:tracking:tracking"))
val DependencyHandler.TRAINING get() = implementation(project(":features:training:training"))
val DependencyHandler.ONBOARDING get() = api(project(":features:onboarding:onboarding"))
val DependencyHandler.WELCOME get() = api(project(":features:welcome:welcome"))

val DependencyHandler.ACCOUNT_API get() = api(project(":features:account:account-api"))
val DependencyHandler.ANALYSIS_API get() = api(project(":features:analysis:analysis-api"))
val DependencyHandler.AUTH_API get() = api(project(":features:authentication:auth-api"))
val DependencyHandler.HOME_API get() = api(project(":features:home:home-api"))
val DependencyHandler.PLANNER_API get() = api(project(":features:planner:planner-api"))
val DependencyHandler.PROFILE_API get() = api(project(":features:profile:profile-api"))
val DependencyHandler.SETTINGS_API get() = api(project(":features:settings:settings-api"))
val DependencyHandler.TRACKING_API get() = api(project(":features:tracking:tracking-api"))
val DependencyHandler.TRAINING_API get() = api(project(":features:training:training-api"))
val DependencyHandler.ONBOARDING_API get() = api(project(":features:onboarding:onboarding-api"))
val DependencyHandler.WELCOME_API get() = api(project(":features:welcome:welcome-api"))

val DependencyHandler.FRAMEWORK get() = api(project(":libraries:framework"))

fun DependencyHandler.addCommonModuleDependencies() {
    COMPONENTS
    THEME
    UTILITY
}

fun DependencyHandler.addCoreModuleDependencies(){
    NAVIGATION
    PROVIDER
}

fun DependencyHandler.addDataModuleDependencies() {
    CACHE
    MODEL
    REPOSITORY
    REMOTE
}

fun DependencyHandler.addFeatureModuleDependencies() {
    ACCOUNT
    ANALYSIS
    AUTH
    HOME
    PLANNER
    PROFILE
    SETTINGS
    TRACKING
    TRAINING
    ONBOARDING
    WELCOME
}

fun DependencyHandler.addFeatureApiDependencies() {
    ACCOUNT_API
    ANALYSIS_API
    AUTH_API
    HOME_API
    PLANNER_API
    PROFILE_API
    SETTINGS_API
    TRACKING_API
    TRAINING_API
    ONBOARDING_API
    WELCOME_API
}
