package account.com.fitness.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavBackStackEntry
import androidx.navigation.NavHostController
import com.fitness.account.AccountEntry
import com.fitness.account.account.com.fitness.AccountManagementScreen
import com.fitness.navigation.Destinations
import javax.inject.Inject

class AccountEntryImpl @Inject constructor(): AccountEntry() {

    @Composable
    override fun Composable(navController: NavHostController, destinations: Destinations, backStackEntry: NavBackStackEntry) {
        AccountManagementScreen()
    }
}