package service

import com.fitness.framework.network.Nutrition
import com.fitness.framework.network.util.NutritionSource
import com.fitness.model.remote.nutrition.food.FoodResponse
import retrofit2.http.GET
import retrofit2.http.Query
import retrofit2.http.QueryMap

interface FoodDatabaseService {
    @Nutrition(NutritionSource.FOOD)
    @GET(PARSER_ENDPOINT)
    suspend fun getAllFood(): FoodResponse

    @Nutrition(NutritionSource.FOOD)
    @GET(PARSER_ENDPOINT)
    suspend fun getFoodByIngredient(
        @Query(INGREDIENTS_PARAM) ingredient: String,
        @Query(BRAND_PARAM) brand: String?,
        @Query(NUTRITION_TYPE_PARAM) nutritionType: String?,
        @Query(HEALTH_PARAM) health: String?,
        @Query(CALORIES_PARAM) calories: String?,
        @Query(CATEGORY_PARAM) category: String?,
        @QueryMap nutrients: HashMap<String, String>?
    ): FoodResponse

    @Nutrition(NutritionSource.FOOD)
    @GET(PARSER_ENDPOINT)
    suspend fun getFoodByBrand(
        @Query(BRAND_PARAM) brand: String,
        @Query(INGREDIENTS_PARAM) ingredient: String?,
        @Query(NUTRITION_TYPE_PARAM) nutritionType: String?,
        @Query(HEALTH_PARAM) health: String?,
        @Query(CALORIES_PARAM) calories: String?,
        @Query(CATEGORY_PARAM) category: String?,
        @QueryMap nutrients: HashMap<String, String>?
    ): FoodResponse

    @Nutrition(NutritionSource.FOOD)
    @GET(PARSER_ENDPOINT)
    suspend fun getFoodByUpc(
        @Query(UPC_PARAM) upc: String,
        @Query(INGREDIENTS_PARAM) ingredient: String?,
        @Query(BRAND_PARAM) brand: String?,
        @Query(NUTRITION_TYPE_PARAM) nutritionType: String?,
        @Query(HEALTH_PARAM) health: String?,
        @Query(CALORIES_PARAM) calories: String?,
        @Query(CATEGORY_PARAM) category: String?,
        @QueryMap nutrients: HashMap<String, String>?
    ): FoodResponse

    companion object {
        const val PARSER_ENDPOINT = "parser"
        const val INGREDIENTS_PARAM = "ingr"
        const val BRAND_PARAM = "brand"
        const val UPC_PARAM = "upc"
        const val NUTRITION_TYPE_PARAM = " nutrition-type"
        const val HEALTH_PARAM = "health"
        const val CALORIES_PARAM = "calories"
        const val CATEGORY_PARAM = "category"
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