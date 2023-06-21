package com.fitness.model.cache.exercise

data class SetsRepsEntity(
    val setsRepsPlanned: Map<Int, Int>,
    val setsRepsActual: Map<Int, Int>
)