package com.fitness.model.cache.exercise

import com.fitness.model.cache.health.CaloriesBurnedEntity

data class ExerciseEntity(
    val bodyPart: String,
    val equipment: String,
    val gifUrl: String,
    val id: String,
    val sessionId: String?,
    val name: String,
    val target: String,
    val setsRepsEntity: SetsRepsEntity,
    val caloriesBurnedEntity: CaloriesBurnedEntity
)





