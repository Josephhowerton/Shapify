package com.fitness.home.com

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Divider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.constraintlayout.compose.Dimension
import com.fitness.model.local.DetailedSummaryItem
import com.fitness.shapify.theme.PrimaryBlue
import com.fitness.shapify.theme.PrimaryWhite
import com.fitness.shapify.theme.ShapifyTheme
import com.fitness.shapify.util.DateTimeUtil
import com.fitness.shapify.util.ScreenUtil
import com.fitness.theme.R
import components.CircleProgressComponent
import components.DetailedSummaryComponent
import components.LongHealthComponent
import components.SquareHealthSummaryComponent
import java.text.SimpleDateFormat
import java.util.Calendar
import java.util.Locale


@Preview(showBackground = true)
@Composable
private fun HomeScreenPreview() {
    ShapifyTheme {
        HomeScreen()
    }
}

@Composable
fun HomeScreen() = Column(Modifier.verticalScroll(state = rememberScrollState())) {

    ConstraintLayout(Modifier.fillMaxSize()) {
        val midGuideline = createGuidelineFromTop(.4f)
        val (titleRef, weightProgressRef, weightDescRef, weightMetricsRef) = createRefs()
        val (subtitleRef, dateRef, dividerRef, stepsRef, waterRef, caloriesInRef, caloriesBurnRef, workoutPlanRef, dietPlanRef, sleepRef, bodyBatteryRef) = createRefs()

        Text(
            text = "Activity",
            fontSize = 48.sp,
            modifier = Modifier.constrainAs(titleRef) {
                top.linkTo(parent.top)
                start.linkTo(parent.start, margin = 15.dp)
            }
        )

        val startedWeight = 278.0f
        val currentWeight = 288.0f
        val targetWeight = 290.0f
        val weightProgress = ScreenUtil.calculateWeightProgressAsFraction(startedWeight, currentWeight, targetWeight)

        CircleProgressComponent(false, weightProgress, if(ScreenUtil.isOnTrack(startedWeight, currentWeight, targetWeight)) PrimaryBlue else Color.Red, canvasSize = 200, modifier = Modifier
            .size(150.dp)
            .constrainAs(weightProgressRef) {
                top.linkTo(titleRef.bottom, 4.dp)
                bottom.linkTo(subtitleRef.top)
                start.linkTo(parent.start)
                end.linkTo(parent.end)
            }
        )

        Text(
            text = "${ScreenUtil.formatWeightProgress(startedWeight, currentWeight, targetWeight)} target weight",
            fontSize = 18.sp,
            textAlign = TextAlign.Center,
            modifier = Modifier.padding(2.dp).constrainAs(weightDescRef) {
                top.linkTo(weightProgressRef.top)
                bottom.linkTo(weightProgressRef.bottom)
                start.linkTo(weightProgressRef.start)
                end.linkTo(weightProgressRef.end)
                width = Dimension.fillToConstraints
            }
        )

        Row(horizontalArrangement = Arrangement.SpaceEvenly, modifier = Modifier.padding(15.dp).constrainAs(weightMetricsRef) {
            top.linkTo(weightProgressRef.bottom)
            start.linkTo(parent.start)
            end.linkTo(parent.end)
            width = Dimension.fillToConstraints
        }) {

            Text(
                text = "Target: $targetWeight",
                fontSize = 14.sp,
                textAlign = TextAlign.Center,
                modifier = Modifier.padding(2.dp)
            )
        }

        Text(
            text = "Today",
            fontSize = 18.sp,
            modifier = Modifier.constrainAs(subtitleRef) {
                bottom.linkTo(dateRef.top)
                start.linkTo(parent.start, margin = 15.dp)
            }
        )

        val df = SimpleDateFormat("MMM dd yyyy", Locale.getDefault())
        val date = Calendar.getInstance().time

        Text(text = "${DateTimeUtil.getDayOfWeek(date = date)}, ${df.format(DateTimeUtil.getCurrentDate())}",
            fontSize = 18.sp,
            fontWeight = FontWeight.Light,
            modifier = Modifier.constrainAs(dateRef) {
                bottom.linkTo(dividerRef.top, margin = 15.dp)
                start.linkTo(parent.start, margin = 15.dp)
            }
        )


        Divider(
            color = PrimaryWhite,
            modifier = Modifier
                .fillMaxWidth()
                .height(1.dp)
                .padding(start = 10.dp, end = 10.dp)
                .constrainAs(dividerRef) {
                    bottom.linkTo(midGuideline)
                    start.linkTo(parent.start)
                    end.linkTo(parent.end)
                }
        )

        val currentSteps = 1000
        val totalSteps = 18000

        SquareHealthSummaryComponent(R.drawable.icon_steps,"Steps",
            "$currentSteps steps out of $totalSteps",
            (currentSteps.toFloat()/totalSteps.toFloat()),
            PrimaryBlue,
            Modifier
                .width(150.dp)
                .height(150.dp)
                .constrainAs(stepsRef) {
                    top.linkTo(midGuideline, margin = 40.dp)
                    start.linkTo(parent.start)
                    end.linkTo(waterRef.start)
                }
        )

        val currentLiterWater = 50
        val totalLiterWater = 150

        SquareHealthSummaryComponent(R.drawable.icon_water,"Water",
            "$currentLiterWater liters of water out of $totalLiterWater",
            (currentLiterWater.toFloat()/totalLiterWater.toFloat()),
            PrimaryBlue,
            Modifier
                .width(150.dp)
                .height(150.dp)
                .constrainAs(waterRef) {
                    top.linkTo(midGuideline, margin = 40.dp)
                    start.linkTo(stepsRef.end)
                    end.linkTo(parent.end)
                }
        )

        val currentCaloriesIn = 1200
        val maxCaloriesIn = 1800

        SquareHealthSummaryComponent(R.drawable.icon_food,"Intake",
            "$currentCaloriesIn calories consumed out of $maxCaloriesIn",
            (currentCaloriesIn.toFloat()/maxCaloriesIn.toFloat()),
            PrimaryBlue,
            Modifier
                .width(150.dp)
                .height(150.dp)
                .constrainAs(caloriesInRef) {
                    top.linkTo(waterRef.bottom, margin = 40.dp)
                    start.linkTo(parent.start)
                    end.linkTo(caloriesBurnRef.start)
                }
        )

        val currentCaloriesBurned = 700
        val targetCaloriesBurned = 1200

        SquareHealthSummaryComponent(R.drawable.icon_fire,"Activity",
            "$currentCaloriesBurned calories burned out of $targetCaloriesBurned",
            (currentCaloriesBurned.toFloat()/targetCaloriesBurned.toFloat()),
            PrimaryBlue,
            Modifier
                .width(150.dp)
                .height(150.dp)
                .constrainAs(caloriesBurnRef) {
                    top.linkTo(waterRef.bottom, margin = 40.dp)
                    start.linkTo(stepsRef.end)
                    end.linkTo(parent.end)
                }
        )

        val sleep = listOf(
            DetailedSummaryItem("Awake", .66f),
            DetailedSummaryItem("Light", .4f),
            DetailedSummaryItem("Deep", .10f),
            DetailedSummaryItem("Rem", .20f)
        )

        DetailedSummaryComponent(icon = R.drawable.icon_sleep,
            title = "Sleep",
            data = sleep,
            graphColor = PrimaryBlue,
            modifier = Modifier.size(150.dp).constrainAs(sleepRef) {
                top.linkTo(caloriesInRef.bottom, margin = 40.dp)
                start.linkTo(parent.start)
                end.linkTo(caloriesBurnRef.start)
            }
        )

        val recovery = listOf(
            DetailedSummaryItem("Sleep", .34f),
            DetailedSummaryItem("Rest", .65f),
            DetailedSummaryItem("Calories", .80f),
            DetailedSummaryItem("Other", .70f)
        )

        DetailedSummaryComponent(icon = R.drawable.icon_batttery,
            title = "Recovery",
            data = recovery,
            graphColor = PrimaryBlue,
            modifier = Modifier.size(150.dp).constrainAs(bodyBatteryRef) {
                top.linkTo(caloriesBurnRef.bottom, margin = 40.dp)
                start.linkTo(stepsRef.end)
                end.linkTo(parent.end)
            }
        )

        LongHealthComponent(
            title = "Today's Workout Plan",
            description = "Weightlifting at 6pm",
            modifier = Modifier
                .height(150.dp)
                .constrainAs(workoutPlanRef) {
                    top.linkTo(sleepRef.bottom, margin = 40.dp)
                    start.linkTo(caloriesInRef.start)
                    end.linkTo(caloriesBurnRef.end)
                    width = Dimension.fillToConstraints
                }
        )

        LongHealthComponent(
            title = "Today's Diet Plan",
            description = "Your next meal at 1 pm is Hummus and celery",
            modifier = Modifier
                .height(150.dp)
                .constrainAs(dietPlanRef) {
                    top.linkTo(workoutPlanRef.bottom, margin = 40.dp)
                    start.linkTo(workoutPlanRef.start)
                    end.linkTo(workoutPlanRef.end)
                    bottom.linkTo(parent.bottom, margin = 40.dp)
                    width = Dimension.fillToConstraints
                }
        )
    }
}

