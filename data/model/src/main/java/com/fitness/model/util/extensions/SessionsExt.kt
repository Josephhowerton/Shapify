package com.fitness.model.util.extensions

import com.fitness.model.cache.exercise.ExerciseSessionEntity
import com.fitness.model.domain.sessions.ExerciseSession

fun ExerciseSessionEntity.toWorkoutSession() =
    ExerciseSession(
        id = id,
        uid = uid
    )

fun ExerciseSession.toWorkoutSessionEntity() =
    ExerciseSessionEntity(
        id = id,
        uid = uid
    )