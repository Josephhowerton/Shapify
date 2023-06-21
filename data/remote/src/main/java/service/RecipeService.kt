package service

import com.fitness.framework.network.Nutrition
import com.fitness.framework.network.util.NutritionSource
import com.fitness.model.remote.nutrition.recipe.RecipeResponse
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface RecipeService {

    @Nutrition(NutritionSource.RECIPE)
    @GET(BASE_ENDPOINT)
    suspend fun getRecipes(
        @Query(TYPE_PARAM) type: String = "any",
        @Query(QUERY_PARAM) query: String,
        @Query(INGREDIENTS_PARAM) ingredients: String?,
        @Query(DIET_PARAM) diet: ArrayList<String>?,
        @Query(HEALTH_PARAM) health: ArrayList<String>?,
        @Query(CUISINE_TYPE_PARAM) cuisineType: ArrayList<String>?,
        @Query(MEAL_TYPE_PARAM) mealType: ArrayList<String>?,
        @Query(DISH_TYPE_PARAM) dishType: ArrayList<String>?,
        @Query(CALORIES_PARAM) calories: String?,
        @Query(TIME_PARAM) time: String?,
        @Query(IMAGE_SIZE_PARAM) imageSize: ArrayList<String>?,
        @Query(GLYCEMIC_INDEX_PARAM) glycemicIndex: String?,
        @Query(EXCLUDED_PARAM) excluded: ArrayList<String>?,
        @Query(RANDOM_PARAM) random: String?,
        @Query(C02_EMISSION_PARAM) co2EmissionsClass: String?,
        @Query(TAG_PARAM) tag: ArrayList<String>?,
        @Query(ACCEPT_LANGUAGE_PARAM) language: String?,
    ): RecipeResponse

    @Nutrition(NutritionSource.RECIPE)
    @GET("$BASE_ENDPOINT/$URI_ENDPOINT")
    suspend fun getRecipesByUri(
        @Query(TYPE_PARAM) type: String = "any",
        @Query(URI_PARAM) uri: ArrayList<String>,
        @Query(ACCEPT_LANGUAGE_PARAM) language: String?,
    ): RecipeResponse

    @Nutrition(NutritionSource.RECIPE)
    @GET("$BASE_ENDPOINT/{$ID_ENDPOINT}")
    suspend fun getRecipesById(
        @Query(TYPE_PARAM) type: String = "any",
        @Path(ID_ENDPOINT) id: String,
        @Query(ACCEPT_LANGUAGE_PARAM) language: String?,
    ): RecipeResponse

    companion object {
        const val BASE_ENDPOINT = "api/recipes/v2"
        const val URI_ENDPOINT = "by-uri"
        const val ID_ENDPOINT = "id"
        const val URI_PARAM = "uri"
        const val TYPE_PARAM = "type"
        const val QUERY_PARAM = "q"
        const val INGREDIENTS_PARAM = "ingr"
        const val DIET_PARAM = "diet"
        const val HEALTH_PARAM = "health"
        const val CUISINE_TYPE_PARAM = "cuisineType"
        const val MEAL_TYPE_PARAM = "mealType"
        const val DISH_TYPE_PARAM = "dishType"
        const val CALORIES_PARAM = "calories"
        const val TIME_PARAM = "time"
        const val IMAGE_SIZE_PARAM = "imageSize"
        const val GLYCEMIC_INDEX_PARAM = "glycemicIndex"
        const val EXCLUDED_PARAM = "excluded"
        const val RANDOM_PARAM = "random"
        const val C02_EMISSION_PARAM = "co2EmissionsClass"
        const val TAG_PARAM = "tag"
        const val ACCEPT_LANGUAGE_PARAM = "Accept-Language"
        const val NUTRIENTS_CA = "nutrients[CA]"
        const val NUTRIENTS_CHOCDF = "nutrients[CHOCDF]"
        const val NUTRIENTS_CHOCDF_NET = "nutrients[CHOCDF.net]"
        const val NUTRIENTS_CHOLE = "nutrients[CHOLE]"
        const val NUTRIENTS_ENERC_KCAL = "nutrients[ENERC_KCAL]"
        const val NUTRIENTS_FAMS = "nutrients[FAMS]"
        const val NUTRIENTS_FAPU = "nutrients[FAPU]"
        const val NUTRIENTS_FASAT = "nutrients[FASAT]"
        const val NUTRIENTS_FAT = "nutrients[FAT]"
        const val NUTRIENTS_FATRN = "nutrients[FATRN]"
        const val NUTRIENTS_FE = "nutrients[FE]"
        const val NUTRIENTS_FIBTG = "nutrients[FIBTG]"
        const val NUTRIENTS_FOLAC = "nutrients[FOLAC]"
        const val NUTRIENTS_FOLDFE = "nutrients[FOLDFE]"
        const val NUTRIENTS_FOLFD = "nutrients[FOLFD]"
        const val NUTRIENTS_K = "nutrients[K]"
        const val NUTRIENTS_MG = "nutrients[MG]"
        const val NUTRIENTS_NA = "nutrients[NA]"
        const val NUTRIENTS_NIA = "nutrients[NIA]"
        const val NUTRIENTS_P = "nutrients[P]"
        const val NUTRIENTS_PROCNT = "nutrients[PROCNT]"
        const val NUTRIENTS_RIBF = "nutrients[RIBF]"
        const val NUTRIENTS_SUGAR = "nutrients[SUGAR]"
        const val NUTRIENTS_SUGAR_ADDED = "nutrients[SUGAR.added]"
        const val NUTRIENTS_SUGAR_ALCOHOL = "nutrients[Sugar.alcohol]"
        const val NUTRIENTS_THIA = "nutrients[THIA]"
        const val NUTRIENTS_TOCPHA = "nutrients[TOCPHA]"
        const val NUTRIENTS_VITA_RAE = "nutrients[VITA_RAE]"
        const val NUTRIENTS_VITB12 = "nutrients[VITB12]"
        const val NUTRIENTS_VITB6A = "nutrients[VITB6A]"
        const val NUTRIENTS_VITC = "nutrients[VITC]"
        const val NUTRIENTS_VITD = "nutrients[VITD]"
        const val NUTRIENTS_VITK1 = "nutrients[VITK1]"
        const val NUTRIENTS_WATER = "nutrients[WATER]"
        const val NUTRIENTS_ZN = "nutrients[ZN]"
    }
}