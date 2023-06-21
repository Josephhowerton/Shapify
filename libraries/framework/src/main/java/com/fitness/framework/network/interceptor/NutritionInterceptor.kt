package com.fitness.framework.network.interceptor

import com.fitness.framework.network.Nutrition
import com.fitness.framework.network.util.NutritionSource
import okhttp3.Interceptor
import okhttp3.Request
import okhttp3.Response
import retrofit2.Invocation

class NutritionInterceptor : Interceptor {
    private val registration: MutableMap<Int, Nutrition> = mutableMapOf()

    override fun intercept(chain: Interceptor.Chain): Response {
        var request = chain.request()
        val annotation = findAnnotation(request)
        if (annotation != null) {
            request = buildRequest(chain, annotation.source)
        }
        return chain.proceed(request)
    }

    private fun findAnnotation(request: Request): Nutrition? {
        val key = request.url.hashCode()
        return registration[key] ?: request.tag(Invocation::class.java)
            ?.method()
            ?.annotations
            ?.filterIsInstance<Nutrition>()
            ?.firstOrNull()
            ?.also { registration[key] = it }
    }

    private fun buildRequest(chain: Interceptor.Chain, source: NutritionSource): Request {
        val requestBuilder = chain.request().newBuilder()
        when (source) {
            NutritionSource.FOOD -> {
                requestBuilder
                    .addHeader(app_id, food_database_id)
                    .addHeader(app_key, food_database_key)
            }
            NutritionSource.NUTRITION -> {
                requestBuilder
                    .addHeader(app_id, food_database_id)
                    .addHeader(app_key, food_database_key)
            }
            NutritionSource.RECIPE -> {
                requestBuilder
                    .addHeader(app_id, recipe_search_id)
                    .addHeader(app_key, recipe_search_key)
            }
        }
        return requestBuilder.build()
    }

    companion object {
        const val app_id = "app_id"
        const val app_key = "app_key"

        const val food_database_id = "102460ac"
        const val food_database_key = "7047213387e1e954d2845802469a0ab5"

        const val recipe_search_id = "f041b14e"
        const val recipe_search_key = "2bfbcd5b504581bc03af70cdde4bce3a"
    }
}