package com.fitness.model.remote.nutrition

data class EdamanFoodResponse(
    val _links: Links,
    val hints: List<Hint>,
    val parsed: List<Any>,
    val text: String
)