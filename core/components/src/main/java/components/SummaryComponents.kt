package components

import androidx.compose.foundation.layout.Arrangement
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
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.constraintlayout.compose.Dimension
import com.fitness.framework.extensions.Dark
import com.fitness.framework.extensions.Light
import com.fitness.shapify.theme.PrimaryBlue
import com.fitness.shapify.theme.ShapifyTheme
import com.fitness.theme.R

enum class Configuration{
    SQUARE,
    SQUARE_DETAILED,
    HORIZONTAL,
    VERTICAL
}

@Composable
fun SummaryComponent(configuration: Configuration) {
    when(configuration){
        Configuration.SQUARE -> SquareHealthSummaryComponent()
        Configuration.SQUARE_DETAILED -> DetailedSummaryComponent()
        Configuration.HORIZONTAL -> HorizontalHealthTrackingSummary()
        Configuration.VERTICAL -> VerticalHealthTrackingSummary()
    }
}

@Light
@Dark
@Composable
fun DetailedSummaryComponent(
    modifier: Modifier = Modifier.size(150.dp),
    icon: Int = R.drawable.icon_sleep,
    title: String = stringResource(id = R.string.sleep),
    data: List<Any> = listOf(),
    graphColor: Color = PrimaryBlue
) {
    ShapifyTheme {
        Card(
            modifier = modifier, elevation = CardDefaults.cardElevation(defaultElevation = 3.0.dp),
            colors = CardDefaults.cardColors()
        ) {
            ConstraintLayout(
                Modifier
                    .padding(10.dp)
                    .fillMaxSize()
            ) {

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
                    modifier = Modifier.constrainAs(titleRef) {
                        top.linkTo(topGuideline)
                        start.linkTo(startGuideline)
                    })

                Column(verticalArrangement = Arrangement.SpaceEvenly, modifier = Modifier
                    .constrainAs(descriptionRef) {
                        top.linkTo(titleRef.bottom)
                        bottom.linkTo(bottomGuideline)
                        start.linkTo(startGuideline)
                        end.linkTo(endGuideline)
                        height = Dimension.fillToConstraints
                        width = Dimension.fillToConstraints
                    }
                ) {
                    repeat(data.size) {
                        Row(
                            verticalAlignment = Alignment.CenterVertically,
                            horizontalArrangement = Arrangement.SpaceBetween,
                            modifier = Modifier
                                .wrapContentHeight()
                                .fillMaxWidth()
                        ) {
//                        Text(text = data[it], fontSize = 11.sp)
//                        LineProgressComponent(progress = data[it].percentage, progressBarColor = graphColor, modifier = Modifier
//                            .width(50.dp)
//                            .wrapContentHeight())
                        }
                    }
                }
            }
        }
    }
}

@Light
@Dark
@Composable
private fun SquareHealthSummaryComponent(
    icon: Int = R.drawable.icon_fire,
    title: String = stringResource(id = R.string.calories),
    description: String = stringResource(id = R.string.calories_consumed_out, 1200f, 1800f),
    progress: Double = .45,
    progressBarColor: Color = PrimaryBlue,
    modifier: Modifier = Modifier.size(150.dp)
) {
    ShapifyTheme {
        Card(
            modifier = modifier, elevation = CardDefaults.cardElevation(defaultElevation = 3.0.dp),
            colors = CardDefaults.cardColors()
        ) {
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

                Text(text = title, fontSize = 18.sp, modifier = Modifier.constrainAs(titleRef) {
                    top.linkTo(topGuideline)
                    bottom.linkTo(descriptionRef.top)
                    start.linkTo(startGuideline)
                })

                Text(text = description,
                    fontSize = 12.sp,
                    fontWeight = FontWeight.Light,
                    modifier = Modifier
                        .padding(start = 10.dp, end = 10.dp)
                        .constrainAs(descriptionRef) {
                            bottom.linkTo(progressRef.top)
                            start.linkTo(startGuideline)
                            end.linkTo(endGuideline)
                        })

                LineProgressComponent(progress = progress,
                    progressBarColor = progressBarColor,
                    modifier = Modifier
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
}

@Light
@Dark
@Composable
private fun HorizontalHealthTrackingSummary(
    modifier: Modifier = Modifier
        .width(400.dp)
        .height(150.dp),
    title: String = stringResource(id = R.string.calories),
    description: String = stringResource(id = R.string.no_data_displayed),
    isDataDisplayed: Boolean = false,
    progress: Double = .90,
    progressBarColor: Color = PrimaryBlue
) {
    ShapifyTheme {
        Card(
            modifier = modifier,
            elevation = CardDefaults.cardElevation(3.dp),
            colors = CardDefaults.cardColors()
        ) {

            Column(
                verticalArrangement = if (isDataDisplayed) Arrangement.SpaceAround else Arrangement.SpaceEvenly,
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
                    textAlign = if (!isDataDisplayed) TextAlign.Center else TextAlign.Start,
                    fontWeight = FontWeight.Light,
                    modifier = Modifier
                        .padding(bottom = 5.dp)
                        .fillMaxWidth()
                )

                LineProgressComponent(
                    progress = if (isDataDisplayed) progress else .5,
                    progressBarColor = progressBarColor,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = 10.dp)
                        .height(10.dp)
                )
            }
        }
    }
}

@Light
@Dark
@Composable
private fun VerticalHealthTrackingSummary(
    modifier: Modifier = Modifier
        .wrapContentHeight()
        .width(150.dp),
    proteinDesc: String = stringResource(id = R.string.protein_consumed_out, 70f, 110f),
    weightDesc: String = stringResource(id = R.string.from_target_weight, 200f, "LB", 190f)
) {
    ShapifyTheme {
        Card(
            modifier = modifier,
            elevation = CardDefaults.cardElevation(3.dp),
            colors = CardDefaults.cardColors()
        ) {
            ConstraintLayout(
                modifier = Modifier
                    .padding(10.dp)
                    .fillMaxWidth()
                    .wrapContentHeight()
            ) {
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

                CircleProgressComponent(false, .75, PrimaryBlue, canvasSize = 200, modifier = Modifier
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

                CircleProgressComponent(false, .25, PrimaryBlue, canvasSize = 200, modifier = Modifier
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
}

