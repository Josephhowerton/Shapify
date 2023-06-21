package com.fitness.repository.user

import com.fitness.cache.FirestoreUtil.FIELD_EMAIL
import com.fitness.cache.FirestoreUtil.FIELD_FIRST_NAME
import com.fitness.cache.FirestoreUtil.FIELD_LAST_NAME
import com.fitness.cache.FirestoreUtil.FIELD_PHONE
import com.fitness.cache.FirestoreUtil.PATH_USER
import com.fitness.model.cache.user.UserEntity
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase
import javax.inject.Inject

class UserRepository @Inject constructor() {

    private val db = Firebase.firestore
    fun createUser(user: UserEntity) =
        db.collection(PATH_USER)
            .document(user.uid)
            .set(user)

    fun readUser(id: String) =
        db.collection(PATH_USER)
            .document(id)
            .get()

    fun updateUserDisplayName(id: String, firstname: String, lastname: String) =
        db.collection(PATH_USER)
            .document(id)
            .update(
                    mapOf(
                        FIELD_FIRST_NAME to firstname,
                        FIELD_LAST_NAME to lastname
                    )
            )

    fun updateUserEmail(id: String, email: String) =
        db.collection(PATH_USER)
            .document(id)
            .update(FIELD_EMAIL, email)

    fun updateUserPhone(id: String, phone: String) =
        db.collection(PATH_USER)
            .document(id)
            .update(FIELD_PHONE, phone)

    fun deleteUser(id: String) =
        db.collection(PATH_USER)
            .document(id)
            .delete()
}