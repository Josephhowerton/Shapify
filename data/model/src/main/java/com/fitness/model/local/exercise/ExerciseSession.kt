package com.fitness.model.local.exercise

import androidx.health.connect.client.records.ExerciseSessionRecord

data class ExerciseSession(
    private val id: String,
    private val userId: String,
    private val exerciseSession: ExerciseSessionRecord,
    private val workouts: List<Exercise>
)