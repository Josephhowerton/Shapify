package com.fitness.model.remote.exercise

import android.os.Parcelable
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass
import kotlinx.parcelize.Parcelize

@Parcelize
@JsonClass(generateAdapter = true)
data class ExerciseDto(
    @Json(name = "bodyPart") val bodyPart: String,
    @Json(name = "equipment") val equipment: String,
    @Json(name = "gifUrl") val gifUrl: String,
    @Json(name = "id") val id: String,
    @Json(name = "name") val name: String,
    @Json(name = "target") val target: String
) : Parcelable