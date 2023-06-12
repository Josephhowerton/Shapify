package com.fitness.model.local.exercise

import androidx.annotation.IntRange
import java.time.Instant
import java.time.ZoneOffset

data class Steps(
    val startTime: Instant,
    val startZoneOffset: ZoneOffset?,
    val endTime: Instant,
    val endZoneOffset: ZoneOffset?,

    @IntRange(from = 1, to = 1000_000)
    val count: Long,
    val caloriesBurned: Double
)