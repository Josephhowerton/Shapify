package com.fitness.onboarding

import android.content.res.Configuration
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout
import com.fitness.shapify.theme.ShapifyTheme

@Preview(showBackground = true)
@Composable
private fun LightPreview() {
    ShapifyTheme {
        Surface {
            OnboardingScreenTwo()
        }
    }
}

@Preview(
    showBackground = true,
    uiMode = Configuration.UI_MODE_NIGHT_YES
)
@Composable
private fun DarkPreview() {
    ShapifyTheme {
        Surface {
            OnboardingScreenTwo()
        }
    }
}


@Composable
fun OnboardingScreenTwo(onNextTap: () -> Unit = {}) = ConstraintLayout(modifier = Modifier.fillMaxSize()) {
    val (titleRef, nextButtonRef) = createRefs()

    val topGuideline = createGuidelineFromTop(.5f)
    Text(text = "OnboardingScreenTwo",
        modifier = Modifier
            .padding(5.dp)
            .constrainAs(titleRef) {
                bottom.linkTo(topGuideline)
                end.linkTo(parent.end)
                start.linkTo(parent.start)
            }
    )

    Button(onClick = onNextTap,
        modifier = Modifier
            .padding(15.dp)
            .constrainAs(nextButtonRef) {
                top.linkTo(topGuideline)
                end.linkTo(parent.end)
                start.linkTo(parent.start)
            }
    ) {
        Text(text = "Next",
            modifier = Modifier.padding(5.dp),
            maxLines = 1
        )
    }
}