package com.fitness.model.remote.nutrition.recipe.data

import android.os.Parcelable
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass
import kotlinx.parcelize.Parcelize

@Parcelize
@JsonClass(generateAdapter = true)
data class ImagesDto(
    @Json(name = "LARGE") val Large: ImageMetaDataDto,
    @Json(name = "REGULAR") val Regular: ImageMetaDataDto,
    @Json(name = "SMALL") val Small: ImageMetaDataDto,
    @Json(name = "THUMBNAIL") val Thumbnail: ImageMetaDataDto
) : Parcelable