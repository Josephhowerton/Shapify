package com.fitness.model.cache.nutrition.food

/**
 * * @param id Measure Entity identifier
 * @param fId Food Entity identifier that this Measure Entity belongs to
 */
data class MeasureEntity(
    val id: String,
    val fId: String,
    val unit: String,
    val unitUri: String,
    val weight: Double,
    val qualified: List<QualifiedEntity>
)