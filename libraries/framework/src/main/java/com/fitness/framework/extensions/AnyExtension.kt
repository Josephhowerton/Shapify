package com.fitness.framework.extensions

inline fun <reified T : Any> Any.cast(): T {
    return this as T
}