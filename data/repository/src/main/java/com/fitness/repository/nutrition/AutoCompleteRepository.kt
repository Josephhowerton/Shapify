package com.fitness.repository.nutrition

import com.fitness.model.remote.nutrition.autocomplete.AutoCompleteResponse
import service.AutoCompleteService
import javax.inject.Inject

class AutoCompleteRepository @Inject constructor(
    private val recipeService: AutoCompleteService
) {

    suspend fun autoComplete(q: String, limit: Int): AutoCompleteResponse =
        recipeService.autoComplete(q, limit)
}