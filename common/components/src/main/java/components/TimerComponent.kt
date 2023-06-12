package components


import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.fitness.shapify.theme.PrimaryBlue
import com.fitness.shapify.theme.PrimaryWhite
import kotlinx.coroutines.delay
import kotlin.time.Duration.Companion.seconds

data class TimerComponentData(val workOut: String, val duration: Long)
@Preview
@Composable
private fun TimeComponentPreview(){
    TimerComponent(
        listOf(
            TimerComponentData("Bench Press",60L),
            TimerComponentData("Rest",10L),
            TimerComponentData("Jump Rope",30L),
            TimerComponentData("Rest",10L)
        ),
        color = PrimaryBlue, Modifier) {

    }
}

@Composable
fun TimerComponent(intervals: List<TimerComponentData>, color: Color, modifier: Modifier, onComplete: (index: Int) -> Unit) = Box(contentAlignment = Alignment.Center, modifier = modifier.wrapContentSize()) {
    var index by remember {
        mutableStateOf(0)
    }

    var workOut by remember {
        mutableStateOf(intervals[index].workOut)
    }

    var time by remember {
        mutableStateOf(intervals[index].duration)
    }

    CircleProgressComponent(true, progress = time.toFloat()/intervals[index].duration, progressColor = color, canvasSize = 200, modifier = Modifier.padding(3.dp))

    Column(verticalArrangement = Arrangement.Center, horizontalAlignment = Alignment.CenterHorizontally, modifier = Modifier.wrapContentSize()) {
        Text(text = time.toString(), fontSize = 36.sp, color = PrimaryBlue)

        Text(text = if(index == intervals.lastIndex)  "Complete" else workOut, fontSize = 18.sp, fontWeight = FontWeight.Light, color = PrimaryBlue)
    }

    LaunchedEffect(Unit) {
        while(time > 0) {
            delay(1.seconds)
            time--

            if(time == 0L && index < intervals.lastIndex){
                index++
                workOut = intervals[index].workOut
                time = intervals[index].duration

                onComplete(index)
            }
        }
    }

}

