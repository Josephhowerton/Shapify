package com.fitness.model.domain.nutrition

import com.fitness.model.util.enumerations.CategoryType
import com.fitness.model.util.enumerations.HealthType

data class DietRestrictions(
    val id: String,
    val uid: String,
    val restrictions: List<HealthType>,
    val categories: List<CategoryType>
)