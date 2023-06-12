package com.fitness.onboarding

import android.content.res.Configuration
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.constraintlayout.compose.Dimension
import com.fitness.navigation.FeatureEntry
import com.fitness.shapify.theme.ShapifyTheme
import com.fitness.theme.R

@Preview(showBackground = true)
@Composable
private fun LightPreview() {
    ShapifyTheme {
        Surface {
            OnboardingScreenThree()
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
            OnboardingScreenThree()
        }
    }
}


@Composable
fun OnboardingScreenThree(onNextTap: () -> Unit = {}) = ConstraintLayout(modifier = Modifier.fillMaxSize()) {
    val (titleRef, nextButtonRef) = createRefs()

    val topGuideline = createGuidelineFromTop(.5f)
    Text(text = "OnboardingScreenThree",
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