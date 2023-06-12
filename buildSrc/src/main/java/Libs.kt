object Versions{
    const val CoreKTX = "1.8.0"
    const val LifecycleRuntime = "2.3.1"
    const val androidxCompat = "1.6.1"
    const val Material = "1.9.0"
    const val ActivityCompose = "1.5.1"
    const val ComposeBom = "2022.10.00"
    const val JUnit = "4.13.2"
    const val JUnitExt = "1.1.5"
    const val EspressoCore = "3.5.1"

    const val NavigationCompose = "2.5.3"
    const val AccompanistAnimation = "0.31.3-beta"
    const val ConstraintLayoutCompose = "1.0.1"
    const val GoogleMapsCompose = "2.11.4"
    const val GooglePlayServicesMaps = "18.1.0"

    const val FirebaseBom = "32.1.0"
    const val GoogleFirebaseAuth = "20.5.0"
    const val Coroutines = "1.3.9"
    const val CoroutinesViewModel = "2.4.0"

    const val Hilt = "2.44"
    const val HiltViewModel = "1.0.0"
    const val Dagger2 = "2.44"
    const val GoogleHealthConnect = "1.0.0-alpha11"
}

object SupportLib {
    const val CoreKTX = "androidx.core:core-ktx:${Versions.CoreKTX}"
    const val LifecycleRuntime = "androidx.lifecycle:lifecycle-runtime-ktx:${Versions.LifecycleRuntime}"
    const val AndroidxCompat = "androidx.appcompat:appcompat:${Versions.androidxCompat}"
    const val Material = "com.google.android.material:material:${Versions.Material}"
}

object ExerciseLib{
    const val GoogleHealthConnect = "androidx.health.connect:connect-client:${Versions.GoogleHealthConnect}"
}

object CoroutineLib{
    const val Coroutines = "org.jetbrains.kotlinx:kotlinx-coroutines-android:${Versions.Coroutines}"
    const val CoroutinesViewModel = "androidx.lifecycle:lifecycle-viewmodel-ktx:${Versions.CoroutinesViewModel}"
}

object HiltLib{
    const val HiltAndroid = "com.google.dagger:hilt-android:${Versions.Hilt}"
    const val HiltViewModel = "androidx.hilt:hilt-navigation-fragment:${Versions.HiltViewModel}"
    const val HiltCompiler = "com.google.dagger:hilt-android-compiler:${Versions.Hilt}"
}

object Dagger2Lib{
    const val Dagger2 = "com.google.dagger:dagger:${Versions.Dagger2}"
    const val Dagger2Compiler = "com.google.dagger:dagger-compiler:${Versions.Dagger2}"
}

object ComposeLib {
    const val ComposeConstraintLayout = "androidx.constraintlayout:constraintlayout-compose:${Versions.ConstraintLayoutCompose}"
    const val ComposeAcitivity = "androidx.activity:activity-compose:${Versions.ActivityCompose}"
    const val ComposeBom = "androidx.compose:compose-bom:${Versions.ComposeBom}"
    const val ComposeUI = "androidx.compose.ui:ui"
    const val ComposeUIGraphics = "androidx.compose.ui:ui-graphics"
    const val ComposeUITooling = "androidx.compose.ui:ui-tooling-preview"
    const val ComposeMaterial3 = "androidx.compose.material3:material3"
    const val DebugComposeUITooling = "androidx.compose.ui:ui-tooling"
    const val DebugUITooling = "androidx.compose.ui:ui-test-manifest"
}

object NavigationLib {
    const val NavigationCompose = "androidx.navigation:navigation-compose:${Versions.NavigationCompose}"
    const val AccompanistAnimation = "com.google.accompanist:accompanist-navigation-animation:${Versions.AccompanistAnimation}"
}

object GoogleLib {
    const val GoogleMapsCompose = "com.google.maps.android:maps-compose:${Versions.GoogleMapsCompose}"
    const val GooglePlayServicesMaps = "com.google.android.gms:play-services-maps:${Versions.GooglePlayServicesMaps}"
}

object FirebaseLib {
    const val FirebaseBom = "com.google.firebase:firebase-bom:${Versions.FirebaseBom}"
    const val FirebaseCrashlytics = "com.google.firebase:firebase-crashlytics-ktx"
    const val FirebaseAnalytics = "com.google.firebase:firebase-analytics-ktx"
    const val FirebaseAuth = "com.google.firebase:firebase-auth-ktx"
    const val FirebaseStore = "com.google.firebase:firebase-firestore-ktx"
    const val FirebaseGoogleAuth = "com.google.android.gms:play-services-auth:${Versions.GoogleFirebaseAuth}"
}

object UnitTest {
    const val JUnit = "junit:junit:${Versions.JUnit}"

}

object AndroidTest {
    const val ExtJUnit = "androidx.test.ext:junit:${Versions.JUnitExt}"
    const val Espresso = "androidx.test.espresso:espresso-core:${Versions.EspressoCore}"
    const val ComposeBom = "androidx.compose:compose-bom:${Versions.ComposeBom}"
    const val UITestJUnit = "androidx.compose.ui:ui-test-junit4"
}



