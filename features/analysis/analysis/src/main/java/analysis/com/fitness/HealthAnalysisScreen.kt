package com.fitness.analysis.analysis.com.fitness

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Card
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp


@Preview(showBackground = true)
@Composable
private fun HealthAnalysisPreview(){
    HealthAnalysisScreen()
}

@Composable
fun HealthAnalysisScreen() = Column(Modifier.fillMaxSize(), horizontalAlignment = Alignment.CenterHorizontally) {
 
    Card(modifier = Modifier.fillMaxWidth().height(25.dp )) {
        
    }

    Card(modifier = Modifier.fillMaxWidth().height(25.dp )) {

    }

    Card(modifier = Modifier.fillMaxWidth().height(25.dp )) {

    }

    Card(modifier = Modifier.fillMaxWidth().height(25.dp )) {

    }
}