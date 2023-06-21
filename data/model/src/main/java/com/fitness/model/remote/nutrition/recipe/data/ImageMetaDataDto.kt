package com.fitness.model.remote.nutrition.recipe.data

import android.os.Parcelable
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass
import kotlinx.parcelize.Parcelize

@Parcelize
@JsonClass(generateAdapter = true)
data class ImageMetaDataDto(
    @Json(name = "height") val height: Int,
    @Json(name = "url") val url: String,
    @Json(name = "width") val width: Int
) : Parcelable