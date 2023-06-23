package com.fitness.model.util.extensions

import com.fitness.model.cache.exercise.shared.SetsRepsEntity
import com.fitness.model.domain.exercise.SetsReps

fun SetsRepsEntity.toSetReps() =
    SetsReps(
        setsRepsPlanned = setsRepsPlanned,
        setsRepsActual = setsRepsActual
    )

fun SetsReps.toSetRepsEntity() =
    SetsRepsEntity(
        setsRepsPlanned = setsRepsPlanned,
        setsRepsActual = setsRepsActual
    )