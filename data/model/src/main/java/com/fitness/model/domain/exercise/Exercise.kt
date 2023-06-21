package com.fitness.model.domain.exercise

import com.fitness.model.domain.health.CaloriesBurned


data class Exercise(
    val bodyPart: String,
    val equipment: String,
    val gifUrl: String,
    val id: String,
    val sessionId: String?,
    val name: String,
    val target: String,
    val setsReps: SetsReps,
    val caloriesBurned: CaloriesBurned
)