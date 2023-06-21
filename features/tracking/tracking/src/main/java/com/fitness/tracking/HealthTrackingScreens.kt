package com.fitness.tracking

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout
import com.fitness.framework.enums.TimelineConfiguration
import com.fitness.tracking.configurations.DietTrackingConfiguartion
import components.DailyWeeklyMonthlyButtonComponent

@Preview(showBackground = true)
@Composable
private fun HealthTrackingPreview() {
    HealthTrackingScreen()
}

@Composable
fun HealthTrackingScreen() = Column(
    Modifier
        .fillMaxSize()
        .verticalScroll(rememberScrollState())
) {

    ConstraintLayout(Modifier.fillMaxSize()) {
        val (screenTitleRef, timelineRef, configurationRef) = createRefs()

        var configuration by remember {
            mutableStateOf(TimelineConfiguration.DAILY)
        }

        Text(text = "Diet Tracking", fontSize = 24.sp, modifier = Modifier
            .fillMaxWidth()
            .padding(10.dp)
            .constrainAs(screenTitleRef) {
                top.linkTo(parent.top)
                start.linkTo(parent.start)
                end.linkTo(parent.end)
            })

        DailyWeeklyMonthlyButtonComponent(configuration = configuration, modifier = Modifier.fillMaxWidth()
            .wrapContentHeight()
            .constrainAs(timelineRef) {
                top.linkTo(screenTitleRef.bottom)
                start.linkTo(parent.start)
                end.linkTo(parent.end)
            }
        ){
            configuration = it
        }

        DietTrackingConfiguartion(configuration = configuration, modifier = Modifier.constrainAs(configurationRef) {
            top.linkTo(timelineRef.bottom)
            start.linkTo(parent.start)
            end.linkTo(parent.end)
        })
    }
}

