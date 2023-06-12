package components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Arrangement.Center
import androidx.compose.foundation.layout.Arrangement.SpaceAround
import androidx.compose.foundation.layout.Arrangement.SpaceEvenly
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.CenterHorizontally
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.paint
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.constraintlayout.compose.Dimension
import com.fitness.model.enums.Unit
import com.fitness.model.local.DetailedSummaryItem
import com.fitness.model.remote.nutrition.MealItem
import com.fitness.shapify.theme.PrimaryBlue
import com.fitness.theme.R

@Preview
@Composable
private fun HorizontalHealthTrackingSummaryPreview() {
    HorizontalHealthTrackingSummary(
        stringResource(id = R.string.calories),
        stringResource(id = R.string.calories_consumed_out, 1200f, 1800f),
        true,
        .45f,
        PrimaryBlue,
        Modifier
            .width(400.dp)
            .height(150.dp))
}

@Preview
@Composable
private fun HorizontalNoDataDisplayedPreview() {
    HorizontalHealthTrackingSummary(
        stringResource(id = R.string.calories),
        stringResource(id = R.string.no_data_displayed),
        false,
        .45f,
        PrimaryBlue,
        Modifier
            .width(400.dp)
            .height(150.dp))
}

@Preview
@Composable
private fun VerticalHealthTrackingPreview() {
    VerticalHealthTrackingSummary(
        stringResource(id = R.string.protein_consumed_out, 70f, 110f),
        stringResource(id = R.string.from_target_weight, 200f, "LB", 190f),
        modifier = Modifier
            .wrapContentHeight()
            .width(150.dp))
}

@Preview
@Composable
private fun VerticalNoDataDisplayedPreview() {
    VerticalHealthTrackingSummary(
        stringResource(id = R.string.no_data_displayed),
        stringResource(id = R.string.no_data_displayed),
        modifier = Modifier
            .wrapContentHeight()
            .width(150.dp))
}

@Preview
@Composable
private fun SquareHealthSummaryPreview() {
    SquareHealthSummaryComponent(
        R.drawable.icon_fire,
        stringResource(id = R.string.calories),
        stringResource(id = R.string.calories_consumed_out, 1200f, 1800f),
        .45f,
        PrimaryBlue,
        Modifier.size(150.dp)
    )
}

@Preview
@Composable
private fun SquareNoDataDisplayedPreview() {
    SquareHealthSummaryComponent(R.drawable.icon_fire, stringResource(id = R.string.calories),  stringResource(id = R.string.no_data_displayed), .45f, PrimaryBlue, Modifier.size(150.dp))
}

@Preview
@Composable
private fun LongHealthComponentPreview() {
    LongHealthComponent(
        stringResource(id = R.string.todays_workout_plan),
        stringResource(id = R.string.calories_consumed_out, 1200f, 1800f),
        Modifier
            .fillMaxWidth()
            .height(150.dp)
    )
}

@Preview
@Composable
private fun HealthItemComponentPreview() {
    DailyHealthItemComponent(listOf(
        MealItem("Chicken", listOf(), Unit.GRAMS),
        MealItem("Chicken", listOf(), Unit.GRAMS),
        MealItem("Chicken", listOf(), Unit.GRAMS),
    ), Modifier)
}

@Preview
@Composable
private fun WeeklyItemComponentPreview() {
    WeeklyHealthItemComponent(listOf(
        MealItem("Chicken", listOf(), Unit.GRAMS),
        MealItem("Chicken", listOf(), Unit.GRAMS),
        MealItem("Chicken", listOf(), Unit.GRAMS),
    ), Modifier)
}

@Preview
@Composable
private fun MonthlyItemComponentPreview() {
    MonthlyHealthItemComponent(listOf(
        MealItem("Chicken", listOf(), Unit.GRAMS),
        MealItem("Chicken", listOf(), Unit.GRAMS),
        MealItem("Chicken", listOf(), Unit.GRAMS),
    ), Modifier)
}

@Preview
@Composable
private fun BlankItemComponentPreview() {
    BlankItemComponent(Modifier)
}

@Preview
@Composable
private fun NoDataDisplayedItemComponentPreview(){
    NoDataDisplayedItemComponent(Modifier)
}

@Preview
@Composable
private fun SleepSummaryComponentPreview() {
    val data = listOf(
        DetailedSummaryItem("Awake", .66f),
        DetailedSummaryItem("Light", .4f),
        DetailedSummaryItem("Deep", .10f),
        DetailedSummaryItem("Rem", .20f)
    )

    DetailedSummaryComponent(icon = R.drawable.icon_sleep, title = "Sleep", data = data, PrimaryBlue, modifier = Modifier.size(150.dp))
}

@Preview
@Composable
private fun RecoverySummaryComponentPreview() {
    val data = listOf(
        DetailedSummaryItem("Sleep", .34f),
        DetailedSummaryItem("Rest", .65f),
        DetailedSummaryItem("Nutrition", .80f),
        DetailedSummaryItem("Stretch", .70f)
    )

    DetailedSummaryComponent(icon = R.drawable.icon_batttery, title = "Recovery", data = data, PrimaryBlue, modifier = Modifier.size(150.dp))
}

//end of previews


@Composable
fun HorizontalHealthTrackingSummary(
    title: String,
    description: String,
    isDataDisplayed: Boolean,
    progress: Float,
    progressBarColor: Color,
    modifier: Modifier
) {
    Card(
        modifier = modifier,
        elevation = CardDefaults.cardElevation(3.dp),
        colors = CardDefaults.cardColors()
    ) {

        Column(
            verticalArrangement = if(isDataDisplayed) SpaceAround else SpaceEvenly,
            modifier = Modifier
                .padding(10.dp)
                .fillMaxSize()
        ) {
            Text(
                text = title,
                fontWeight = FontWeight.Bold,
                modifier = Modifier.padding(bottom = 5.dp)
            )
            Text(
                text = description,
                textAlign = if(!isDataDisplayed) TextAlign.Center else TextAlign.Start,
                fontWeight = FontWeight.Light,
                modifier = Modifier
                    .padding(bottom = 5.dp)
                    .fillMaxWidth()
            )

            LineProgressComponent(
                progress = if(isDataDisplayed) progress else .5f, progressBarColor = progressBarColor, modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 10.dp)
                    .height(10.dp)
            )
        }
    }
}

@Composable
fun VerticalHealthTrackingSummary(
    proteinDesc: String,
    weightDesc: String,
    modifier: Modifier
) {
    Card(
        modifier = modifier,
        elevation = CardDefaults.cardElevation(3.dp),
        colors = CardDefaults.cardColors()
    ) {
        ConstraintLayout(modifier = Modifier
            .padding(10.dp)
            .fillMaxWidth()
            .wrapContentHeight()) {
            val (proteinTitleRef, proteinRef, proteinDescRef, weightTitleRef, weightRef, weightDescRef) = createRefs()

            Text(
                text = "Protein",
                textAlign = TextAlign.Center,
                modifier = Modifier.constrainAs(proteinTitleRef) {
                    top.linkTo(parent.top)
                    start.linkTo(proteinRef.start, 2.dp)
                    end.linkTo(proteinRef.end, 2.dp)
                    width = Dimension.fillToConstraints
                    height = Dimension.wrapContent
                })

            CircleProgressComponent(false,.75f, PrimaryBlue, canvasSize = 200, modifier = Modifier
                .size(90.dp)
                .constrainAs(proteinRef) {
                    top.linkTo(proteinTitleRef.bottom, 4.dp)
                    start.linkTo(parent.start)
                    end.linkTo(parent.end)
                }
            )

            Text(text = proteinDesc,
                fontSize = 12.sp,
                fontWeight = FontWeight.Light,
                textAlign = TextAlign.Center,
                modifier = Modifier
                    .padding(4.dp)
                    .constrainAs(proteinDescRef) {
                        top.linkTo(proteinRef.top)
                        bottom.linkTo(proteinRef.bottom)
                        start.linkTo(proteinRef.start)
                        end.linkTo(proteinRef.end)
                        width = Dimension.fillToConstraints
                        height = Dimension.wrapContent
                    })

            Text(
                text = "Weight",
                textAlign = TextAlign.Center,
                modifier = Modifier.constrainAs(weightTitleRef) {
                    top.linkTo(proteinRef.bottom, 15.dp)
                    start.linkTo(weightRef.start, 2.dp)
                    end.linkTo(weightRef.end, 2.dp)
                    width = Dimension.fillToConstraints
                    height = Dimension.wrapContent
                })

            CircleProgressComponent(false,.25f, PrimaryBlue, canvasSize = 200, modifier = Modifier
                .size(90.dp)
                .constrainAs(weightRef) {
                    top.linkTo(weightTitleRef.bottom, 4.dp)
                    start.linkTo(parent.start)
                    end.linkTo(parent.end)
                }
            )

            Text(text = weightDesc,
                fontSize = 12.sp,
                fontWeight = FontWeight.Light,
                textAlign = TextAlign.Center,
                modifier = Modifier
                    .padding(4.dp)
                    .constrainAs(weightDescRef) {
                        top.linkTo(weightRef.top)
                        bottom.linkTo(weightRef.bottom)
                        start.linkTo(weightRef.start)
                        end.linkTo(weightRef.end)
                        width = Dimension.fillToConstraints
                        height = Dimension.wrapContent
                    })
        }
    }
}


@Composable
fun SquareHealthSummaryComponent(icon: Int, title: String, description: String, progress: Float, progressBarColor: Color, modifier: Modifier) {
    Card(modifier = modifier, elevation = CardDefaults.cardElevation(defaultElevation = 3.0.dp),
        colors = CardDefaults.cardColors()) {
        ConstraintLayout(Modifier.fillMaxSize()) {

            val startGuideline = createGuidelineFromStart(.1f)
            val endGuideline = createGuidelineFromEnd(.1f)

            val topGuideline = createGuidelineFromTop(.1f)
            val bottomGuideline = createGuidelineFromBottom(.2f)

            val (iconRef, titleRef, descriptionRef, progressRef) = createRefs()

            Icon(painter = painterResource(id = icon), contentDescription = "", modifier = Modifier
                .size(18.dp)
                .constrainAs(iconRef) {
                    end.linkTo(endGuideline)
                    start.linkTo(titleRef.end)
                    top.linkTo(topGuideline)
                    bottom.linkTo(descriptionRef.top)
                })

            Text(text = title, fontSize = 18.sp, modifier = Modifier.constrainAs(titleRef){
                top.linkTo(topGuideline)
                bottom.linkTo(descriptionRef.top)
                start.linkTo(startGuideline)
            })

            Text(text = description, fontSize = 12.sp, fontWeight = FontWeight.Light, modifier = Modifier
                .padding(start = 10.dp, end = 10.dp)
                .constrainAs(descriptionRef) {
                    bottom.linkTo(progressRef.top)
                    start.linkTo(startGuideline)
                    end.linkTo(endGuideline)
                })

            LineProgressComponent(progress = progress, progressBarColor = progressBarColor, modifier = Modifier
                .fillMaxWidth()
                .height(10.dp)
                .padding(start = 10.dp, end = 10.dp, top = 10.dp)
                .constrainAs(progressRef) {

                    bottom.linkTo(bottomGuideline)
                    start.linkTo(startGuideline)
                    end.linkTo(endGuideline)

                })
        }
    }
}

@Composable
fun LongHealthComponent(title: String, description: String, modifier: Modifier) {
    Card(modifier = modifier, elevation = CardDefaults.cardElevation(defaultElevation = 3.0.dp), colors = CardDefaults.cardColors()) {
        ConstraintLayout(
            Modifier
                .fillMaxSize()
        ) {

            val startGuideline = createGuidelineFromStart(.1f)
            val topGuideline = createGuidelineFromTop(.1f)

            val (titleRef, descriptionRef) = createRefs()

            Text(text = title, fontSize = 18.sp, fontWeight = FontWeight.Bold, modifier = Modifier.constrainAs(titleRef){
                top.linkTo(topGuideline)
                bottom.linkTo(descriptionRef.top)
                start.linkTo(startGuideline)
            })

            Text(text = description, fontSize = 12.sp, fontWeight = FontWeight.Normal, modifier = Modifier.constrainAs(descriptionRef) {
                top.linkTo(titleRef.bottom)
                bottom.linkTo(parent.bottom)
                start.linkTo(startGuideline)
            })
        }
    }
}

@Composable
fun DailyHealthItemComponent(mealItem: List<MealItem>, modifier: Modifier) {
    Card(elevation = CardDefaults.cardElevation(3.dp), colors = CardDefaults.cardColors(), modifier = modifier
        .fillMaxWidth()
        .wrapContentHeight()) {
        ConstraintLayout(
            Modifier
                .fillMaxWidth()
                .wrapContentHeight()
                .padding(10.dp)) {
            val (ingredient1Ref, ingredient2Ref, ingredient3Ref, ingredient4Ref, metricsRef, timeRef) = createRefs()

            Row(horizontalArrangement = Arrangement.SpaceBetween, modifier = Modifier
                .padding(10.dp)
                .wrapContentSize()
                .constrainAs(metricsRef) {
                    top.linkTo(parent.top)
                    end.linkTo(parent.end)
                    bottom.linkTo(timeRef.top)
                    start.linkTo(ingredient1Ref.end)
                }
            ) {
                MetricItemComponent(
                    metric = "C",
                    "60g",
                    color = PrimaryBlue,
                    25,
                    Modifier.padding(5.dp)
                )
                MetricItemComponent(
                    metric = "c",
                    "60g",
                    color = PrimaryBlue,
                    25,
                    Modifier.padding(5.dp)
                )

                MetricItemComponent(
                    metric = "f",
                    "60g",
                    color = PrimaryBlue,
                    25,
                    Modifier.padding(5.dp)
                )
                MetricItemComponent(
                    metric = "p",
                    "60g",
                    color = PrimaryBlue,
                    25,
                    Modifier.padding(5.dp)
                )
            }

            Text(
                text = "temporary",
                fontWeight = FontWeight.Light,
                modifier = Modifier
                    .padding(end = 5.dp)
                    .constrainAs(ingredient1Ref) {
                        top.linkTo(parent.top, 5.dp)
                        start.linkTo(parent.start)
                    })

            Text(
                text = "temporary",
                fontWeight = FontWeight.Light,
                modifier = Modifier
                    .padding(end = 5.dp)
                    .constrainAs(ingredient2Ref) {
                        top.linkTo(ingredient1Ref.bottom, 5.dp)
                        start.linkTo(parent.start)
                    })

            Text(
                text = "temporary",
                fontWeight = FontWeight.Light,
                modifier = Modifier
                    .padding(end = 5.dp)
                    .constrainAs(ingredient3Ref) {
                        top.linkTo(ingredient2Ref.bottom, 5.dp)
                        start.linkTo(parent.start)
                    })

            Text(
                text = "...",
                fontWeight = FontWeight.Light,
                modifier = Modifier
                    .padding(end = 5.dp)
                    .constrainAs(ingredient4Ref) {
                        top.linkTo(ingredient3Ref.bottom, 5.dp)
                        start.linkTo(parent.start)
                    })

            Text(
                text = "Scheduled for 8 AM",
                fontWeight = FontWeight.Light,
                modifier = Modifier
                    .padding(end = 5.dp)
                    .constrainAs(timeRef) {
                        bottom.linkTo(parent.bottom)
                        end.linkTo(parent.end)
                    })
        }
    }
}

@Composable
fun WeeklyHealthItemComponent(mealItem: List<MealItem>, modifier: Modifier) {
    Card(elevation = CardDefaults.cardElevation(3.dp),
        colors = CardDefaults.cardColors(),
        modifier = modifier.wrapContentSize()) {
        ConstraintLayout(
            Modifier
                .wrapContentSize()
                .padding(10.dp)) {

            val (dayOfWeekRef, metricsRef) = createRefs()

            Column(modifier = Modifier
                .wrapContentSize()
                .constrainAs(metricsRef) {
                    top.linkTo(parent.top)
                    end.linkTo(parent.end)
                    start.linkTo(dayOfWeekRef.end)
                }
            ) {
                Row(Modifier.padding(5.dp)) {
                    MetricItemComponent(
                        metric = "C",
                        "60g",
                        color = PrimaryBlue,
                        25,
                        Modifier.padding(5.dp)
                    )
                    MetricItemComponent(
                        metric = "c",
                        "60g",
                        color = PrimaryBlue,
                        25,
                        Modifier.padding(5.dp)
                    )
                }

                Row(Modifier.padding(5.dp)) {
                    MetricItemComponent(
                        metric = "f",
                        "60g",
                        color = PrimaryBlue,
                        25,
                        Modifier.padding(5.dp)
                    )
                    MetricItemComponent(
                        metric = "p",
                        "60g",
                        color = PrimaryBlue,
                        25,
                        Modifier.padding(5.dp)
                    )
                }
            }

//            MetricItemComponent(
//                metric = DateTimeUtil.getDayOfWeek(date).substring(0,2),
//                quantity = "",
//                color = NeonBlue035EE8,
//                canvasSize = 25,
//                modifier = Modifier
//                    .padding(10.dp)
//                    .constrainAs(dayOfWeekRef) {
//
//                    }
//            )
        }
    }
}

@Composable
fun MonthlyHealthItemComponent(mealItem: List<MealItem>, modifier: Modifier) {
    Card(elevation = CardDefaults.cardElevation(3.dp), colors = CardDefaults.cardColors(), modifier = modifier
        .wrapContentSize()) {
        ConstraintLayout(
            Modifier
                .fillMaxWidth()
                .wrapContentHeight()
                .padding(10.dp)) {
            val (ingredient1Ref, metricsRef) = createRefs()

            Column(modifier = Modifier
                .padding(10.dp)
                .wrapContentSize()
                .constrainAs(metricsRef) {
                    top.linkTo(parent.top)
                    end.linkTo(parent.end)
                }
            ) {
                Row(Modifier.padding(5.dp)) {
                    MetricItemComponent(
                        metric = "C",
                        "60g",
                        color = PrimaryBlue,
                        25,
                        Modifier.padding(5.dp)
                    )
                    MetricItemComponent(
                        metric = "c",
                        "60g",
                        color = PrimaryBlue,
                        25,
                        Modifier.padding(5.dp)
                    )
                }

                Row(Modifier.padding(5.dp)) {
                    MetricItemComponent(
                        metric = "f",
                        "60g",
                        color = PrimaryBlue,
                        25,
                        Modifier.padding(5.dp)
                    )
                    MetricItemComponent(
                        metric = "p",
                        "60g",
                        color = PrimaryBlue,
                        25,
                        Modifier.padding(5.dp)
                    )
                }
            }

//            val df = SimpleDateFormat("MMM dd yyyy", Locale.getDefault())
//
//            Text(
//                text = "${df.format(weekTimeline[weekTimeline.lastIndex])} -\n ${df.format(weekTimeline[0])}",
//                fontWeight = FontWeight.Light,
//                modifier = Modifier
//                    .padding(end = 5.dp)
//                    .constrainAs(ingredient1Ref) {
//                        top.linkTo(parent.top, 5.dp)
//                        start.linkTo(parent.start)
//                    })
        }
    }
}

@Composable
fun BlankItemComponent(modifier: Modifier) {
    Card(elevation = CardDefaults.cardElevation(3.dp),
        colors = CardDefaults.cardColors(),
        modifier = modifier
            .fillMaxWidth()
            .wrapContentHeight()) {
        Column(verticalArrangement = Center, horizontalAlignment = CenterHorizontally, modifier = Modifier
            .fillMaxWidth()
            .height(125.dp)
            .padding(10.dp)){
            Icon(
                painter = painterResource(id = R.drawable.icon_add_more),
                contentDescription = ""
            )
        }
    }
}

@Composable
fun NoDataDisplayedItemComponent(modifier: Modifier) {
    Card(elevation = CardDefaults.cardElevation(3.dp),
        colors = CardDefaults.cardColors(),
        modifier = modifier
            .fillMaxWidth()
            .wrapContentHeight()) {
        Column(verticalArrangement = Center, horizontalAlignment = CenterHorizontally, modifier = Modifier
            .fillMaxWidth()
            .height(125.dp)
            .padding(10.dp)){
            Text(text = "No Data Displayed")
        }
    }
}



@Composable
fun DetailedSummaryComponent(icon: Int, title: String, data: List<DetailedSummaryItem>, graphColor: Color, modifier: Modifier) {
    Card(modifier = modifier, elevation = CardDefaults.cardElevation(defaultElevation = 3.0.dp),
        colors = CardDefaults.cardColors()) {
        ConstraintLayout(
            Modifier
                .padding(10.dp)
                .fillMaxSize()) {

            val startGuideline = createGuidelineFromStart(.1f)
            val endGuideline = createGuidelineFromEnd(.1f)

            val topGuideline = createGuidelineFromTop(.1f)
            val bottomGuideline = createGuidelineFromBottom(.1f)

            val (iconRef, titleRef, descriptionRef) = createRefs()

            Icon(painter = painterResource(id = icon), contentDescription = "", modifier = Modifier
                .size(18.dp)
                .wrapContentSize()
                .constrainAs(iconRef) {
                    end.linkTo(endGuideline)
                    start.linkTo(titleRef.end)
                    top.linkTo(titleRef.top)
                    bottom.linkTo(titleRef.bottom)
                })

            Text(text = title,
                fontSize = 18.sp,
                modifier = Modifier.constrainAs(titleRef){
                top.linkTo(topGuideline)
                start.linkTo(startGuideline)
            })

            Column(verticalArrangement = SpaceEvenly, modifier = Modifier
                .constrainAs(descriptionRef) {
                    top.linkTo(titleRef.bottom)
                    bottom.linkTo(bottomGuideline)
                    start.linkTo(startGuideline)
                    end.linkTo(endGuideline)
                    height = Dimension.fillToConstraints
                    width = Dimension.fillToConstraints
                }
            ) {
                repeat(data.size){
                    Row(verticalAlignment = Alignment.CenterVertically, horizontalArrangement = Arrangement.SpaceBetween, modifier = Modifier
                        .wrapContentHeight()
                        .fillMaxWidth()) {
                        Text(text = data[it].data, fontSize = 11.sp)
                        LineProgressComponent(progress = data[it].percentage, progressBarColor = graphColor, modifier = Modifier
                            .width(50.dp)
                            .wrapContentHeight())
                    }
                }
            }
        }
    }
}