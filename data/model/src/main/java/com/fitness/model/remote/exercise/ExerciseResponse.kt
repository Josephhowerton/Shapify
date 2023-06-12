package com.fitness.model.remote.exercise

data class ExerciseResponse(
    val bodyPart: String,
    val equipment: String,
    val gifUrl: String,
    val id: String,
    val name: String,
    val target: String
)