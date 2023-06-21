package com.fitness.model.remote.nutrition.recipe

import com.fitness.model.remote.nutrition.recipe.data.PaginationDto
import com.fitness.model.remote.nutrition.recipe.data.RecipeDto
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class RecipeResponse(
    @Json(name = "_links") val pagination: PaginationDto,
    @Json(name = "recipe") val recipe: RecipeDto
)