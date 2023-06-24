package com.fitness.model.util.extensions

import com.fitness.model.cache.exercise.shared.ExerciseEntity
import com.fitness.model.domain.exercise.ExerciseItem
import com.fitness.model.domain.exercise.Exercise
import com.fitness.model.remote.exercise.ExerciseDto


//Network to Cache
fun ExerciseDto.toExerciseItem() =
    ExerciseItem(
        bodyPart = bodyPart,
        equipment = equipment,
        gifUrl = gifUrl,
        id = id,
        name = name,
        target = target
    )


//Cache to Network
fun ExerciseItem.toExerciseDto() =
    ExerciseDto(
        bodyPart = bodyPart,
        equipment = equipment,
        gifUrl = gifUrl,
        id = id,
        name = name,
        target = target
    )

//UnpickedItem to Picked Item
fun ExerciseItem.toExerciseEntity(sessionId: String) =
    ExerciseEntity(
        bodyPart = bodyPart,
        equipment = equipment,
        gifUrl = gifUrl,
        id = id,
        name = name,
        sessionId = sessionId,
        target = target,
    )

//Picked Item to UnpickedItem
fun ExerciseEntity.toExerciseEntity() =
    ExerciseItem(
        bodyPart = bodyPart,
        equipment = equipment,
        gifUrl = gifUrl,
        id = id,
        name = name,
        target = target
    )


//Cache to Domain
fun ExerciseEntity.toUserExercise() =
    Exercise(
        bodyPart = bodyPart,
        equipment = equipment,
        gifUrl = gifUrl,
        id = id,
        name = name,
        sessionId = sessionId,
        target = target
    )


//Domain to Cache
fun Exercise.toExerciseEntity() =
    ExerciseEntity(
        bodyPart = bodyPart,
        equipment = equipment,
        gifUrl = gifUrl,
        id = id,
        sessionId = sessionId,
        name = name,
        target = target
    )