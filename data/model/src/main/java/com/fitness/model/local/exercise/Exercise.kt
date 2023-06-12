package com.fitness.model.local.exercise


data class Exercise(
    val id: String,
    val bodyPart: String,
    val equipment: String,
    val gifUrl: String,
    val name: String,
    val target: String
)