package com.fitness.repository.exercise

import com.fitness.cache.FirestoreUtil
import com.fitness.model.domain.sessions.ExerciseSession
import com.google.firebase.firestore.Filter
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase
import javax.inject.Inject

class ExerciseSessionRepository @Inject constructor() {

    private val db = Firebase.firestore

    fun createExerciseSession(session: ExerciseSession) =
        db.collection(FirestoreUtil.PATH_EXERCISE_SESSION)
            .document(session.id)
            .set(session)

    fun readExerciseSessionById(id: String) =
        db.collection(FirestoreUtil.PATH_EXERCISE_SESSION)
            .document(id)
            .get()
    fun readAllExerciseSessionsByUid(uid: String) =
        db.collection(FirestoreUtil.PATH_EXERCISE_SESSION)
            .where(Filter.equalTo(FirestoreUtil.FIELD_USER_ID, uid))
            .get()

    fun readAllExerciseSessionsOnDate(date: Long) =
        db.collection(FirestoreUtil.PATH_EXERCISE_SESSION)
            .where(Filter.equalTo(FirestoreUtil.FIELD_CREATED, date))
            .get()
    fun readAllExerciseSessionsBetweenDates(startDate: Long, endDate:Long) =
        db.collection(FirestoreUtil.PATH_EXERCISE_SESSION)
            .where(Filter.equalTo(FirestoreUtil.FIELD_CREATED, startDate))
            .get()


    fun deleteExerciseSession(id: String) =
        db.collection(FirestoreUtil.PATH_EXERCISE_SESSION)
            .document(id)
            .delete()
}