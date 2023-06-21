package service

import com.fitness.model.remote.exercise.AllExercisesResponse
import com.fitness.model.remote.exercise.BodyPartsResponse
import com.fitness.model.remote.exercise.ExerciseDto
import com.fitness.model.remote.exercise.ExercisesByBodyPartResponse
import com.fitness.model.remote.exercise.ExercisesByMuscleResponse
import com.fitness.model.remote.exercise.TargetMuscleResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface ExerciseService {
    @GET(BODY_PARTS_ENDPOINT)
    suspend fun getBodyPartsList() : BodyPartsResponse

    @GET(EXERCISE_BODY_PARTS_ENDPOINT)
    suspend fun getExercisesByBodyPart(@Query(BODY_PART_PARAM) bodyPart: String) : ExercisesByBodyPartResponse

    @GET(TARGET_MUSCLE_ENDPOINT)
    suspend fun getTargetMuscleList() : TargetMuscleResponse

    @GET(EXERCISE_TARGET_MUSCLE_ENDPOINT)
    suspend fun getExercisesByMuscle(@Query(TARGET_MUSCLE_PARAM) targetMuscle: String) : ExercisesByMuscleResponse

    @GET(ALL_EXERCISES_ENDPOINT)
    suspend fun getAllExercises() : AllExercisesResponse

    @GET(EXERCISE_ID_ENDPOINT)
    suspend fun getExerciseById(@Query(ID_PARAM) id: String) : ExerciseDto

    companion object{
        const val BODY_PARTS_ENDPOINT = "309/list+of+body+parts"
        const val EXERCISE_BODY_PARTS_ENDPOINT = "310/list+exercise+by+body+part"
        const val TARGET_MUSCLE_ENDPOINT = "311/list+of+target+muscles"
        const val EXERCISE_TARGET_MUSCLE_ENDPOINT = "312/list+by+target+muscle"
        const val ALL_EXERCISES_ENDPOINT = "313/list+of+all+exercise"
        const val EXERCISE_ID_ENDPOINT = "1004/exercise+by+id"

        const val TARGET_MUSCLE_PARAM = "target"
        const val BODY_PART_PARAM = "bodypart"
        const val ID_PARAM = "id"
    }
}