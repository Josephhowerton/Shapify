package com.fitness.model.cache.health

data class CaloriesBurnedEntity(
    val caloriesPlanned: Map<Int, Int>,
    val caloriesActual: Map<Int, Int>
)