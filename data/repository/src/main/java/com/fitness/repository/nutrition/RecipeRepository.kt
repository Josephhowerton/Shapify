package com.fitness.repository.nutrition

import com.fitness.model.remote.nutrition.recipe.RecipeResponse
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase
import service.RecipeService
import javax.inject.Inject

class RecipeRepository @Inject constructor(
    private val recipeService: RecipeService
) {
    private val db = Firebase.firestore

    suspend fun getRecipes(
        query: String,
        ingredients: String?,
        diet: ArrayList<String>?,
        health: ArrayList<String>?,
        cuisineType: ArrayList<String>?,
        mealType: ArrayList<String>?,
        dishType: ArrayList<String>?,
        calories: String?,
        time: String?,
        imageSize: ArrayList<String>?,
        glycemicIndex: String?,
        excluded: ArrayList<String>?,
        random: String?,
        co2EmissionsClass: String?,
        tag: ArrayList<String>?,
        language: String?,
    ): RecipeResponse =
        recipeService.getRecipes(
            query = query,
            ingredients = ingredients,
            diet = diet,
            health = health,
            cuisineType = cuisineType,
            mealType = mealType,
            dishType = dishType,
            calories = calories,
            time = time,
            imageSize = imageSize,
            glycemicIndex = glycemicIndex,
            excluded = excluded,
            random = random,
            co2EmissionsClass = co2EmissionsClass,
            tag = tag,
            language = language
        )

    suspend fun getRecipesByUri(uri: ArrayList<String>, language: String?): RecipeResponse =
        recipeService.getRecipesByUri(uri = uri, language = language)

    suspend fun getRecipesById(id: String, language: String?): RecipeResponse =
        recipeService.getRecipesById(id = id, language = language)

}