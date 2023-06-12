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
import com.fitness.model.enums.Configuration
import com.fitness.model.remote.nutrition.MealItem
import com.fitness.shapify.theme.PrimaryBlue
import com.fitness.shapify.util.ScreenUtil
import components.BlankItemComponent
import components.DailyHealthItemComponent
import components.HorizontalHealthTrackingSummary
import components.MonthlyHealthItemComponent
import components.NoDataDisplayedItemComponent
import components.TimelineButtonComponent
import components.VerticalHealthTrackingSummary
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
        Configuration.DAILY,
        Modifier
            .fillMaxWidth()
            .wrapContentHeight())
}

@Composable
fun DietTrackingConfiguartion(configuration: Configuration, modifier: Modifier) {
    return when(configuration) {
        Configuration.DAILY -> DailyDietTrackingConfiguration(modifier)
        Configuration.WEEKLY -> WeeklyDietTrackingConfiguration(modifier)
        Configuration.MONTHLY-> MonthlyDietTrackingConfiguration(modifier)
    }
}


@Composable
private fun DailyDietTrackingConfiguration(modifier: Modifier) =
    ConstraintLayout(modifier.fillMaxSize()) {
        val (dietTrackingMetricsRef,
            mealTrackingTitleRef,
            mealsRef,
        ) = createRefs()

        DietTrackingMetrics(configuration = Configuration.WEEKLY,
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

        DietTrackingList(mealPlan = listOf(), showAddMore = true, configuration = Configuration.DAILY, modifier = Modifier
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

        DietTrackingMetrics(configuration = Configuration.WEEKLY,
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

        DietTrackingList(mealPlan = listOf(), showAddMore = true, configuration = Configuration.WEEKLY, modifier = Modifier
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

    DietTrackingMetrics(configuration = Configuration.MONTHLY,
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

    DietTrackingList(mealPlan = listOf(), showAddMore = false, configuration = Configuration.MONTHLY, modifier = Modifier
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
private fun DietTrackingMetrics(configuration: Configuration, modifier: Modifier) = ConstraintLayout(modifier = modifier) {
    val (caloriesSummaryRef,
        carbSummaryRef,
        fatSummaryRef,
        proteinSummaryRef,
        dateRef) = createRefs()

    val currentCalories = 1000
    val maxCalories = 18000

    HorizontalHealthTrackingSummary(title = "Calories",
        description = "$currentCalories calories out of $maxCalories",
        true,
        .5f,
        PrimaryBlue,
        modifier = Modifier
            .wrapContentHeight()
            .constrainAs(caloriesSummaryRef) {
                top.linkTo(parent.top, 20.dp)
                start.linkTo(parent.start, 10.dp)
                end.linkTo(proteinSummaryRef.start, 10.dp)
                width = Dimension.fillToConstraints
            })

    val currentCarbs = 1000
    val maxCarbs = 18000

    HorizontalHealthTrackingSummary(title = "Carbohydrates",
        description = "$currentCarbs carbs out of $maxCarbs",
        true,
        .75f,
        PrimaryBlue,
        modifier = Modifier
            .wrapContentHeight()
            .constrainAs(carbSummaryRef) {
                top.linkTo(caloriesSummaryRef.bottom, 20.dp)
                end.linkTo(caloriesSummaryRef.end)
                start.linkTo(caloriesSummaryRef.start)
                width = Dimension.fillToConstraints
            })

    val currentFat = 1000
    val maxFat = 18000

    HorizontalHealthTrackingSummary(title = "Fat",
        description = "$currentFat fat out of $maxFat",
        true,
        .25f,
        PrimaryBlue,
        modifier = Modifier
            .wrapContentHeight()
            .constrainAs(fatSummaryRef) {
                top.linkTo(carbSummaryRef.bottom, 20.dp)
                end.linkTo(caloriesSummaryRef.end)
                start.linkTo(caloriesSummaryRef.start)
                width = Dimension.fillToConstraints
            })

    val currentProtein = 1000
    val maxProtein = 18000

    val startedWeight = 324.0f
    val currentWeight = 278.0f
    val targetWeight = 200.0f


    VerticalHealthTrackingSummary(proteinDesc = "$currentProtein protein out of $maxProtein",
        weightDesc = "${
            ScreenUtil.calculateWeightProgress(
                startedWeight,
                currentWeight,
                targetWeight
            )
        }% towards $targetWeight lb",
        modifier = Modifier
            .width(150.dp)
            .constrainAs(proteinSummaryRef) {
                top.linkTo(caloriesSummaryRef.top)
                bottom.linkTo(fatSummaryRef.bottom)
                start.linkTo(caloriesSummaryRef.end)
                end.linkTo(parent.end, 10.dp)
                height = Dimension.fillToConstraints
            })

    TimelineButtonComponent(configuration = configuration, modifier = Modifier.constrainAs(dateRef) {
        top.linkTo(proteinSummaryRef.bottom, margin = 15.dp)
        start.linkTo(parent.start)
    }){

    }
}

@Composable
private fun DietTrackingList(mealPlan: List<MealItem>, showAddMore: Boolean, configuration: Configuration, modifier: Modifier){

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
private fun AddHealthItem(mealPlan: List<MealItem>, configuration: Configuration) {
    return when(configuration){
        Configuration.DAILY -> DailyHealthItemComponent(mealItem = mealPlan, modifier =  Modifier.padding(10.dp))
        Configuration.WEEKLY -> WeeklyHealthItemComponent(mealItem = mealPlan, modifier = Modifier.padding(10.dp))
        Configuration.MONTHLY-> MonthlyHealthItemComponent(mealItem = mealPlan, modifier =  Modifier.padding(10.dp))
    }
}