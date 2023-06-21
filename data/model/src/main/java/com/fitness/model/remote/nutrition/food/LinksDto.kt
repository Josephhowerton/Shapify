package com.fitness.model.remote.nutrition.food

import android.os.Parcelable
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass
import kotlinx.parcelize.Parcelize

@Parcelize
@JsonClass(generateAdapter = true)
data class LinksDto(
    @Json(name = "next") val next: NextDto
) : Parcelable