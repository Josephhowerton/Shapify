package com.fitness.shapify.view

import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import com.fitness.framework.auth.AuthStateManager.authState
import com.fitness.framework.auth.AuthState
import com.fitness.shapify.di.AppProvider
import com.fitness.shapify.di.LocalAppProvider
import com.fitness.shapify.navigation.AuthHub
import com.fitness.shapify.navigation.MainHub
import com.fitness.shapify.theme.ShapifyTheme
import com.google.accompanist.navigation.animation.rememberAnimatedNavController
import widget.LoadingScreen

@OptIn(ExperimentalAnimationApi::class)
@Composable
fun AppContent(appProvider: AppProvider) {
    ShapifyTheme {
        val authState by authState.collectAsState()
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = MaterialTheme.colorScheme.background
        ) {
            CompositionLocalProvider(LocalAppProvider provides appProvider) {

                val navController = rememberAnimatedNavController()

                when (authState) {
                    AuthState.LoggedIn -> MainHub(navController)
                    AuthState.LoggedOut -> AuthHub(navController)
                    AuthState.StartUp -> LoadingScreen()
                }

            }
        }
    }
}