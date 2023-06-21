package com.fitness.model.remote.nutrition.recipe

import com.fitness.model.remote.nutrition.recipe.data.HitDto
import com.fitness.model.remote.nutrition.recipe.data.PaginationDto
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class UriRecipeResponse(
    @Json(name = "_links") val pagination: PaginationDto,
    @Json(name = "count") val count: Int,
    @Json(name = "from") val from: Int,
    @Json(name = "hits") val hits: List<HitDto>,
    @Json(name = "to") val to: Int
)