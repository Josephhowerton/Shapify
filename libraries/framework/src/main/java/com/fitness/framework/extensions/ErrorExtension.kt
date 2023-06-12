package com.fitness.framework.extensions

abstract class Failure: Throwable() {
    abstract val description: Int
    abstract val title: Int
}