package com.fitness.model.domain.nutrition.food

/**
 * @param id Serving Size Entity identifier
 * @param fId Food Entity identifier that this Serving Size Entity belongs to
 */
data class ServingSize(
    val unit: String,
    val quantity: Double,
    val unitUri: String
)