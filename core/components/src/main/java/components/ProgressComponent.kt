package components

import androidx.compose.animation.core.Animatable
import androidx.compose.animation.core.FastOutLinearInEasing
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.Dimension
import com.fitness.framework.extensions.Dark
import com.fitness.framework.extensions.Light
import com.fitness.shapify.theme.DarkerBlack
import com.fitness.shapify.theme.PrimaryBlue
import com.fitness.shapify.theme.PrimaryWhite
import com.fitness.shapify.theme.ShapifyTheme
import com.fitness.theme.R
import util.ScreenUtil

@Light
@Dark
@Composable
private fun CircleProgressPreview() {
    ShapifyTheme {
        Surface {
            CircleProgressComponent()
        }
    }
}

@Light
@Dark
@Composable
private fun WeightProgressPreview() {
    ShapifyTheme {
        Surface {
            WeightProgressComponent()
        }
    }
}

@Light
@Dark
@Composable
private fun LineProgressPreview() {
    ShapifyTheme {
        Surface {
            LineProgressComponent()
        }
    }
}


@Composable
fun CircleProgressComponent(
    modifier: Modifier = Modifier,
    isTimer: Boolean = false,
    progress: Double = .25,
    progressColor: Color = PrimaryBlue,
    canvasSize: Int = 200,
    isDarkTheme: Boolean = isSystemInDarkTheme()
) {

    Column(
        modifier = modifier
            .wrapContentSize()
            .padding(2.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {


        val sweepAngleFormula = if (isTimer) (360 - (360f * progress)) else (360 * progress)
        val animateFloat by remember { mutableStateOf(Animatable(0f)) }

        LaunchedEffect(animateFloat) {
            animateFloat.animateTo(
                targetValue = sweepAngleFormula.toFloat(),
                animationSpec = tween(durationMillis = 1000, easing = FastOutLinearInEasing)
            )
        }

        Canvas(modifier = Modifier.size(canvasSize.dp)) {
            drawArc(
                color = if (isDarkTheme) PrimaryWhite else DarkerBlack,
                startAngle = 0f,
                sweepAngle = 360f,
                useCenter = false,
                alpha = .50f,
                style = Stroke(width = 4f, cap = StrokeCap.Round)
            )


            drawArc(
                color = progressColor,
                startAngle = -90f,
                sweepAngle = animateFloat.value,
                useCenter = false,
                style = Stroke(width = 10f, cap = StrokeCap.Round)
            )
        }
    }
}

@Composable
fun WeightProgressComponent(
    modifier: Modifier = Modifier,
    startedWeight: Double = 278.0,
    currentWeight: Double = 288.0,
    targetWeight: Double = 290.0
) {

    val weightProgress = ScreenUtil.calculateWeightProgressAsFraction(startedWeight, currentWeight, targetWeight)

    Column(horizontalAlignment = Alignment.CenterHorizontally, modifier = modifier.wrapContentSize()) {
        Box(contentAlignment = Alignment.Center, modifier = Modifier.size(150.dp)) {
            CircleProgressComponent(
                isTimer = false,
                progress = weightProgress,
                progressColor = if (ScreenUtil.isOnTrack(
                        startedWeight,
                        currentWeight,
                        targetWeight
                    )
                ) PrimaryBlue else Color.Red,
                canvasSize = 200,
                modifier = Modifier.size(150.dp)
            )

            Text(
                text = "${
                    ScreenUtil.formatWeightProgress(
                        startedWeight,
                        currentWeight,
                        targetWeight
                    )
                } target weight",
                fontSize = 18.sp,
                textAlign = TextAlign.Center,
                modifier = Modifier
                    .padding(2.dp)
                    .width(150.dp)
            )
        }

        Spacer(modifier = modifier.size(15.dp))

        Text(
            text = stringResource(id = R.string.target_weight_desc, targetWeight),
            fontSize = 14.sp,
            textAlign = TextAlign.Center
        )
    }
}

@Composable
fun LineProgressComponent(
    modifier: Modifier = Modifier,
    progress: Double = .45,
    progressBarColor: Color = PrimaryBlue,
    isDarkTheme: Boolean = isSystemInDarkTheme()
) {
    Column(
        verticalArrangement = Arrangement.Center,
        modifier = modifier
            .fillMaxWidth()
            .height(5.dp)
    ) {

        val animateFloat by remember { mutableStateOf(Animatable(0f)) }
        LaunchedEffect(animateFloat) {
            animateFloat.animateTo(
                targetValue = progress.toFloat(),
                animationSpec = tween(durationMillis = 1000, easing = FastOutLinearInEasing)
            )
        }

        Canvas(modifier = Modifier.fillMaxWidth()) {
            drawLine(
                start = Offset(x = 0f, y = 1f),
                end = Offset(x = size.width, y = 1f),
                color = if (isDarkTheme) PrimaryWhite else DarkerBlack,
                strokeWidth = 4f,
                alpha = .5f,
                cap = StrokeCap.Round,

                )

            drawLine(
                start = Offset(x = 0f, y = 0f),
                end = Offset(x = (size.width * animateFloat.value), y = 0f),
                color = progressBarColor,
                strokeWidth = 8f,
                cap = StrokeCap.Round
            )
        }
    }
}
