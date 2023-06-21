package com.fitness.repository.nutrition

import com.fitness.model.remote.nutrition.food.FoodResponse
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase
import service.FoodDatabaseService
import javax.inject.Inject

class FoodRepository @Inject constructor(
    private val foodService: FoodDatabaseService
) {

    private val db = Firebase.firestore

    suspend fun getAllFood(): FoodResponse =
        foodService.getAllFood()

    suspend fun getFoodByIngredient(
        ingredient: String,
        brand: String?,
        nutritionType: String?,
        health: String?,
        calories: String?,
        category: String?,
        nutrients: HashMap<String, String>?
    ): FoodResponse =
        foodService.getFoodByIngredient(
            ingredient,
            brand,
            nutritionType,
            health,
            calories,
            category,
            nutrients
        )

    suspend fun getFoodByBrand(
        brand: String,
        ingredient: String?,
        nutritionType: String?,
        health: String?,
        calories: String?,
        category: String?,
        nutrients: HashMap<String, String>?
    ): FoodResponse =
        foodService.getFoodByBrand(
            brand,
            ingredient,
            nutritionType,
            health,
            calories,
            category,
            nutrients
        )

    suspend fun getFoodByUpc(
        upc: String,
        ingredient: String?,
        brand: String?,
        nutritionType: String?,
        health: String?,
        calories: String?,
        category: String?,
        nutrients: HashMap<String, String>?
    ): FoodResponse =
        foodService.getFoodByUpc(
            upc,
            ingredient,
            brand,
            nutritionType,
            health,
            calories,
            category,
            nutrients
        )
}