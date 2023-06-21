package com.fitness.model.remote.exercise

import android.os.Parcelable
import com.squareup.moshi.JsonClass
import kotlinx.parcelize.Parcelize

@Parcelize
class AllExercisesResponse : ArrayList<ExerciseDto>(), Parcelable