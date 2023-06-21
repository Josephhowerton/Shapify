package com.fitness.model.domain.nutrition.food

data class Qualified(
    val qualifiers: List<Qualifier>,
    val weight: Double
)