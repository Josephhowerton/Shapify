package com.fitness.framework.extensions

object StaticExtensions {
    fun emptyString(): String = ""
}
fun String.capitalizeFirstLetter() = replaceFirstChar {
        it.uppercase()
    }