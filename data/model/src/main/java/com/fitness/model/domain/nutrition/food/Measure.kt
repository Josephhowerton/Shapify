package com.fitness.model.domain.nutrition.food

import com.fitness.model.remote.nutrition.food.QualifiedDto


/**
 * @param id Measure Entity identifier
 * @param fId Food Entity identifier that this Measure Entity belongs to
 */
data class Measure(
    val id: String,
    val fId: String,
    val unit: String,
    val unitUri: String,
    val weight: Double,
    val qualified: List<Qualified>,
)