package com.fitness.tracking.configurations

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.constraintlayout.compose.Dimension
import com.fitness.framework.enums.TimelineConfiguration
import components.BlankItemComponent
import components.HealthSummaryConfiguration
import components.DailyHealthItemComponent
import components.MonthlyHealthItemComponent
import components.NoDataDisplayedItemComponent
import components.DatePickerComponent
import components.HealthSummaryComponent
import components.WeeklyHealthItemComponent

@Preview
@Composable
private fun DailyDietTrackingPreview(){
    DailyDietTrackingConfiguration(Modifier)
}
@Preview
@Composable
private fun WeeklyDietTrackingPreview(){
    WeeklyDietTrackingConfiguration(Modifier)
}

@Preview
@Composable
private fun MonthlyDietTrackingPreview(){
    MonthlyDietTrackingConfiguration(Modifier)
}

@Preview
@Composable
private fun DietTrackingMetricsPreview(){
    DietTrackingMetrics(
        TimelineConfiguration.DAILY,
        Modifier
            .fillMaxWidth()
            .wrapContentHeight())
}

@Composable
fun DietTrackingConfiguration(configuration: TimelineConfiguration, modifier: Modifier) {
    return when(configuration) {
        TimelineConfiguration.DAILY -> DailyDietTrackingConfiguration(modifier)
        TimelineConfiguration.WEEKLY -> WeeklyDietTrackingConfiguration(modifier)
        TimelineConfiguration.MONTHLY-> MonthlyDietTrackingConfiguration(modifier)
    }
}


@Composable
private fun DailyDietTrackingConfiguration(modifier: Modifier) =
    ConstraintLayout(modifier.fillMaxSize()) {
        val (dietTrackingMetricsRef,
            mealTrackingTitleRef,
            mealsRef,
        ) = createRefs()

        DietTrackingMetrics(configuration = TimelineConfiguration.WEEKLY,
            modifier = Modifier
                .fillMaxWidth()
                .wrapContentHeight()
                .constrainAs(dietTrackingMetricsRef) {
                    top.linkTo(parent.top)
                })

        Text(text = "Diet Tracking", fontSize = 18.sp, modifier = Modifier
            .fillMaxWidth()
            .padding(top = 5.dp, start = 25.dp)
            .constrainAs(mealTrackingTitleRef) {
                top.linkTo(dietTrackingMetricsRef.bottom)
            })

        DietTrackingList(mealPlan = listOf(), showAddMore = true, configuration = TimelineConfiguration.DAILY, modifier = Modifier
            .fillMaxWidth()
            .wrapContentHeight()
            .padding(5.dp)
            .constrainAs(mealsRef) {
                top.linkTo(mealTrackingTitleRef.bottom)
                start.linkTo(parent.start)
                end.linkTo(parent.end)
            }
        )
    }

@Composable
private fun WeeklyDietTrackingConfiguration(modifier: Modifier) =
    ConstraintLayout(modifier.fillMaxSize()) {
        val (dietTrackingMetricsRef,
            mealTrackingTitleRef,
            mealsRef,
        ) = createRefs()

        DietTrackingMetrics(configuration = TimelineConfiguration.WEEKLY,
            modifier = Modifier
                .fillMaxWidth()
                .wrapContentHeight()
                .constrainAs(dietTrackingMetricsRef) {
                    top.linkTo(parent.top)
                }
        )

        Text(text = "Weekly Diet History", fontSize = 18.sp, modifier = Modifier
            .fillMaxWidth()
            .padding(top = 5.dp, start = 25.dp)
            .constrainAs(mealTrackingTitleRef) {
                top.linkTo(dietTrackingMetricsRef.bottom)
            })

        DietTrackingList(mealPlan = listOf(), showAddMore = true, configuration = TimelineConfiguration.WEEKLY, modifier = Modifier
            .fillMaxWidth()
            .wrapContentHeight()
            .padding(5.dp)
            .constrainAs(mealsRef) {
                top.linkTo(mealTrackingTitleRef.bottom)
                start.linkTo(parent.start)
                end.linkTo(parent.end)
            }
        )
    }

@Composable
private fun MonthlyDietTrackingConfiguration(modifier: Modifier) = ConstraintLayout(modifier.fillMaxSize()) {
    val (dietTrackingMetricsRef,
        mealTrackingTitleRef,
        mealsRef,
    ) = createRefs()

    DietTrackingMetrics(configuration = TimelineConfiguration.MONTHLY,
        modifier = Modifier
            .fillMaxWidth()
            .wrapContentHeight()
            .constrainAs(dietTrackingMetricsRef) {
                top.linkTo(parent.top)
            })

    Text(text = "Monthly Diet History", fontSize = 18.sp, modifier = Modifier
        .fillMaxWidth()
        .padding(top = 5.dp, start = 25.dp)
        .constrainAs(mealTrackingTitleRef) {
            top.linkTo(dietTrackingMetricsRef.bottom)
        })

    DietTrackingList(mealPlan = listOf(), showAddMore = false, configuration = TimelineConfiguration.MONTHLY, modifier = Modifier
        .fillMaxWidth()
        .wrapContentHeight()
        .padding(5.dp)
        .constrainAs(mealsRef) {
            top.linkTo(mealTrackingTitleRef.bottom)
            start.linkTo(parent.start)
            end.linkTo(parent.end)
        }
    )
}

@Composable
private fun DietTrackingMetrics(configuration: TimelineConfiguration, modifier: Modifier) = ConstraintLayout(modifier = modifier) {
    val (caloriesSummaryRef,
        carbSummaryRef,
        fatSummaryRef,
        proteinSummaryRef,
        dateRef) = createRefs()

    //TODO(Add data for user calories)
    HealthSummaryComponent(
        configuration = HealthSummaryConfiguration.HORIZONTAL,
        modifier = Modifier
            .wrapContentHeight()
            .constrainAs(caloriesSummaryRef) {
                top.linkTo(parent.top, 20.dp)
                start.linkTo(parent.start, 10.dp)
                end.linkTo(proteinSummaryRef.start, 10.dp)
                width = Dimension.fillToConstraints
            }
    )

    //TODO(Add data for user carbohydrates)
    HealthSummaryComponent(
        configuration = HealthSummaryConfiguration.HORIZONTAL,
        modifier = Modifier.wrapContentHeight().constrainAs(carbSummaryRef) {
            top.linkTo(caloriesSummaryRef.bottom, 20.dp)
            end.linkTo(caloriesSummaryRef.end)
            start.linkTo(caloriesSummaryRef.start)
            width = Dimension.fillToConstraints
        }
    )

    //TODO(Add data for user fat content)
    HealthSummaryComponent(
        configuration = HealthSummaryConfiguration.HORIZONTAL,
        modifier = Modifier
            .wrapContentHeight()
            .constrainAs(fatSummaryRef) {
                top.linkTo(carbSummaryRef.bottom, 20.dp)
                end.linkTo(caloriesSummaryRef.end)
                start.linkTo(caloriesSummaryRef.start)
                width = Dimension.fillToConstraints
            }
    )

    //TODO(Add data for protein and weight)
    HealthSummaryComponent(
        configuration = HealthSummaryConfiguration.VERTICAL,
        modifier = Modifier
            .width(150.dp)
            .constrainAs(proteinSummaryRef) {
                top.linkTo(caloriesSummaryRef.top)
                bottom.linkTo(fatSummaryRef.bottom)
                start.linkTo(caloriesSummaryRef.end)
                end.linkTo(parent.end, 10.dp)
                height = Dimension.fillToConstraints
            }
    )

    DatePickerComponent(configuration = configuration, modifier = Modifier.constrainAs(dateRef) {
        top.linkTo(proteinSummaryRef.bottom, margin = 15.dp)
        start.linkTo(parent.start)
    }){

    }
}

@Composable
private fun DietTrackingList(mealPlan: List<Any>, showAddMore: Boolean, configuration: TimelineConfiguration, modifier: Modifier){

    Column(horizontalAlignment = Alignment.CenterHorizontally, verticalArrangement = Arrangement.SpaceBetween,
        modifier = modifier
            .fillMaxWidth()
            .wrapContentHeight()
            .padding(5.dp)) {

        repeat(mealPlan.size){
            AddHealthItem(mealPlan = mealPlan, configuration = configuration)
        }

        if(showAddMore){
            BlankItemComponent(modifier =  Modifier.padding(10.dp))
        }

        if(mealPlan.isEmpty() && !showAddMore){
            NoDataDisplayedItemComponent(modifier =  Modifier.padding(10.dp))
        }
    }
}

@Composable
private fun AddHealthItem(mealPlan: List<Any>, configuration: TimelineConfiguration) {
    return when(configuration){
        TimelineConfiguration.DAILY -> DailyHealthItemComponent(mealItem = mealPlan, modifier =  Modifier.padding(10.dp))
        TimelineConfiguration.WEEKLY -> WeeklyHealthItemComponent(mealItem = mealPlan, modifier = Modifier.padding(10.dp))
        TimelineConfiguration.MONTHLY-> MonthlyHealthItemComponent(mealItem = mealPlan, modifier =  Modifier.padding(10.dp))
    }
}