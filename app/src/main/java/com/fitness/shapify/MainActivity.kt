package com.fitness.shapify

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import com.fitness.authentication.util.AuthStateManager
import com.fitness.framework.auth.AuthState
import com.fitness.shapify.di.ShapifyApp
import com.fitness.shapify.di.provider.LocalAppProvider
import com.fitness.shapify.navigation.OnboardingNavigation
import com.fitness.shapify.components.drawer.AppBarWithNavigationDrawer
import com.fitness.shapify.theme.ShapifyTheme
import com.google.accompanist.navigation.animation.rememberAnimatedNavController
import com.google.firebase.auth.FirebaseAuth
import dagger.hilt.android.AndroidEntryPoint
import util.DrawerNavigationUtil
import widget.LoadingScreen

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    @OptIn(ExperimentalAnimationApi::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ShapifyTheme {

                val authState by AuthStateManager.authState.collectAsState()

                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    val appProvider = (application as ShapifyApp).appProvider
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

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MainHub(navController: NavHostController) {
    AppBarWithNavigationDrawer(
        items = DrawerNavigationUtil.drawerNavItems,
        navController = navController
    )
}

@Composable
fun AuthHub(navController: NavHostController) {
    OnboardingNavigation(navController)
}