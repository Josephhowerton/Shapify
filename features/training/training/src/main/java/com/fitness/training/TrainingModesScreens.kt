package com.fitness.training

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.constraintlayout.compose.Dimension
import com.fitness.shapify.theme.DarkBlack
import com.fitness.shapify.theme.DarkerBlack
import com.fitness.shapify.theme.PrimaryBlue
import com.fitness.shapify.theme.ShapifyTheme
import com.fitness.shapify.theme.PrimaryWhite
import com.fitness.theme.R
import com.google.android.gms.maps.model.CameraPosition
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MapStyleOptions
import com.google.android.gms.maps.model.RoundCap
import com.google.android.gms.maps.model.SquareCap
import com.google.maps.android.compose.CameraPositionState
import com.google.maps.android.compose.Circle
import com.google.maps.android.compose.GoogleMap
import com.google.maps.android.compose.MapProperties
import com.google.maps.android.compose.MapUiSettings
import com.google.maps.android.compose.Polyline
import com.google.maps.android.compose.rememberCameraPositionState
import components.CircleProgressComponent
import components.HorizontalHealthTrackingSummary
import components.TimerComponent
import components.TimerComponentData

@Preview
@Composable
private fun IntervalScreenPreview(){
    IntervalModeScreen()
}

@Preview
@Composable
private fun RunningModeScreenPreview(){
    RunningModeScreen()
}

@Preview
@Composable
private fun StrengthTrainingModeScreenPreview(){
    StrengthTrainingModeScreen()
}

@Preview
@Composable
private fun FinishSetButtonPreview(){
    FinishSetButton(PrimaryBlue, Modifier.size(100.dp))
}

@Composable
fun IntervalModeScreen() = ShapifyTheme {
    ConstraintLayout(modifier = Modifier.fillMaxSize()) {

        val workOuts = listOf(
            TimerComponentData("Bench Press",5L),
            TimerComponentData("Rest",10L),
            TimerComponentData("Jump Rope",3L),
            TimerComponentData("Rest",10L)
        )

        var nextWorkOut by remember {
            mutableStateOf(workOuts[1].workOut)
        }

        val midGuideline = createGuidelineFromTop(.6f)
        val topGuideline = createGuidelineFromTop(.1f)
        val bottomGuideline = createGuidelineFromTop(.75f)
        val (timerRef, caloriesRef, nextWorkOutRef, nextWorkOutImageRef) = createRefs()

        TimerComponent(workOuts, color = PrimaryBlue, Modifier.constrainAs(timerRef){
            start.linkTo(parent.start)
            end.linkTo(parent.end)
            top.linkTo(topGuideline)
        }) {
            nextWorkOut = if((it + 1) > workOuts.lastIndex){
                "Complete"
            } else{
                workOuts[it+1].workOut
            }
        }

        val currentCalories = 1000
        val maxCalories = 18000

        HorizontalHealthTrackingSummary(
            title = "Calories Burned",
            description = "$currentCalories calories out of $maxCalories",
            isDataDisplayed = true,
            progress = 500f/700f,
            progressBarColor = PrimaryBlue,
            modifier = Modifier.constrainAs(caloriesRef){
                start.linkTo(parent.start, 40.dp)
                end.linkTo(parent.end, 40.dp)
                bottom.linkTo(midGuideline)
                width = Dimension.fillToConstraints
            }
        )

        Text(text = "Next up: $nextWorkOut",
            fontWeight = FontWeight.Light,
            fontSize = 18.sp,
            color = PrimaryWhite,
            modifier = Modifier.constrainAs(nextWorkOutRef){
                start.linkTo(parent.start, 20.dp)
                top.linkTo(bottomGuideline)
            }
        )

//        Image(painter = painterResource(id = R.drawable.pexels_li_sun_2294361),
//            contentDescription = "",
//            contentScale = ContentScale.Crop,
//            modifier = Modifier.constrainAs(nextWorkOutImageRef){
//                top.linkTo(nextWorkOutRef.bottom, 10.dp)
//                start.linkTo(parent.start)
//                end.linkTo(parent.end)
//                bottom.linkTo(parent.bottom)
//                width = Dimension.fillToConstraints
//                height = Dimension.fillToConstraints
//            }
//        )

    }
}

@Composable
fun RunningModeScreen() = Box(modifier = Modifier.fillMaxSize()) {

    val singapore = LatLng(40.732610, -73.938242)
    val cameraPositionState: CameraPositionState = rememberCameraPositionState {
        position = CameraPosition.fromLatLngZoom(singapore, 15f)
    }

    GoogleMap(modifier = Modifier
        .fillMaxSize()
        .padding(bottom = 300.dp),
        cameraPositionState = cameraPositionState,
        contentPadding = PaddingValues(start = 0.dp, end = 0.dp, bottom = 600.dp, top = 0.dp),
        properties = MapProperties(mapStyleOptions = MapStyleOptions.loadRawResourceStyle(LocalContext.current, R.raw.google_map_style)),
        uiSettings = MapUiSettings(
        compassEnabled = false,
        indoorLevelPickerEnabled = false,
        mapToolbarEnabled = false,
        myLocationButtonEnabled = false,
        rotationGesturesEnabled = false,
        scrollGesturesEnabled = false,
        scrollGesturesEnabledDuringRotateOrZoom = false,
        tiltGesturesEnabled = false,
        zoomControlsEnabled = false,
        zoomGesturesEnabled = false,
    )) {
        Circle(center = LatLng(40.732610, -73.938242), radius = 10.0, fillColor = PrimaryBlue, strokeColor = PrimaryBlue)

        Polyline(
            startCap = SquareCap(),
            endCap = RoundCap(),
            points = listOf(
                LatLng(40.730610, -73.935242),
                LatLng(40.730610, -73.936242),
                LatLng(40.731610, -73.936242),
                LatLng(40.731610, -73.937242),
                LatLng(40.732610, -73.937242),
                LatLng(40.732610, -73.938242)
            ),
            color = PrimaryBlue
        )
    }

    ConstraintLayout(modifier = Modifier
        .background(
            Brush.verticalGradient(
                listOf(
                    Color.Transparent,
                    DarkBlack,
                    DarkBlack
                )
            )
        )
        .fillMaxSize()) {
        val midGuidelineHorizontal = createGuidelineFromTop(.6f)
        val bottomGuidelineHorizontal = createGuidelineFromBottom(.1f)
        val midGuidelineVertical = createGuidelineFromStart(.5f)
        val (durationRef, distanceTitleRef, distanceRef, distanceValueRef, caloriesBurnedTitleRef, caloriesBurnedRef, caloriesValueRef) = createRefs()

        Text(text = "24:02", color = PrimaryWhite, fontSize = 36.sp, modifier = Modifier.constrainAs(durationRef) {
            bottom.linkTo(midGuidelineHorizontal, 10.dp)
            start.linkTo(parent.start)
            end.linkTo(parent.end)
        })

        Text(text = "Calories", color = PrimaryWhite, fontSize = 18.sp, modifier = Modifier.constrainAs(caloriesBurnedTitleRef) {
            start.linkTo(parent.start)
            end.linkTo(midGuidelineVertical)
            bottom.linkTo(caloriesBurnedRef.top, 10.dp)
        })

        CircleProgressComponent(false, progress = 1f, progressColor = PrimaryBlue, canvasSize = 100, modifier = Modifier.constrainAs(caloriesBurnedRef){
            start.linkTo(caloriesBurnedTitleRef.start)
            end.linkTo(caloriesBurnedTitleRef.end)
            bottom.linkTo(bottomGuidelineHorizontal)
        })

        Text(text = "240g", color = PrimaryWhite, fontSize = 18.sp, modifier = Modifier.constrainAs(caloriesValueRef) {
            start.linkTo(caloriesBurnedRef.start)
            end.linkTo(caloriesBurnedRef.end)
            top.linkTo(caloriesBurnedRef.top)
            bottom.linkTo(caloriesBurnedRef.bottom)
        })

        Text(text = "Distance", color = PrimaryWhite, fontSize = 18.sp, modifier = Modifier.constrainAs(distanceTitleRef) {
            end.linkTo(parent.end)
            start.linkTo(midGuidelineVertical)
            bottom.linkTo(distanceRef.top, 10.dp)
        })

        CircleProgressComponent(false, progress = 1f, progressColor = PrimaryBlue, canvasSize = 100, modifier = Modifier.constrainAs(distanceRef){
            start.linkTo(distanceTitleRef.start)
            end.linkTo(distanceTitleRef.end)
            bottom.linkTo(bottomGuidelineHorizontal)
        })

        Text(text = "3.1 Miles", color = PrimaryWhite, fontSize = 18.sp, modifier = Modifier.constrainAs(distanceValueRef) {
            start.linkTo(distanceRef.start)
            end.linkTo(distanceRef.end)
            top.linkTo(distanceRef.top)
            bottom.linkTo(distanceRef.bottom)
        })
    }

}

@Composable
fun StrengthTrainingModeScreen() = Box(modifier = Modifier.fillMaxSize()) {

//    Image(painter = painterResource(id = R.drawable.pexels_cottonbro_studio_4752861), alpha = .5f, contentScale = ContentScale.Crop, contentDescription = "")
    ConstraintLayout(modifier = Modifier
        .background(Brush.verticalGradient(listOf(Color.Transparent, DarkBlack, DarkerBlack)))
        .fillMaxSize()) {
        val topGuideLine = createGuidelineFromTop(.1f)
        val midGuidelineHorizontal = createGuidelineFromTop(.5f)
        val startGuidelineVertical = createGuidelineFromStart(.1f)
        val midGuidelineVertical = createGuidelineFromStart(.5f)
        val (workOutTitleRef, numberOfSetsRef, numberOfSetsValueRef, numberOfRepsRef, numberOfRepsValueRef, durationRef, nextSetButtonRef, caloriesBurnedTitleRef, caloriesBurnedRef, caloriesValueRef, nextWorkOutTitleRef) = createRefs()

        Text(text = "Bench Press", color = PrimaryWhite, fontSize = 36.sp, modifier = Modifier.constrainAs(workOutTitleRef) {
            top.linkTo(topGuideLine)
            start.linkTo(startGuidelineVertical)
        })

        Text(text = "Sets Remaining", color = PrimaryWhite, fontSize = 24.sp, modifier = Modifier.constrainAs(numberOfSetsRef) {
            top.linkTo(workOutTitleRef.bottom, 15.dp)
            start.linkTo(startGuidelineVertical)
        })

        Text(text = "4", color = PrimaryWhite, fontSize = 20.sp, modifier = Modifier.constrainAs(numberOfSetsValueRef) {
            top.linkTo(numberOfSetsRef.bottom, 5.dp)
            start.linkTo(startGuidelineVertical)
        })

        Text(text = "Reps", color = PrimaryWhite, fontSize = 24.sp, modifier = Modifier.constrainAs(numberOfRepsRef) {
            top.linkTo(numberOfSetsValueRef.bottom, 25.dp)
            start.linkTo(startGuidelineVertical)
        })

        Text(text = "10", color = PrimaryWhite, fontSize = 20.sp, modifier = Modifier.constrainAs(numberOfRepsValueRef) {
            top.linkTo(numberOfRepsRef.bottom, 5.dp)
            start.linkTo(startGuidelineVertical)
        })

        Text(text = "24:02", color = PrimaryWhite, fontSize = 28.sp, modifier = Modifier.constrainAs(durationRef) {
            bottom.linkTo(caloriesBurnedTitleRef.top, 10.dp)
            start.linkTo(parent.start)
            end.linkTo(parent.end)
        })

        Text(text = "Calories", color = PrimaryWhite, fontSize = 18.sp, modifier = Modifier.constrainAs(caloriesBurnedTitleRef) {
            start.linkTo(parent.start)
            end.linkTo(midGuidelineVertical)
            top.linkTo(midGuidelineHorizontal)
        })

        CircleProgressComponent(false, progress = 1f, progressColor = PrimaryBlue, canvasSize = 100, modifier = Modifier.constrainAs(caloriesBurnedRef){
            start.linkTo(caloriesBurnedTitleRef.start)
            end.linkTo(caloriesBurnedTitleRef.end)
            top.linkTo(caloriesBurnedTitleRef.bottom, 10.dp)
        })

        Text(text = "240g", color = PrimaryWhite, fontSize = 18.sp, modifier = Modifier.constrainAs(caloriesValueRef) {
            start.linkTo(caloriesBurnedRef.start)
            end.linkTo(caloriesBurnedRef.end)
            top.linkTo(caloriesBurnedRef.top)
            bottom.linkTo(caloriesBurnedRef.bottom)
        })


        FinishSetButton(color = PrimaryBlue, modifier = Modifier
            .size(100.dp)
            .constrainAs(nextSetButtonRef) {
                start.linkTo(midGuidelineVertical)
                end.linkTo(parent.end)
                top.linkTo(caloriesBurnedRef.top)
                bottom.linkTo(caloriesBurnedRef.bottom)
            })

        Text(text = "Next up: Dumbbell Press", fontWeight = FontWeight.Light, fontSize = 18.sp, color = PrimaryWhite, modifier = Modifier.constrainAs(nextWorkOutTitleRef){
            start.linkTo(startGuidelineVertical)
            top.linkTo(caloriesBurnedRef.bottom, 75.dp)
        })
    }
}

@Composable
private fun FinishSetButton(color: Color, modifier: Modifier) = Card(
    colors =  CardDefaults.cardColors(containerColor = color, contentColor = PrimaryWhite),
    shape = RoundedCornerShape(50),
    elevation = CardDefaults.cardElevation(3.dp),
    modifier = modifier
) {
    Box(contentAlignment = Alignment.Center, modifier = Modifier.fillMaxSize()) {
        Text(text = "Finish Set", color = PrimaryWhite, fontSize = 18.sp)
    }
}