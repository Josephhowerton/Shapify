package di

import android.content.Context
import com.fitness.framework.network.interceptor.ExerciseInterceptor
import com.fitness.framework.network.interceptor.NutritionInterceptor
import com.fitness.framework.network.util.NetworkConfig
import com.fitness.framework.network.util.createExerciseInterceptor
import com.fitness.framework.network.util.createMoshi
import com.fitness.framework.network.util.createNutritionInterceptor
import com.fitness.framework.network.util.createOkHttpClient
import com.fitness.framework.network.util.createRetrofitWithMoshi
import com.squareup.moshi.Moshi
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import service.AutoCompleteService
import service.ExerciseService
import service.FoodDatabaseService
import service.NutritionService
import service.RecipeService
import javax.inject.Named
import javax.inject.Singleton


private const val EXERCISE_BASE_URL = "exercise"
private const val NUTRITION_BASE_URL = "nutrition"

@Module
@InstallIn(SingletonComponent::class)
class RemoteModule {

    @Provides
    @Singleton
    @Named(value = EXERCISE_BASE_URL)
    fun provideNutritionBaseUrl(networkConfig: NetworkConfig): String = networkConfig.nutritionBaseUrl()

    @Provides
    @Singleton
    @Named(value = NUTRITION_BASE_URL)
    fun provideExerciseBaseUrl(networkConfig: NetworkConfig): String = networkConfig.exerciseBaseUrl()

    @Provides
    @Singleton
    fun provideMoshi(): Moshi = createMoshi()

    @Provides
    @Singleton
    fun provideNutritionInterceptor(): NutritionInterceptor = createNutritionInterceptor()

    @Provides
    @Singleton
    fun provideExerciseInterceptor(): ExerciseInterceptor = createExerciseInterceptor()

    @Provides
    @Singleton
    fun provideOkHttpClient(
        @ApplicationContext context: Context,
        nutritionInterceptor: NutritionInterceptor,
        exerciseInterceptor: ExerciseInterceptor,
        httpLoggingInterceptor: HttpLoggingInterceptor
    ) = createOkHttpClient(context = context, isCache = true, nutritionInterceptor, exerciseInterceptor, httpLoggingInterceptor)

    @Provides
    @Singleton
    fun provideAutoCompleteService(
        @Named(value = NUTRITION_BASE_URL) baseUrl: String,
        moshi: Moshi,
        okHttpClient: OkHttpClient
    ): AutoCompleteService =
        createRetrofitWithMoshi(baseUrl = baseUrl, okHttpClient = okHttpClient, moshi = moshi)

    @Provides
    @Singleton
    fun provideFoodDatabaseService(
        @Named(value = NUTRITION_BASE_URL) baseUrl: String,
        moshi: Moshi,
        okHttpClient: OkHttpClient
    ): FoodDatabaseService =
        createRetrofitWithMoshi(baseUrl = baseUrl, okHttpClient = okHttpClient, moshi = moshi)

    @Provides
    @Singleton
    fun provideNutritionService(
        @Named(value = NUTRITION_BASE_URL) baseUrl: String,
        moshi: Moshi,
        okHttpClient: OkHttpClient
    ): NutritionService =
        createRetrofitWithMoshi(baseUrl = baseUrl, okHttpClient = okHttpClient, moshi = moshi)

    @Provides
    @Singleton
    fun provideRecipeService(
        @Named(value = NUTRITION_BASE_URL) baseUrl: String,
        moshi: Moshi,
        okHttpClient: OkHttpClient
    ): RecipeService =
        createRetrofitWithMoshi(baseUrl = baseUrl, okHttpClient = okHttpClient, moshi = moshi)

    @Provides
    @Singleton
    fun provideExerciseService(
        @Named(value = EXERCISE_BASE_URL) baseUrl: String,
        moshi: Moshi,
        okHttpClient: OkHttpClient
    ): ExerciseService =
        createRetrofitWithMoshi(baseUrl = baseUrl, okHttpClient = okHttpClient, moshi = moshi)

}