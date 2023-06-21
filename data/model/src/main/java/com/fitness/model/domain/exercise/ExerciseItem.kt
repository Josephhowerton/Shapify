package com.fitness.model.domain.exercise

data class ExerciseItem(
    val bodyPart: String,
    val equipment: String,
    val gifUrl: String,
    val id: String,
    val name: String,
    val target: String
)