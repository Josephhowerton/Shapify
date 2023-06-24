package config

import org.gradle.api.JavaVersion

object Configs {
    private const val versionMajor = 1
    private const val versionMinor = 0
    private const val versionPatch = 0
    private const val versionQualifier = "alpha1"

    private fun generateVersionCode(): Int {
        return versionMajor * 10000 + versionMinor * 100 + versionPatch
    }

    private fun generateVersionName(): String {
        return "$versionMajor.$versionMinor.$versionPatch"
    }

    const val Id = "com.fitness.shapify"
    val VersionCode = generateVersionCode()
    val VersionName = generateVersionName()

    const val CompileSdk = 33
    const val TargetSdk = CompileSdk
    const val MinSdk = 26

    const val FlavorDimension = "shapify"
    const val ShapifyFlavor = "shapify"

    const val HealthFlavorDimension = "shapifyHealth"
    const val HealthFlavor = "shapifyHealth"
    const val HealthConnectCompileSdk = 34
    const val HealthConnectTargetSdk = 34
    const val HealthConnectMinSdk = 34

    const val AndroidJunitRunner = "androidx.test.runner.AndroidJUnitRunner"

    val SourceCompatibility = JavaVersion.VERSION_17
    val TargetCompatibility = JavaVersion.VERSION_17
    const val JvmTarget = "17"
    const val KotlinCompilerExtensionVersion = "1.4.2"


    val FreeCompilerArgs = listOf(
        "-Xjvm-default=all",
        "-Xopt-in=kotlin.RequiresOptIn",
        "-Xopt-in=kotlin.Experimental",
        "-Xopt-in=kotlinx.coroutines.ExperimentalCoroutinesApi",
        "-Xopt-in=kotlinx.coroutines.InternalCoroutinesApi",
        "-Xopt-in=kotlinx.coroutines.FlowPreview",
        "-Xopt-in=androidx.compose.material.ExperimentalMaterialApi",
        "-Xopt-in=com.google.accompanist.navigation.material.ExperimentalMaterialNavigationApi",
        "-Xopt-in=androidx.compose.animation.ExperimentalAnimationApi"
    )

    val FreeCoroutineCompilerArgs = listOf(
        "-Xjvm-default=all",
        "-Xopt-in=kotlin.RequiresOptIn",
        "-Xopt-in=kotlin.Experimental",
        "-Xopt-in=kotlinx.coroutines.ExperimentalCoroutinesApi",
        "-Xopt-in=kotlinx.coroutines.InternalCoroutinesApi",
        "-Xopt-in=kotlinx.coroutines.FlowPreview"
    )


    object Exercise {
        const val BASE_URL = "https://zylalabs.com/api/392/exercise+database+api/"
    }

    object Nutrition {
        const val BASE_URL = "https://api.edamam.com/api/food-database/v2/"
    }
}