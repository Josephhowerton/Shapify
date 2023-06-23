package com.fitness.tracking.configurations

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
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
private fun DailyWorkOutTrackingPreview(){
    DailyWorkOutTrackingConfiguration(Modifier)
}

@Preview
@Composable
private fun WeeklyWorkOutTrackingPreview(){
    WeeklyWorkOutTrackingConfiguration(Modifier)
}

@Preview
@Composable
private fun MonthlyWorkOutTrackingPreview(){
    MonthlyWorkOutTrackingConfiguration(Modifier)
}

@Preview
@Composable
private fun WorkoutMetricSummaryPreview(){
    WorkoutMetricSummary(Modifier)
}

@Composable
fun DailyWorkOutTrackingConfiguration(modifier: Modifier){
    ConstraintLayout(modifier.fillMaxSize()) {
        val (metricSummaryRef,
            dateRef,
            subTitleRef,
            workoutsRef
        ) = createRefs()

        WorkoutMetricSummary(modifier = Modifier
            .wrapContentHeight()
            .constrainAs(metricSummaryRef) {
                top.linkTo(parent.top)
                start.linkTo(parent.start)
                end.linkTo(parent.end)
                width = Dimension.fillToConstraints
            }
        )

        DatePickerComponent(
            configuration = TimelineConfiguration.DAILY,
            modifier = Modifier.constrainAs(dateRef) {
                top.linkTo(metricSummaryRef.bottom, margin = 15.dp)
                start.linkTo(parent.start)
            }
        ){

        }

        Text(text = "Workout Tracking", fontSize = 18.sp, modifier = Modifier
            .fillMaxWidth()
            .padding(top = 5.dp, start = 25.dp)
            .constrainAs(subTitleRef) {
                top.linkTo(dateRef.bottom)
            }
        )

        WorkoutTrackingList(mealPlan = listOf(), showAddMore = true, configuration = TimelineConfiguration.DAILY, modifier = Modifier
            .fillMaxWidth()
            .wrapContentHeight()
            .padding(5.dp)
            .constrainAs(workoutsRef) {
                top.linkTo(subTitleRef.bottom)
                start.linkTo(parent.start)
                end.linkTo(parent.end)
            }
        )
    }
}

@Composable
fun WeeklyWorkOutTrackingConfiguration(modifier: Modifier){
    ConstraintLayout(modifier.fillMaxSize()) {
        val (metricSummaryRef,
            dateRef,
            subTitleRef,
            workoutsRef
        ) = createRefs()

        WorkoutMetricSummary(modifier = Modifier
            .wrapContentHeight()
            .constrainAs(metricSummaryRef) {
                top.linkTo(parent.top)
                start.linkTo(parent.start)
                end.linkTo(parent.end)
                width = Dimension.fillToConstraints
            }
        )

        DatePickerComponent(
            configuration = TimelineConfiguration.WEEKLY,
            modifier = Modifier.constrainAs(dateRef) {
                top.linkTo(metricSummaryRef.bottom, margin = 15.dp)
                start.linkTo(parent.start)
            }
        ){

        }

        Text(text = "Workout Tracking", fontSize = 18.sp, modifier = Modifier
            .fillMaxWidth()
            .padding(top = 5.dp, start = 25.dp)
            .constrainAs(subTitleRef) {
                top.linkTo(dateRef.bottom)
            }
        )

        WorkoutTrackingList(mealPlan = listOf(), showAddMore = true, configuration = TimelineConfiguration.WEEKLY, modifier = Modifier
            .fillMaxWidth()
            .wrapContentHeight()
            .padding(5.dp)
            .constrainAs(workoutsRef) {
                top.linkTo(subTitleRef.bottom)
                start.linkTo(parent.start)
                end.linkTo(parent.end)
            }
        )
    }
}

@Composable
fun MonthlyWorkOutTrackingConfiguration(modifier: Modifier){
    ConstraintLayout(modifier.fillMaxSize()) {
        val (metricSummaryRef,
            dateRef,
            subTitleRef,
            workoutsRef
        ) = createRefs()

        WorkoutMetricSummary(modifier = Modifier
            .wrapContentHeight()
            .constrainAs(metricSummaryRef) {
                top.linkTo(parent.top)
                start.linkTo(parent.start)
                end.linkTo(parent.end)
                width = Dimension.fillToConstraints
            })

        DatePickerComponent(
            configuration = TimelineConfiguration.WEEKLY,
            modifier = Modifier.constrainAs(dateRef) {
                top.linkTo(metricSummaryRef.bottom, margin = 15.dp)
                start.linkTo(parent.start)
            }
        ){

        }

        Text(text = "Workout Tracking", fontSize = 18.sp, modifier = Modifier
            .fillMaxWidth()
            .padding(top = 5.dp, start = 25.dp)
            .constrainAs(subTitleRef) {
                top.linkTo(dateRef.bottom)
            })

        WorkoutTrackingList(mealPlan = listOf(), showAddMore = false, configuration = TimelineConfiguration.MONTHLY, modifier = Modifier
            .fillMaxWidth()
            .wrapContentHeight()
            .padding(5.dp)
            .constrainAs(workoutsRef) {
                top.linkTo(subTitleRef.bottom)
                start.linkTo(parent.start)
                end.linkTo(parent.end)
            }
        )
    }
}

@Composable
private fun WorkoutMetricSummary(modifier: Modifier) {

    ConstraintLayout(modifier = modifier.fillMaxWidth().wrapContentHeight()) {

        val (workoutsCompletedRef, stepsCompletedRef, cardioCompletedRef, distanceCompletedRef, caloriesBurnedRef, dateRef) = createRefs()


        //TODO(Add data for Workouts Completed)
        HealthSummaryComponent(
            configuration = HealthSummaryConfiguration.HORIZONTAL,
            modifier = Modifier.padding(5.dp).wrapContentHeight()
                .constrainAs(workoutsCompletedRef) {
                    top.linkTo(parent.top)
                    start.linkTo(parent.start)
                    end.linkTo(parent.end)
                    width = Dimension.fillToConstraints
                }
        )

        //TODO(Add data for Steps)
        HealthSummaryComponent(
            configuration = HealthSummaryConfiguration.HORIZONTAL,
            modifier = Modifier.padding(5.dp).wrapContentHeight()
                .constrainAs(stepsCompletedRef) {
                    top.linkTo(workoutsCompletedRef.bottom)
                    start.linkTo(parent.start)
                    end.linkTo(parent.end)
                    width = Dimension.fillToConstraints
                }
        )

        //TODO(Add data for Cardio)
        HealthSummaryComponent(
            configuration = HealthSummaryConfiguration.HORIZONTAL,
            modifier = Modifier
                .padding(5.dp)
                .wrapContentHeight()
                .constrainAs(cardioCompletedRef) {
                    top.linkTo(stepsCompletedRef.bottom)
                    start.linkTo(parent.start)
                    end.linkTo(parent.end)
                    width = Dimension.fillToConstraints
                }
        )

        //TODO(Add data for Distance)
        HealthSummaryComponent(
            configuration = HealthSummaryConfiguration.HORIZONTAL,
            modifier = Modifier
                .padding(5.dp)
                .wrapContentHeight()
                .constrainAs(distanceCompletedRef) {
                    top.linkTo(cardioCompletedRef.bottom)
                    start.linkTo(parent.start)
                    end.linkTo(parent.end)
                    width = Dimension.fillToConstraints
                }
        )

        //TODO(Add data for Calories Burned)
        HealthSummaryComponent(
            configuration = HealthSummaryConfiguration.HORIZONTAL,
            modifier = Modifier
                .padding(5.dp)
                .wrapContentHeight()
                .constrainAs(caloriesBurnedRef) {
                    top.linkTo(cardioCompletedRef.bottom)
                    start.linkTo(parent.start)
                    end.linkTo(parent.end)
                    width = Dimension.fillToConstraints
                }
        )
    }
}

@Composable
private fun WorkoutTrackingList(mealPlan: List<Any>, showAddMore: Boolean, configuration: TimelineConfiguration, modifier: Modifier){

    Column(horizontalAlignment = Alignment.CenterHorizontally, verticalArrangement = Arrangement.SpaceBetween,
        modifier = modifier
            .fillMaxWidth()
            .wrapContentHeight()
            .padding(5.dp)) {

        repeat(mealPlan.size){
            AddWorkoutItem(mealPlan = mealPlan, configuration = configuration)
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
private fun AddWorkoutItem(mealPlan: List<Any>, configuration: TimelineConfiguration) {
    return when(configuration){
        TimelineConfiguration.DAILY -> DailyHealthItemComponent(mealItem = mealPlan, modifier =  Modifier.padding(10.dp))
        TimelineConfiguration.WEEKLY -> WeeklyHealthItemComponent(mealItem = mealPlan, modifier = Modifier.padding(10.dp))
        TimelineConfiguration.MONTHLY-> MonthlyHealthItemComponent(mealItem = mealPlan, modifier =  Modifier.padding(10.dp))
    }
}