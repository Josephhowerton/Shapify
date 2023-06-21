package com.fitness.model.remote.nutrition.recipe.data

import android.os.Parcelable
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass
import kotlinx.parcelize.Parcelize

@Parcelize
@JsonClass(generateAdapter = true)
data class HitDto(
    @Json(name = "_links") val pagination: PaginationDto,
    @Json(name = "recipe") val recipe: RecipeDto
) : Parcelable