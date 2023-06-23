

buildscript {
    dependencies {
        classpath("com.google.gms:google-services:4.3.15")
        classpath("com.google.firebase:firebase-crashlytics-gradle:2.9.6")
    }
}

plugins {
    id ("com.android.application") apply false
    id ("com.android.library") apply false
    id ("org.jetbrains.kotlin.android") apply false
    id ("com.google.dagger.hilt.android") version "2.44" apply false
}