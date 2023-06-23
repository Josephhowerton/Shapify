package com.fitness.shapify.components

import androidx.compose.foundation.layout.size
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import com.fitness.shapify.theme.DarkBlack
import com.fitness.shapify.theme.PrimaryBlue
import com.fitness.shapify.theme.PrimaryWhite
import util.BottomNavigationUtil

@Composable
fun NavBar(
    navController: NavHostController
){

    val backStackEntry = navController.currentBackStackEntryAsState()

    NavigationBar(containerColor = DarkBlack) {
        BottomNavigationUtil.bottomNavItems.forEach { item ->
            val selected = item.route == backStackEntry.value?.destination?.route
            NavigationBarItem(
                selected = selected,
                onClick = { navController.navigate(item.route) },
                colors = NavigationBarItemDefaults.colors(indicatorColor = DarkBlack),
                icon = {
                    Icon(
                        painter = painterResource(id = item.icon),
                        modifier = Modifier.size(32.dp),
                        tint = if(selected) PrimaryBlue else PrimaryWhite,
                        contentDescription = "${item.name} Icon")
                }
            )
        }
    }
}