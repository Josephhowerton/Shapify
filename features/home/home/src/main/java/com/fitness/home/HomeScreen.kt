package com.fitness.home

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Divider
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.constraintlayout.compose.Dimension
import com.fitness.framework.auth.AuthFailure
import com.fitness.framework.extensions.Dark
import com.fitness.framework.extensions.Light
import com.fitness.framework.extensions.cast
import com.fitness.framework.state.BaseViewState
import com.fitness.home.viewmodel.HomeEvent
import com.fitness.home.viewmodel.HomeState
import com.fitness.shapify.theme.PrimaryBlue
import com.fitness.shapify.theme.PrimaryWhite
import com.fitness.shapify.theme.ShapifyTheme
import com.fitness.shapify.util.DateTimeUtil
import com.fitness.theme.R
import components.DetailedSummaryComponent
import components.HealthSummaryComponent
import components.HealthSummaryConfiguration
import components.LongHealthComponent
import components.WeightProgressComponent
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import widget.EmptyScreen
import widget.ErrorScreen
import widget.LoadingScreen
import java.text.SimpleDateFormat
import java.util.Calendar
import java.util.Locale

@Dark
@Light
@Composable
private fun HomeScreenPreview() {
    ShapifyTheme {
        Surface {
            HomeContent ()
        }
    }
}

@Composable
fun HomeScreen(
    state: StateFlow<BaseViewState<HomeState>> = MutableStateFlow(BaseViewState.Empty),
    onErrorEvent: (AuthFailure) -> Unit = {},
    onTriggerEvent: (HomeEvent) -> Unit = {}
) {
    val uiState by state.collectAsState()

    when (uiState) {
        is BaseViewState.Empty -> {
            EmptyScreen()
        }

        is BaseViewState.Data -> {
            HomeContent(
//                uiState = uiState.cast<BaseViewState.Data<HomeState>>().value,
//                onTriggerEvent
            )
        }

        is BaseViewState.Error -> {
            val failure = uiState.cast<BaseViewState.Error>().throwable as AuthFailure

            ErrorScreen(title = failure.title, description = failure.description) {
                onErrorEvent(failure)
            }
        }

        is BaseViewState.Loading -> {
            LoadingScreen()
        }

        is BaseViewState.Complete -> {}
    }
}

@Composable
fun HomeContent(
//    uiState: HomeState,
//    onTriggerEvent: (HomeEvent) -> Unit = {}
) = Column(Modifier.verticalScroll(state = rememberScrollState())) {

    ConstraintLayout(Modifier.fillMaxSize()) {
        val midGuideline = createGuidelineFromTop(.4f)
        val (titleRef, weightProgressRef, weightMetricsRef) = createRefs()
        val (subtitleRef, dateRef, dividerRef, stepsRef, waterRef, caloriesInRef, caloriesBurnRef, workoutPlanRef, dietPlanRef, sleepRef, bodyBatteryRef) = createRefs()

        Text(
            text = stringResource(R.string.activity),
            fontSize = 48.sp,
            modifier = Modifier.constrainAs(titleRef) {
                top.linkTo(parent.top)
                start.linkTo(parent.start, margin = 15.dp)
            }
        )

        val startedWeight = 278.0
        val currentWeight = 288.0
        val targetWeight = 290.0

        WeightProgressComponent(
            startedWeight = startedWeight,
            currentWeight = currentWeight,
            targetWeight = targetWeight,
            modifier = Modifier.constrainAs(weightProgressRef) {
                top.linkTo(titleRef.bottom, 4.dp)
                bottom.linkTo(subtitleRef.top)
                start.linkTo(parent.start)
                end.linkTo(parent.end)
            }
        )

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

        HealthSummaryComponent(configuration = HealthSummaryConfiguration.SQUARE, modifier = Modifier
            .width(150.dp)
            .height(150.dp)
            .constrainAs(stepsRef) {
                top.linkTo(midGuideline, margin = 40.dp)
                start.linkTo(parent.start)
                end.linkTo(waterRef.start)
            }
        )

        HealthSummaryComponent(configuration = HealthSummaryConfiguration.SQUARE, modifier = Modifier
                .width(150.dp)
                .height(150.dp)
                .constrainAs(waterRef) {
                    top.linkTo(midGuideline, margin = 40.dp)
                    start.linkTo(stepsRef.end)
                    end.linkTo(parent.end)
                }
        )

        HealthSummaryComponent(configuration = HealthSummaryConfiguration.SQUARE, modifier = Modifier
                .width(150.dp)
                .height(150.dp)
                .constrainAs(caloriesInRef) {
                    top.linkTo(waterRef.bottom, margin = 40.dp)
                    start.linkTo(parent.start)
                    end.linkTo(caloriesBurnRef.start)
                }
        )

        HealthSummaryComponent(configuration = HealthSummaryConfiguration.SQUARE, modifier = Modifier
                .width(150.dp)
                .height(150.dp)
                .constrainAs(caloriesBurnRef) {
                    top.linkTo(waterRef.bottom, margin = 40.dp)
                    start.linkTo(stepsRef.end)
                    end.linkTo(parent.end)
                }
        )

        DetailedSummaryComponent(icon = R.drawable.icon_sleep,
            title = "Sleep",
            data = listOf(),
            graphColor = PrimaryBlue,
            modifier = Modifier
                .size(150.dp)
                .constrainAs(sleepRef) {
                    top.linkTo(caloriesInRef.bottom, margin = 40.dp)
                    start.linkTo(parent.start)
                    end.linkTo(caloriesBurnRef.start)
                }
        )

        DetailedSummaryComponent(icon = R.drawable.icon_batttery,
            title = "Recovery",
            data = listOf(),
            graphColor = PrimaryBlue,
            modifier = Modifier
                .size(150.dp)
                .constrainAs(bodyBatteryRef) {
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