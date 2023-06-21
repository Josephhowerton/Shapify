package com.fitness.model.util.extensions

import com.fitness.model.cache.health.CaloriesBurnedEntity
import com.fitness.model.domain.health.CaloriesBurned


fun CaloriesBurnedEntity.toCaloriesBurned() =
    CaloriesBurned(
        caloriesPlanned = caloriesPlanned,
        caloriesActual = caloriesActual
    )

fun CaloriesBurned.toCaloriesBurnedEntity() =
    CaloriesBurnedEntity(
        caloriesPlanned = caloriesPlanned,
        caloriesActual = caloriesActual
    )