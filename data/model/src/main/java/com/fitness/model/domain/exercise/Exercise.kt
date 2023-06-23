package com.fitness.model.domain.exercise


data class Exercise(
    val bodyPart: String,
    val equipment: String,
    val gifUrl: String,
    val id: String,
    val sessionId: String?,
    val name: String,
    val target: String
)