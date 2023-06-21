package components

import androidx.compose.animation.core.Animatable
import androidx.compose.animation.core.FastOutLinearInEasing
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentSize
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
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.fitness.framework.extensions.Dark
import com.fitness.framework.extensions.Light
import com.fitness.shapify.theme.PrimaryBlue
import com.fitness.shapify.theme.PrimaryWhite
import util.ScreenUtil

@Preview(showBackground = true)
@Composable
private fun CircleProgressComponentPreview() {
    CircleProgressComponent(false, .25, PrimaryBlue, 200, Modifier)
}

@Preview(showBackground = true)
@Composable
private fun LineProgressComponentPreview() {
    Column(verticalArrangement = Arrangement.Center) {
        LineProgressComponent(
            progress = .45, PrimaryBlue,
            Modifier
                .fillMaxWidth()
                .height(20.dp)
        )
    }
}

@Composable
fun CircleProgressComponent(
    isTimer: Boolean,
    progress: Double,
    progressColor: Color,
    canvasSize: Int,
    modifier: Modifier
) = Column(
    modifier = modifier.wrapContentSize(),
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
            color = PrimaryWhite,
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

@Composable
fun LineProgressComponent(progress: Double, progressBarColor: Color, modifier: Modifier) {
    val animateFloat by remember { mutableStateOf(Animatable(0f)) }
    LaunchedEffect(animateFloat) {
        animateFloat.animateTo(
            targetValue = progress.toFloat(),
            animationSpec = tween(durationMillis = 1000, easing = FastOutLinearInEasing)
        )
    }

    Canvas(modifier = modifier) {
        drawLine(
            start = Offset(x = 0f, y = 1f),
            end = Offset(x = size.width, y = 1f),
            color = Color.White,
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

@Dark
@Light
@Composable
fun WeightProgressBar(
    modifier: Modifier = Modifier,
    startedWeight: Double = 278.0,
    currentWeight: Double = 288.0,
    targetWeight: Double= 290.0
) {

    val weightProgress = ScreenUtil.calculateWeightProgressAsFraction(startedWeight, currentWeight, targetWeight)

    Box(contentAlignment = Alignment.Center, modifier = modifier) {
        CircleProgressComponent(
            false,
            weightProgress,
            if (ScreenUtil.isOnTrack(
                    startedWeight,
                    currentWeight,
                    targetWeight
                )
            ) PrimaryBlue else Color.Red,
            canvasSize = 200,
            modifier = Modifier.size(150.dp)
        )

        Text(
            text = "${ScreenUtil.formatWeightProgress(startedWeight, currentWeight, targetWeight)} target weight",
            fontSize = 18.sp,
            textAlign = TextAlign.Center,
            modifier = Modifier.padding(2.dp)
        )
    }
}