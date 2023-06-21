package components

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout
import com.fitness.framework.extensions.Dark
import com.fitness.framework.extensions.Light
import com.fitness.shapify.theme.ShapifyTheme
import com.fitness.theme.R

@Light
@Dark
@Composable
fun LongHealthComponent(
    modifier: Modifier = Modifier.fillMaxWidth().height(150.dp),
    title: String = stringResource(id = R.string.todays_workout_plan),
    description: String = stringResource(id = R.string.calories_consumed_out, 1200f, 1800f)
) {
    ShapifyTheme {
        Card(
            modifier = modifier,
            elevation = CardDefaults.cardElevation(defaultElevation = 3.0.dp),
            colors = CardDefaults.cardColors()
        ) {
            ConstraintLayout(
                Modifier
                    .fillMaxSize()
            ) {

                val startGuideline = createGuidelineFromStart(.1f)
                val topGuideline = createGuidelineFromTop(.1f)

                val (titleRef, descriptionRef) = createRefs()

                Text(
                    text = title,
                    fontSize = 18.sp,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier.constrainAs(titleRef) {
                        top.linkTo(topGuideline)
                        bottom.linkTo(descriptionRef.top)
                        start.linkTo(startGuideline)
                    })

                Text(
                    text = description,
                    fontSize = 12.sp,
                    fontWeight = FontWeight.Normal,
                    modifier = Modifier.constrainAs(descriptionRef) {
                        top.linkTo(titleRef.bottom)
                        bottom.linkTo(parent.bottom)
                        start.linkTo(startGuideline)
                    })
            }
        }
    }
}