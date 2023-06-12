package com.fitness.shapify.theme.properties

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.CardDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color


@Composable
fun cardColors() = if (isSystemInDarkTheme()) darkCardColors() else lightCardColors()

@Composable
private fun darkCardColors() = CardDefaults.cardColors(disabledContainerColor = Color.Gray,)

@Composable
private fun lightCardColors() = CardDefaults.cardColors(disabledContainerColor = Color.Gray,)
