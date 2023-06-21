package com.fitness.framework.network.util


interface NetworkConfig {
    fun nutritionBaseUrl(): String
    fun exerciseBaseUrl(): String
    fun isDev(): Boolean
}