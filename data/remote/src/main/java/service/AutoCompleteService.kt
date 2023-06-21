package service

import com.fitness.framework.network.Nutrition
import com.fitness.framework.network.util.NutritionSource
import com.fitness.model.remote.nutrition.autocomplete.AutoCompleteResponse
import retrofit2.http.GET
import retrofit2.http.Query

/**
*
 */
interface AutoCompleteService {

    @Nutrition(NutritionSource.FOOD)
    @GET(AUTO_COMPLETE_ENDPOINT)
    suspend fun autoComplete(@Query(QUERY_PARAM) q: String, @Query(LIMIT_PARAM) limit: Int?) : AutoCompleteResponse

    companion object{
        const val AUTO_COMPLETE_ENDPOINT = "auto-complete"

        const val QUERY_PARAM = "q"
        const val LIMIT_PARAM = "limit"
    }
}