package com.fitness.repository.exercise

import com.fitness.cache.FirestoreUtil.FIELD_CREATED
import com.fitness.cache.FirestoreUtil.FIELD_SESSION_ID
import com.fitness.cache.FirestoreUtil.PATH_WORKOUT
import com.fitness.model.domain.exercise.Exercise
import com.google.firebase.firestore.Filter
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase
import javax.inject.Inject

class ExerciseRepository @Inject constructor() {

    private val db = Firebase.firestore

    fun createWorkout(session: Exercise) =
        db.collection(PATH_WORKOUT)
            .document(session.id)
            .set(session)

    fun readWorkoutById(id: String) =
        db.collection(PATH_WORKOUT)
            .document(id)
            .get()

    fun readAllWorkoutsBySessionId(sid: String) =
        db.collection(PATH_WORKOUT)
            .where(Filter.equalTo(FIELD_SESSION_ID, sid))
            .get()

    fun readAllWorkoutsOnDate(sid: String, date: Long) =
        db.collection(PATH_WORKOUT)
            .where(Filter.equalTo(FIELD_SESSION_ID, sid))
            .where(Filter.equalTo(FIELD_CREATED, date))
            .get()

    fun readAllWorkoutsBetweenDates(sid: String, startDate: Long, endDate:Long) =
        db.collection(PATH_WORKOUT)
            .where(Filter.equalTo(FIELD_SESSION_ID, sid))
            .where(Filter.greaterThanOrEqualTo(FIELD_CREATED, startDate))
            .where(Filter.lessThanOrEqualTo(FIELD_CREATED, endDate))
            .get()

    fun deleteWorkout(id: String) =
        db.collection(PATH_WORKOUT)
            .document(id)
            .delete()
}