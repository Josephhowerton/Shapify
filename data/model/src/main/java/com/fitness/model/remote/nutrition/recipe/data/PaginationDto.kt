package com.fitness.model.remote.nutrition.recipe.data

import android.os.Parcelable
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass
import kotlinx.parcelize.Parcelize

@Parcelize
@JsonClass(generateAdapter = true)
data class PaginationDto(
    @Json(name = "next") val next: NextDto,
    @Json(name = "self") val self: SelfDto
) : Parcelable