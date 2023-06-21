package com.fitness.model.domain.health

data class CaloriesBurned(
    val caloriesPlanned: Map<Int, Int>,
    val caloriesActual: Map<Int, Int>
)