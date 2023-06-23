package com.fitness.shapify.view

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.fitness.framework.auth.AuthStateManager
import com.fitness.shapify.di.ShapifyApp
import com.google.firebase.auth.FirebaseAuth
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AppContent(appProvider = (application as ShapifyApp).appProvider)
        }
    }

    override fun onResume() {
        super.onResume()
        FirebaseAuth.getInstance().addAuthStateListener(AuthStateManager)
    }

    override fun onPause() {
        super.onPause()
        FirebaseAuth.getInstance().removeAuthStateListener(AuthStateManager)
    }
}