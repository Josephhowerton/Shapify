package com.fitness.model.cache.nutrition

import com.fitness.model.util.enumerations.CategoryType
import com.fitness.model.util.enumerations.HealthType

data class DietRestrictionsEntity(
    val id: String,
    val uid: String,
    val restrictions: List<HealthType>,
    val categories: List<CategoryType>
)