package com.fitness.shapify.config

import com.fitness.framework.network.util.NetworkConfig
import com.fitness.shapify.BuildConfig

class ShapifyNetworkConfig : NetworkConfig {

    override fun nutritionBaseUrl(): String = BuildConfig.NUTRITION_BASE_URL

    override fun exerciseBaseUrl(): String = BuildConfig.EXERCISE_BASE_URL

    override fun isDev(): Boolean = BuildConfig.DEBUG

}