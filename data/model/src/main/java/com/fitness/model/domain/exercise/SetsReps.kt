package com.fitness.model.domain.exercise

data class SetsReps(
    val setsRepsPlanned: Map<Int, Int>,
    val setsRepsActual: Map<Int, Int>
)