package com.fitness.model.remote.nutrition.recipe.data

import android.os.Parcelable
import com.squareup.moshi.JsonClass
import kotlinx.parcelize.Parcelize

@Parcelize
class SubDto : ArrayList<SubItemDto>(), Parcelable