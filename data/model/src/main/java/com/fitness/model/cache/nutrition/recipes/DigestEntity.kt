package com.fitness.model.cache.nutrition.recipes

data class DigestEntity(
    val daily: Int,
    val hasRDI: Boolean,
    val label: String,
    val schemaOrgTag: String,
    val sub: SubEntity,
    val tag: String,
    val total: Int,
    val unit: String
)