package com.fitness.model.cache.exercise.shared

data class SetsRepsEntity(
    val setsRepsPlanned: Map<Int, Int>,
    val setsRepsActual: Map<Int, Int>
)