package service

import com.fitness.framework.network.Nutrition
import com.fitness.framework.network.util.NutritionSource
import com.fitness.model.remote.nutrition.nutrients.NutrientsResponse
import retrofit2.http.POST

interface NutritionService {

    @Nutrition(NutritionSource.FOOD)
    @POST(NUTRIENTS_ENDPOINT)
    suspend fun getFoodNutrients(): NutrientsResponse

    companion object{
        const val NUTRIENTS_ENDPOINT = "nutrients"
        const val INGREDIENTS_PARAM = "ingredients"
        const val QUANTITY_PARAM = "quantity"
        const val MEASUREMENT_URI_PARAM = "measureURI"
        const val QUALIFIERS_PARAM = "qualifiers"
        const val FOOD_ID_PARAM = "foodId"
    }
}

/*
{
  "ingredients": [
    {
      "quantity": 0,
      "measureURI": "string",
      "qualifiers": [
        "string"
      ],
      "foodId": "string"
    }
  ]
}
 */