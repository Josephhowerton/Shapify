package com.fitness.model.remote.nutrition

import com.fitness.model.enums.Unit

data class MealItem(val userId: String, val list: List<Food>, val unitMeasurement: Unit)