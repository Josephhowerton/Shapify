package com.fitness.framework.network.interceptor

import com.fitness.framework.network.Exercise
import okhttp3.Interceptor
import okhttp3.Request
import okhttp3.Response
import retrofit2.Invocation

class ExerciseInterceptor : Interceptor {
    private val registration: MutableMap<Int, Exercise> = mutableMapOf()

    override fun intercept(chain: Interceptor.Chain): Response {
        var request = chain.request()
        val annotation = findAnnotation(request)
        if (annotation != null) {
            request = chain.request().newBuilder()
                .addHeader(app_id, id)
                .addHeader(app_key, key)
                .build()
        }
        return chain.proceed(request)
    }

    private fun findAnnotation(request: Request): Exercise? {
        val key = request.url.hashCode()
        return registration[key] ?: request.tag(Invocation::class.java)
            ?.method()
            ?.annotations
            ?.filterIsInstance<Exercise>()
            ?.firstOrNull()
            ?.also { registration[key] = it }
    }

    companion object {
        const val app_id = "app_id"
        const val app_key = "app_key"

        const val id = "102460ac"
        const val key = "7047213387e1e954d2845802469a0ab5"

    }
}