package com.fitness.repository.nutrition

import com.fitness.model.remote.nutrition.nutrients.NutrientsResponse
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase
import service.FoodDatabaseService
import service.NutritionService
import javax.inject.Inject

class NutritionRepository @Inject constructor(
    private val recipeService: NutritionService
) {
    private val db = Firebase.firestore

    suspend fun getFoodNutrients(): NutrientsResponse = recipeService.getFoodNutrients()

}