package analysis.com.fitness

import androidx.compose.runtime.Composable
import androidx.navigation.NavBackStackEntry
import androidx.navigation.NavHostController
import com.fitness.analysis.AnalysisEntry
import com.fitness.analysis.analysis.com.fitness.HealthAnalysisScreen
import com.fitness.navigation.Destinations
import javax.inject.Inject

class AnalysisEntryImpl @Inject constructor(): AnalysisEntry() {

    @Composable
    override fun Composable(navController: NavHostController, destinations: Destinations, backStackEntry: NavBackStackEntry) {
        HealthAnalysisScreen()
    }
}